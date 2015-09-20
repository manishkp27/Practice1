package com.thread;

import java.util.Iterator;
import java.util.Set;

public class SleepDemo {

	public static void main(String[] args) {
		TaskA taskA = new TaskA();
		Thread th1 = new Thread(taskA,"t1");
		Thread th2 = new Thread(taskA,"t2");
		
		th1.start();
		th2.start();
	}
}

class TaskA implements Runnable{
	int counter;
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+": TaskA.run() start");
		
		for(counter=0;counter<10_000;counter++){
			if(counter%50==0 && Thread.currentThread().getName().equals("t1")){
				try {
					Thread.sleep(1_000);
					
					if(Thread.interrupted()){
						System.out.println("t1 : Thread.interrupted()="+Thread.interrupted());
						throw new InterruptedException();
					}
				} catch (InterruptedException e) {
					System.out.println("t1: ERROR:"+e.getMessage() + " Thread.interrupted()="+Thread.interrupted());
				}
				System.out.println("t1: after sleep counter="+counter);
			}
			else if(counter==2_000 && Thread.currentThread().getName().equals("t2")){
				Thread th = getRunningThreadFromName("t1");
				System.out.println("t2: interrupt t1, counter="+counter);
				th.interrupt();
			}
		}
	}
	
	//get thread t1 object from t2
	Thread getRunningThreadFromName(String threadName){
		Set<Thread> thSet =Thread.getAllStackTraces().keySet();
		
		Iterator<Thread> iterator = thSet.iterator();
		while(iterator.hasNext()){
			Thread next = iterator.next();
			if(next.getName().equals(threadName)){
				return next;
			}
		}
		return null;
	}
}
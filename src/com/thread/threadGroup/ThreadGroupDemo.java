package com.thread.threadGroup;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("subgroup 1");
		Thread  t1= new Thread(tg,"thread 1"),
				t2= new Thread(tg,"thread 2"),
				t3= new MyThread(tg,"thread 2");t3.start();
		tg = new ThreadGroup("subgroup 2");
		Thread t4= new MyThread(tg,"my thread");t4.start();
		
		tg= Thread.currentThread().getThreadGroup();
		
		System.out.println(tg.getName()+" "+tg.activeGroupCount()+" CountOfActiveThreadGroups"+tg.activeCount());
		tg.list();
		
		/*synchronized("A"){
			"A".notifyAll();
		}*/
		tg.interrupt();
	}

}

class MyThread extends Thread{
	public MyThread(ThreadGroup tg, String string) {
	
	}
	public void run(){
		try {
			//Thread.sleep(999);
			synchronized("A"){
				"A".wait();
			}
		} catch (InterruptedException e) {System.out.println("ERROR:InterruptedException");}
		
		System.out.println("exiting thread:"+Thread.currentThread().getName());
	}
}
package com.thread;

public class SleepVsWait {

	public static void main1(String[] args) throws InterruptedException {
		
		//thread static methods
		Thread.sleep(10000);
		Thread.yield();
		
		Thread.activeCount();
		Thread.currentThread();
		Thread.holdsLock(new Object());
		
		//thread non-static methods
		Thread th= new Thread();
		
		th.join();
		th.notify();
		th.wait();
		th.wait(1000);
		
	}
	void func() throws InterruptedException{
		System.out.println("func():\n"+this+" \t"+Thread.currentThread());
		//this.join();
		/*this.notify();
		this.wait();
		this.wait(1000);*/
	}
	public static void main(String[] args) throws InterruptedException {
		String resource="m";
		
		MyThreadA myThread1 = new MyThreadA(resource);
		MyThreadA myThread2 = new MyThreadA(resource);
		System.out.println("main start thread1");
		
		
		myThread1.start();
		/*Thread.sleep(1000);
		synchronized(myThread1){myThread1.notify();}*/
		System.out.println("main notify thread1");
		
		myThread2.start();
		/*Thread.sleep(1000);
		synchronized(myThread2){myThread2.notify();}*/
		System.out.println("main notify thread2");
		
	}	

}

class MyThreadA extends Thread{
	String resource=null;
	MyThreadA(String resource){
		this.resource=resource;
	}
	public void run(){
		try {
			
			synchronized(resource){
				System.out.println("MyThread: before sleep() "+currentThread().getName());
				//wait();
				//resource.wait(10000);
				Thread.sleep(10000);
				System.out.println("MyThread: after 1 sleep()"+currentThread().getName());
				//wait();
				//resource.wait(10000);
				Thread.sleep(10000);
				System.out.println("MyThread: after 2 sleep()"+currentThread().getName());
			}
			
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
class MyRunnableA implements Runnable{
	public void run(){
		System.out.println("MyRunnable:\n"+this+" \t"+Thread.currentThread());
	}
}
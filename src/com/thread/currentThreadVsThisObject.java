package com.thread;

public class currentThreadVsThisObject {

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
		currentThreadVsThisObject sleepVsWait = new currentThreadVsThisObject();
		sleepVsWait .func();
		
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
		
		MyThread myThread = new MyThread();
		myThread.start();
	}	

}

class MyThread extends Thread{
	public void run(){
		System.out.println("MyThread:\n"+this.hashCode()+" \t"+Thread.currentThread().hashCode());
	}
}
class MyRunnable implements Runnable{
	public void run(){
		System.out.println("MyRunnable:\n"+this+" \t"+Thread.currentThread());
	}
}
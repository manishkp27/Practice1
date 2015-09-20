package com.thread;

public class ShutdownHook {

	public static void main(String[] args) throws InterruptedException {
		/*Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread1());
		System.out.println("press Ctrl+c to stop");
		Thread.sleep(9000);
		System.out.println("main is over");
		*/
		Thread th = new Thread(new MyThread1());
		th.run();
	}

}

class MyThread1 extends Thread{
	
	public void run(){
		System.out.println("MyThread Completed");
	}
}

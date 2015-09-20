package com.thread;

public class ThreadWaitNotifyJoin {

	public static void main(String[] args) throws InterruptedException {
		new test().start();
	}

}
class test{
	void start() throws InterruptedException{
		ThreadB b = new ThreadB();
		System.out.println("test started");
		b.start();
		
		b.join();
		for(int i=0;i<100000;i++){}
		synchronized(b){
			System.out.println("Sync test strted total="+b.total);
			for(int i=0;i<10000;i++){}
			System.out.println("Sync wait strted total="+b.total);
			b.wait();
			
			System.out.println("total="+b.total);
		}
		System.out.println("total="+b.total);
	}
}

class ThreadB extends Thread{
	int total;
	public void run(){
		System.out.println("ThreadB started");
		synchronized(this){
			System.out.println("sync ThreadB strted");
			for(int i=0;i<1000;i++){
				total=i;
			}
			System.out.println("ThreadB notify result");
			notify();
		}
	}
}
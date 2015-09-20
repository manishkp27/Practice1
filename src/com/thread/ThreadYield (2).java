package com.thread;

public class ThreadYield implements Runnable{

	Thread t;
	ThreadYield(String name){
		t=new Thread(this,name);
		t.start();
	}
	public void run(){
		
		for(int i=1;i<=5;i++){
			if(i%5!=0){
				System.out.println(Thread.currentThread().getName()+" yielding");
				Thread.yield();
				System.out.println(Thread.currentThread().getName()+" finished execution");
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadYield("th1");
		new ThreadYield("th2");
		new ThreadYield("th3");
	}

}

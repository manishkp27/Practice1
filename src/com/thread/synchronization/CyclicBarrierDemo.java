package com.thread.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//http://tutorials.jenkov.com/java-util-concurrent/cyclicbarrier.html
public class CyclicBarrierDemo {
	public static void main(String[] args){
		Runnable barrier1Action = ()-> {System.out.println("BarrierAction 0 executed ");};
		Runnable barrier2Action = ()-> {System.out.println("BarrierAction 1 executed ");};
		
		CyclicBarrier barrier1 = new CyclicBarrier(3,barrier1Action);
		//CyclicBarrier barrier2 = new CyclicBarrier(3,barrier2Action);
		
		CyclicBarrierUser barrierUser1 = new CyclicBarrierUser(barrier1);//, barrier2);
		CyclicBarrierUser barrierUser2 = new CyclicBarrierUser(barrier1);//, barrier2);
		CyclicBarrierUser barrierUser3 = new CyclicBarrierUser(barrier1);//, barrier2);
		
		new Thread(barrierUser1).start();
		new Thread(barrierUser2).start();
		new Thread(barrierUser3).start();
	}
}

class CyclicBarrierUser implements Runnable{
	CyclicBarrier barrier1=null,barrier2=null ;
	
	CyclicBarrierUser(CyclicBarrier barrier1){//,CyclicBarrier barrier2){
		this.barrier1=barrier1;
		//this.barrier2=barrier2;
	}
	public void run(){
		try {
	        System.out.println(Thread.currentThread().getName() +" waiting at barrier 0");
	        barrier1.await();
	        
            /*System.out.println(Thread.currentThread().getName() +" waiting at barrier 1");            
            this.barrier2.await();*/

            System.out.println(Thread.currentThread().getName() +" done!");
		} catch (InterruptedException | BrokenBarrierException e) {e.printStackTrace();}
	}
}

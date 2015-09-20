package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {  
    public static void main(String[] args) throws InterruptedException {  
       ExecutorService executorService = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
       for (int i = 0; i < 15; i++) {  
           Runnable worker = new MyThread("" + i);  
    	   //Thread worker = new MyThread("" + i);
           executorService.execute(worker);//calling execute method of ExecutorService
           //worker.run();
         }
       executorService.shutdown();  
       System.out.println("shutDown() started");
       while (!executorService.isTerminated()) {System.out.println("isTerminated()"); Thread.sleep(200); }  
 
       System.out.println("Finished all threads");  
   }  
} 

class MyThread implements Runnable{
//class MyThread extends Thread{
	String message;
	MyThread(String message){
		this.message=message;
	}
	
	public void run() {
		  try {
			  System.out.println(this.message);
			  Thread.sleep(200);  } catch (InterruptedException e) { e.printStackTrace(); }  
	}
}
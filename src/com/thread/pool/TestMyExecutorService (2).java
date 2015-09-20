package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMyExecutorService {

	public static void main(String[] args) throws Exception {
		// ExecutorService executorService = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
		MyExecutorService pool = new MyExecutorService(3, 7);
		for (int i = 0; i < 15; i++) {
			Runnable worker = new MyTask("msg" + i);
			pool.execute(worker);// calling execute method of ExecutorService
		}
		//pool.stop();
		
		System.out.println("shutDown() started");
		while (!pool.isStopped) {
			System.out.println("isTerminated()");
			Thread.sleep(200);
		}

		System.out.println("Finished all threads");
	}
}

class MyTask implements Runnable {
	String message;

	MyTask(String message) {
		this.message = message;
	}

	public void run() {
		try {
			System.out.println("MyTask Started:"+this.message);
			Thread.sleep(2000);
			System.out.println("MyTask over:"+this.message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
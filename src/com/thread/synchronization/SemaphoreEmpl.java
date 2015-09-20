package com.thread.synchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreEmpl {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		new SendingThread(semaphore).start();
		new ReceivingThread(semaphore).start();
	}
	
}

class SendingThread extends Thread{
	Semaphore semaphonre=null;
	SendingThread(Semaphore semaphonre){this.semaphonre=semaphonre;}
	public void run(){
		try {semaphonre.acquire();} catch (InterruptedException e) {e.printStackTrace();}
	}
}

class ReceivingThread extends Thread{
	Semaphore semaphonre=null;
	ReceivingThread(Semaphore semaphonre){this.semaphonre=semaphonre;}
	public void run(){
		semaphonre.release();
	}
}
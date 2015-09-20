package com.thread.synchronization;

public class MySemaphore {
	private int counter;
	MySemaphore(){this(0);}
	MySemaphore(int i){
		counter=i;
	}
	
	synchronized void acquire() throws InterruptedException{
		System.out.println("...........acquire...............counter="+counter);
		while(counter==0){
			System.out.println("in acquire.................");
			wait();
		}
		counter--;
		System.out.println("acquire() counter--="+counter);
	}
	synchronized void release(){
		System.out.println("...........release...............counter="+counter);
		if(counter==0){
			notify();
		}
		counter++;
		System.out.println("release() counter++="+counter);
	}
	public static void main(String[] args) {
		MySemaphore semaphore = new MySemaphore(1);
		new SendingTh(semaphore).start();
		//new ReceivingTh(semaphore).start();
		new SendingTh(semaphore).start();
	}
}

class SendingTh extends Thread{
	MySemaphore semaphonre=null;
	SendingTh(MySemaphore semaphonre){this.semaphonre=semaphonre;}
	public void run(){
		try {System.out.println("acquiring semaphore..");
			semaphonre.acquire();
			System.out.println("got semaphore!");
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
class ReceivingTh extends Thread{
	MySemaphore semaphonre=null;
	ReceivingTh(MySemaphore semaphonre){this.semaphonre=semaphonre;}
	public void run(){
		System.out.println("releasing semaphore..");
		semaphonre.release();
		System.out.println("released semaphore!");
	}
}

package com.thread;
public class ThreadWaitNotifNotifAll {
	public static void main(String[] args) throws InterruptedException {
		Message1 msg = new Message1(" Notifier Work Pending");
		new Thread (new Waiter(msg),"waiter1").start();
		new Thread (new Waiter(msg),"waiter2").start();
		new Thread (new Notifier(msg),"notifier").start();
		System.out.println("all threads started");
		
		//Thread.sleep(100, 11);
	}
}

class Waiter implements Runnable{
	private Message1 msg;
	Waiter(Message1 msg){ this.msg=msg; }
	
	public void run(){
		synchronized(msg){
			System.out.println(Thread.currentThread().getName()+" waiting "+ System.currentTimeMillis());
			try {
				msg.wait();
				//msg.notify();
			} catch (InterruptedException e) {e.printStackTrace(); }
			System.out.println(Thread.currentThread().getName()+" notified "+ System.currentTimeMillis()+" processed:"+msg.msg);
		}
	}
}
class Notifier implements Runnable{
	private Message1 msg;
	Notifier(Message1 msg){ this.msg=msg; }
	
	public void run(){
			System.out.println(Thread.currentThread().getName()+" started ");
			//try {
				//Thread.sleep(1000);
				synchronized(msg){
					msg.msg = Thread.currentThread().getName()+" Notifier Work Done";
					//msg.notify();
					//msg.notify();
					msg.notifyAll();
				}
			//} catch (InterruptedException e) {e.printStackTrace(); }
	}
}

class Message1 {
    String msg;
    public Message1(String str){
        this.msg=str;
    } 
}
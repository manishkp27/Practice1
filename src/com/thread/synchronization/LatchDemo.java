package com.thread.synchronization;

import java.util.concurrent.CountDownLatch;

public class LatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter      waiter      = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
	
		new Thread(waiter)     .start();
		new Thread(decrementer).start();
	}
}

class Waiter implements Runnable{
    CountDownLatch latch = null;
    public Waiter(CountDownLatch latch) {this.latch = latch;}

    public void run() {
    	try {System.out.println("waiter start...");
    		latch.await();} catch (InterruptedException e) {e.printStackTrace();
    	}
    	System.out.println("waiter released");
    }
}
class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            //Thread.sleep(1000);
            latch.countDown();
            System.out.println(latch.getCount());
            
            Thread.sleep(1000);
            latch.countDown();
            System.out.println(latch.getCount());
            
            Thread.sleep(1000);
            latch.countDown();
            System.out.println(latch.getCount());
        }catch (InterruptedException e) {e.printStackTrace();}
    }
}
/*public void testWaitNotify() throws Exception {
	final Object mutex = new Object();
	Thread t = new Thread() {
				public void run() {
					// we must acquire the lock before waiting to be notified
					synchronized (mutex) {
						System.out.println("Going to wait " +"(lock held by " + Thread.currentThread().getName() + ")");
						try {
							mutex.wait();  // this will release the lock to be notified (optional timeout can be supplied)
						} catch (InterruptedException e) {e.printStackTrace();}
						System.out.println("Done waiting " +"(lock held by " + Thread.currentThread().getName() + ")");
					}
				}
	};
	t.start(); // start her up and let her wait()

	// not normally how we do things, but good enough for demonstration purposes
	Thread.sleep(1000);

	// we acquire the lock released by wait(), and notify()
	synchronized (mutex) {
		System.out.println("Going to notify " +"(lock held by " + Thread.currentThread().getName() + ")");
		mutex.notify();
		System.out.println("Done notify " +"(lock held by " + Thread.currentThread().getName() + ")");
	}
}*/

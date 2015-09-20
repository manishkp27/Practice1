package com.thread.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Phaser;
import java.util.*;

public class PhaserDemo {

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser = new Phaser();
		phaser.register();
		int phasecount = phaser.getPhase();
		System.out.println("Phasecount is "+phasecount);

		new PhaserDemo().testPhaser(phaser,2000);//phaser waiting for 2 parties
		new PhaserDemo().testPhaser(phaser,4000);//phaser waiting for 3 parties
		new PhaserDemo().testPhaser(phaser,6000);//phaser waiting for 4 parties
		
		//now that all threads are initiated, we will de-register main thread 
		//so that the barrier condition of 3 thread arrival is meet.
		phaser.arriveAndDeregister();
        Thread.sleep(10000);
        phasecount = phaser.getPhase();
		System.out.println("Phasecount is "+phasecount);
	}
	
	
	void testPhaser(final Phaser phaser,final int sleepTime){
		phaser.register();
		
		new Thread() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + " arrived");
					phaser.arriveAndAwaitAdvance();//threads register arrival to the phaser.
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {e.printStackTrace();}
				System.out.println(Thread.currentThread().getName()+" after passing barrier");
			}
		}.start();
		
	}
}

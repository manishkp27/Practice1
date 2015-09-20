package com.thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		SharedData sharedData= new SharedData();
		Thread t1 = new Thread(new Th1(sharedData));
		Thread t2 = new Thread(new Th2(sharedData));
		t1.start();
		t2.start();
		
		
		System.out.println("Main activeCount:"+Thread.activeCount());
		System.out.println("Thread Id:"+Thread.currentThread().getId());
		
		//t1.interrupt();
		System.out.println("t1.interrupted()="+t1.interrupted());
		
		System.out.println("t1.holdsLock="+t1.holdsLock(sharedData)+" t1.holdsLock="+t2.holdsLock(sharedData));
		System.out.println("t1.isAlive()="+t1.isAlive()+" t1.isAlive()="+t2.isAlive());
		Thread.sleep(100);
		//Thread.dumpStack();
	}

}
class SharedData{
	public Integer i,j;
	void func1() 
	{	for(i=0;i<100;i++)
		{	
			if(i%10==0)
				System.out.println("Th1.run() i="+i);
			if(i==50)
			{	synchronized(i)
				{	try {//wait();
					System.out.println("this.holdsLock="+Thread.currentThread().holdsLock(i));
						i.wait();
						} 
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}
	}
	void func2()
	{	System.out.println("activeCount:"+Thread.activeCount());
		for(j=0;j<100;j++)
		{	
			if(j%10==0)
				System.out.println("Th2.run() ---j="+j);
			if(j==80)
			{	synchronized(this){notify();}
			}
		}
	}
}

class Th1 implements Runnable{
	SharedData sharedData;
	Th1(SharedData sharedData){
		this.sharedData=sharedData;
	}
	public void run() {
		System.out.println("Th1.run()");
		sharedData.func1();
		/*for(int i=0;i<100;i++)
		{	if(i%10==0)
				System.out.println("Th1.run() i="+i);
			if(i==50)
			{	try {
				synchronized(this){wait();}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
}
class Th2 implements Runnable{
	SharedData sharedData;
	Th2(SharedData sharedData){
		this.sharedData=sharedData;
	}
	public void run() {
		System.out.println("Th2.run()");
		sharedData.func2();
		/*for(int j=0;j<100;j++){
			if(j%10==0)
				System.out.println("Th2.run() ---j="+j);
			if(j==80)
			{	synchronized(this){notify();}
			}
		}*/
	}
}
package com.thread.synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo {
	public static void main(String[] args) throws InterruptedException {
		Account fromAccount = new Account(100);
		Account toAccount= new Account(0);
		
		Transaction transaction =new Transaction(fromAccount,toAccount,20);
		new Thread(transaction,"Th1").start();
		//Thread.sleep(100);
		//System.out.println("fromAccount="+fromAccount.amount +" toAccount="+toAccount.amount);
		
		transaction =new Transaction(toAccount,fromAccount,15);
		new Thread(transaction,"Th2").start();
		Thread.sleep(100);
		System.out.println("fromAccount="+fromAccount.amount +" toAccount="+toAccount.amount);
	}

}

class Transaction implements Runnable{
	private Account fromAccount,toAccount;
	private int amount;
	Transaction(Account fromAccount,Account toAccount,int amount){
		this.fromAccount=fromAccount;
		this.toAccount=toAccount;
		this.amount=amount;
	}
	public void run(){
		//System.out.println(Thread.currentThread().getName()+" Transaction Status::"+transferMoneyWithTryLock(amount));
		transferMoneyWithTryLock(amount);
	}
	
	boolean transferMoneyWithTryLock(int amount){
		long stopTime = System.nanoTime()+900_000;
		int tryCount = 1;
		while(true){
			if(fromAccount.rLock.tryLock()){
				System.out.println(Thread.currentThread().getName()+" got 1st, Trying 2nd lock:"+" attempt:"+tryCount++);
				try{
					if(toAccount.rLock.tryLock()){
						System.out.println(Thread.currentThread().getName()+" 2nd lock accquired");
						try{
							fromAccount.debit(amount);
							toAccount.credit(amount);
							return true;
						}
						finally{
							System.out.println(Thread.currentThread().getName()+" Releasing 2nd lock");
							toAccount.rLock.unlock();
						}
					}
				}
				finally{
					System.out.println(Thread.currentThread().getName()+" Releasing 1st lock");
					fromAccount.rLock.unlock();
				}
			}
			if(System.nanoTime()>stopTime ){
				System.out.println(Thread.currentThread().getName()+" Timedout..Failed to do transaction :)");
				return false;
			}
		}//while
	}
}

class Account{
	ReentrantLock rLock=new ReentrantLock();
	volatile float amount;
	
	Account(float amount){
		this.amount = amount;
	}	
	void debit(float amount){
		this.amount-= amount;
		System.out.println("Debited="+amount);
	}
	void credit(float amount){
		this.amount+= amount;
		System.out.println("Crebited="+amount);
	}
}

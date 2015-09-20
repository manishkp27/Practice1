package com.manish;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.lang.mutable.MutableBoolean;
public class SharedResources {
	static boolean flag;
	public static void main(String[] args) throws InterruptedException {
		//F f=new F();
		
		//using shared resources
		AtomicBoolean flag=new AtomicBoolean(false);
		/*T1 t1= new T1(flag);
		T2 t2= new T2(flag);
		t1.start();
		t2.start();*/
		
		//using wait/notify
		int i=1;
		C1 c= new C1(flag);
		c.start();
		while(i<10){
			synchronized(flag){
				System.out.println("main:"+i);
				i+=2;
				flag.notify(); 
				if(i<10) 
					flag.wait();
				
			}
		}
		System.out.println("main complete");
	}

}

class C1 extends Thread{
	int i=2;
	AtomicBoolean flag;
	C1(AtomicBoolean flag){
		this.flag=flag;
	}
	public void run(){
		while(i<11){
			synchronized(flag){
				System.out.println("C1:"+i);
				i+=2;
				try {
					flag.notify(); 
					if(i<11) 
						flag.wait();
				} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
		System.out.println("C1 complete");
	}
}


class T1 extends Thread{
	AtomicBoolean flag;
	int i=1;
	T1(AtomicBoolean flag){
		this.flag=flag;
	}
	public void run(){
		while(i<10){
			synchronized(flag){
				if(flag.get()==false){
					System.out.println("T1:"+i);i+=2;flag.compareAndSet(false, true);
				}
			}
		}
	}
}
class T2 extends Thread{
	AtomicBoolean flag;
	int i=2;
	T2(AtomicBoolean flag){
		this.flag=flag;
	}
	public void run(){
		while(i<11){
			synchronized(flag){
				if(flag.get()==true){
					System.out.println("T2:"+i);i+=2;flag.compareAndSet(true,false);
				}
			}
		}
	}
}

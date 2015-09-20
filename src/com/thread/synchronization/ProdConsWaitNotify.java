package com.thread.synchronization;

public class ProdConsWaitNotify {

	Object full = new Object();
	Object empty = new Object();
	Object data=null;
	
	public void push (Object o){		
		synchronized(full){
			if(data!=null){
				try {full.wait();} catch (InterruptedException e) {e.printStackTrace();}
			}
		}	
		data=o;
		synchronized(empty){
			if(data!=null){empty.notify();}
		}
	}
	
	public Object pop (){
		synchronized(empty){
			if(data==null){
				try {empty.wait();} catch (InterruptedException e) {e.printStackTrace();}
			}
		}
		Object t=data;
		data=null;
		synchronized(full){
			if(data==null){full.notify();}
		}
		return t;
	}
	
	class Producer implements Runnable{
		public void run(){
			int i=0;
			while(true)
				push(new String("obj"+i++));
		}
	}
	
	class Consumer implements Runnable{
		public void run(){
			int i=0;
			while(true){
				String d = (String)pop();
				System.out.println(d);
			}
		}
	}
	
	public static void main(String[] args) {
		ProdConsWaitNotify pcwn = new ProdConsWaitNotify();
		(new Thread(pcwn. new Producer())).start();
		(new Thread(pcwn. new Consumer())).start();
	}

}



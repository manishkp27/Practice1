package com.thread.synchronization;

public class ProdConsBusyWait {

	Object data=null;
	void push (Object o){
		while(data!=null){}
		
		data=o;
	}
	Object pop (){
		while(data==null){}
		
		Object t=data;
		data=null;
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
		ProdConsBusyWait sm = new ProdConsBusyWait();
		/*SemaphoreMechanism.Producer p = sm. new Producer();
		SemaphoreMechanism.Consumer c = sm. new Consumer();*/
		(new Thread(sm. new Producer())).start();
		(new Thread(sm. new Consumer())).start();
		
	}

}

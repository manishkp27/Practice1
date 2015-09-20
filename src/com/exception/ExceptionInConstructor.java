package com.exception;

public class ExceptionInConstructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyContructorExc my = new MyContructorExc();
		System.out.println(my.i);

	}

}
class MyContructorExc{
	int i=-1;
	MyContructorExc(){
		try{
			i=1/0;
			//return;
		}catch(Exception e){e.printStackTrace();}
	}
}
package com.java8;

public class LambdaDemo {

	public static void main(String[] args) {
		//before jdk8
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("MyRunnable.run()");
			}
		};
		new Thread(r).start();
		
		//lanbda
		Runnable r2= () -> {System.out.println("MyRunnable.run() lambda");};
		new Thread(r2).start();
		
		//own interface
		MyClass m = () -> {System.out.println("MyClass.myMethod() lambda");};
		
	}

}

interface MyClass{
	void myMethod();
}

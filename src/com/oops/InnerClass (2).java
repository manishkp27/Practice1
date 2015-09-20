package com.oops;

public class InnerClass {

	public static void main(String[] args) {
		Runnable createRunnable = Outer.createRunnable();
		//Runnable createRunnable1 = new Outer.Inner();
	}

}

class Outer{
	private static class Inner implements Runnable{
		private int a;
		Inner(){	
			a=1;System.out.println("Outer.Inner.Inner()");	
		}
		public void run() {}
	}
	public static Runnable createRunnable(){
		System.out.println("Outer.createRunnable()");
		return new Inner();
	}
}

class Class1{
	static class Class11{
		
	}
}


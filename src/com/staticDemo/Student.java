package com.staticDemo;

public class Student{
	//final int f1;//=1;
	int i=-11;
	static final int statFinal;
	
	{
		i=statFinal;
		System.out.println("Student: non static block i="+i);
	}
	
	static{
		System.out.println("Student: static block ");
		statFinal=1;
	}
	
	/*Student(){
		System.out.println("Student() constructor i="+i);
		f1=1;
	}*/
	final void func1(){
		final int f2;
		int j=10;
		this.i=10;
		//System.out.println(f2);
	}
	static void staticFunction(){
		System.out.println("Student.staticFunction()");
	}
}

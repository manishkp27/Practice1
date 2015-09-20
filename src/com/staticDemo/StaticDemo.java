package com.staticDemo;

public class StaticDemo {
	
	{
		System.out.println("StaticDemo: non static block i=");
	}
	
	static{
		System.out.println("StaticDemo: static block ");
	}
	
	public static void main(String[] args) {
		System.out.println("StaticDemo.main()");
		Student s;
		System.out.println(Student.class.getName());
		//Student.staticFunction();
		//s= new Student();		
		//Student s2 = new Student();
		
		//StaticDemo demo = new StaticDemo();
	}
}

class Student1 {
	void func1(int a){
		
	}
}
final class Steudent2{
	
}
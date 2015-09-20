package com.staticDemo;

public class StaticTest {

	public static void main(String[] args) {
		SuperClass sup = new SuperClass();
		sup.display();
		SubClass sub1 = new SubClass();
		sub1.display();
	}

}
class SuperClass{
	static void display(){
		System.out.println("display()SuperClass");
	}
}
class SubClass extends SuperClass{
	// “The instance method cannot hide the static method from super class”
	//void display(){//This instance method cannot override the static method from SuperClass
	static void display(){
		System.out.println("display()SubClass");
	}
}
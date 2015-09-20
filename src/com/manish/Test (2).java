package com.manish;
import java.util.*;
public class Test {
	static int test =test();
	
	public static void main(String[] args) {
		Cl1 c1= new Cl2();
		//c1.func1();
		
		int i=20;
		Class c=c1.getClass();
		System.out.println(c.getName() +" "+Cl1.class.getName());
		
		Test111 t=new Test111();
	}
	static int test( ){
		return 55;
	}
	

}
class Test111{
	static{
		System.out.println("Test111 static block");
	}
}
class Cl1{
	Cl1(){
		//Cl1 c1= new Cl2();
		//c1.func1();
	}
	void func1(){
		
		System.out.println("Cl1.func1()");
	}
}
class Cl2 extends Cl1{
	void func1(){
		System.out.println("Cl2.func1()");
	}
}
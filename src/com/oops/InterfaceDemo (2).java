package com.oops;
public class InterfaceDemo {
	public static void main(String[] args) {
		System.out.println(Intf1.v1);//variables are by default static
		
		Intf1.IntfClasss c = new Intf1.IntfClasss();
	}
}

interface Intf1{
	public static final int psf = 11;//variables are by default Public,static,final others not supported
	//private static final int psf1 = 11; //Only public
	int v1=10;	//variables are by default static
	//int i; 	//variables are static final, so must be initialized
	
	//Intf1(){}//Cant have constructor
	//void func(){}//functions cant have implementation
	void func1();//methods are by default abstract
	//static void func2();//static,private is not allowed, only public and abstract allowed
	
	public class IntfClasss{//define a class inside interface
		IntfClasss(){System.out.println();}
	}
}

interface Intf2 extends Intf1{
	void func2();
}

interface Intf3 extends Intf2{
	void func3();
}

//Can extend multiple interfaces "Interface supports multiple inheritance."
interface Intf4 extends Intf3,Intf2{
	void func4();
	void func3();
}


abstract class abstractCls1 implements Intf4{
	public void func3() {}
	public void func2() {}
	public void func1() {}
	public abstract void func4();
}

class ClsA extends abstractCls1{
	void funcA1() {}

	@Override
	public void func4() {}
}

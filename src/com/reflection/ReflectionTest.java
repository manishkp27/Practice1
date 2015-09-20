package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectionTest {

	public static void main(String[] args) throws Exception {
		MyClass cls = new MyClass();
		Method method = cls.getClass().getMethod("func", null);
		System.out.println(method.getName());
		method.invoke(cls,null);
		
		Class c = Class.forName("com.reflection.MyClass");
		Object o = c.newInstance();
		((MyClass )o).func();
	}
}
class MyClass{
	public void func(){
		System.out.println("MyClass.func()");
	}
}

class ReflectionTest1 {

	public void firstMoveChoice(){
		System.out.println("First Move");
	} 
	public void secondMOveChoice(){
		System.out.println("Second Move");
	}
	public void thirdMoveChoice(){
		System.out.println("Third Move");
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
		ReflectionTest test = new ReflectionTest();
		Method[] method = test.getClass().getMethods();
		//firstMoveChoice
		//method[0].invoke(test, null);
		//secondMoveChoice
		method[1].invoke(test, null);
		//thirdMoveChoice
		method[2].invoke(test, null);
	}
}
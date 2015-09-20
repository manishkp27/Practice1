package com.jvm;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import java.lang.ClassLoader;

public class ClassLoaderDemo extends ClassLoader{

	public static void main(String[] args) {
		//Class r = LoadClass("Test.class",true);
	}
	
	@Override
	protected Class<?> loadClass(String className, boolean resolveIt) throws ClassNotFoundException{
		System.out.println("Load class:"+className);
		
		//Class result = (Class)classes.get();
		
		return null;
	}
}

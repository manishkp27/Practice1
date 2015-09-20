package com.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MultiClassLoader extends ClassLoader{
	static String sourceclassFileFullPath = "D:/EclipseWorkSpace/Practice/Emolpyee1.class";
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
			IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		MultiClassLoader loader = new MultiClassLoader();
		Class cl = loader.loadClass("Emolpyee1");
		System.out.println("*************Loading Completed**********************\n");
		
		System.out.println("got the class:"+cl.getName());
		Method[] methods = cl.getMethods();	System.out.println("methods of class:"+methods[0]);

		//Constructor constructor = cl.getConstructor(null); System.out.println("got the class constructor:"+constructor.getName());
		Constructor[] constructor= cl.getDeclaredConstructors(); System.out.println("got the class 2nd constructor:"+constructor[1]);
		
		//Object o =cl.newInstance();constructor.setAccessible(true);
		//Object o =constructor.newInstance();
		Object o = constructor[1].newInstance("manish","myAddress");
		Method method = cl.getMethod("mailCheck",null);
		//method.setAccessible(true);
		method.invoke(o);
	}
	private HashMap classes = new HashMap();
	private char      classNameReplacementChar;
	
	protected boolean   monitorOn = true;
	protected boolean   sourceMonitorOn = true;

	//---------- Initialization ------------------------------
	public MultiClassLoader() {
	}
	
	public HashMap getClasses(){
		return classes;
	}
	
	//---------- Superclass Overrides ------------------------
	/**
	 * This is a simple version for external clients since they
	 * will always want the class resolved before it is returned
	 * to them.
	 */
	public Class loadClass(String className) throws ClassNotFoundException {
	    return (loadClass(className, true));
	}
	
	//---------- Abstract Implementation ---------------------
	public synchronized Class loadClass(String className,
	        boolean resolveIt) throws ClassNotFoundException {
	
	    Class   result;
	    byte[]  classBytes;
	    System.out.println(">> ***********MultiClassLoader.loadClass(" + className + ", " + resolveIt + ")***********");
	
	    //----- Check our local cache of classes
	    result = (Class)classes.get(className);
	    if (result != null) {
	    	System.out.println(">> returning cached result.");
	        return result;
	    }
	    else
	    	System.out.println(">> Not found in cached");
	
	    //----- Check with the primordial class loader
	    try {
	        result = super.findSystemClass(className);
	        System.out.println(">> returning object from system class (in CLASSPATH).");
	        return result;
	    } catch (ClassNotFoundException e) {
	    	System.out.println(">> Not found in system class.");
	    }
	
	    //----- Try to load it from preferred source
	    // Note loadClassBytes() is an abstract method
	    classBytes = readBytesFromClassFile(sourceclassFileFullPath);
	    if (classBytes == null) {
	    	System.out.println(">> Not found by jarLoader. Not available in jarResources");
	        throw new ClassNotFoundException();
	    }
	
	    //----- Define it (parse the class file)
		System.out.println(">> going in side defineClass()");
	    result = defineClass(className, classBytes, 0, classBytes.length);
	    result = defineClass(className, classBytes, 0, classBytes.length);
	    if (result == null) {
	        throw new ClassFormatError();
	    }
	
	    if (resolveIt) 
	    	resolveClass(result);
	
	    classes.put(className, result);
	    System.out.println(">> Returning newly loaded class :"+result.getName());
	    return result;
	}

	public static byte[] readBytesFromClassFile(String sourceclassFileFullPath){
		File file = new File(sourceclassFileFullPath);
		int len = (int)file.length();
		byte[] raw = new byte[len];
		try {
			FileInputStream fin= new FileInputStream(file);
			int r = fin.read(raw);
			if(r!=len)
				throw new IOException("cant read all");
			System.out.println("readBytesFromClassFile() len:"+r);
			fin.close();
		} catch (IOException e) {e.printStackTrace();}
		
		return raw;
	}
}

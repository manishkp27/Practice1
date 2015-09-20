package com.jvm;

import java.io.Serializable;

public class Emolpyee1 implements Serializable{
	private static final long serialVersionUID = 1111122233;
	public String name;
	public String address;
	public static String address1;
	public static int number;
	public transient int SSN;
	public Object obj;
	
	public void mailCheck(){
		System.out.println("Mailing a check to name:"+name+", address:"+address);
	}
	public Emolpyee1(){
		System.out.println("Constructor call Emolpyee1()");
	}
	public Emolpyee1(String name,String address){
		this.name=name;
		this.address=address;
	}
}

package com.exception;

import java.io.IOException;

public class ExcMethOverride {

	//public static void main(String[] args) throws IOException {
	public static void main(String[] args) {
		try{
			Validate(50);
			TestChiled testChiled = new TestChiled();
			testChiled.msg();
		//} catch (InvalidAge2Exception | InvalidAge1Throwable e) {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		finally{
			//for(int i=0;i<1000;i++);
			System.out.println("completed");
		}
	}
	
	//static void Validate(int age) throws InvalidAge1Throwable,InvalidAge2Exception {
	static void Validate(int age) throws Throwable,Exception {
		if(age<18)
			throw new InvalidAge1Throwable("no vote");
		else if (age<60)
			throw new InvalidAge2Exception("no retirement");
		else if (age<80)
			throw new InvalidAge3RuntimeException("no oldage");
		
	}
}

class InvalidAge1Throwable extends Throwable{
	InvalidAge1Throwable(String s){
		super(s);
	}
}
class InvalidAge2Exception extends Exception{
	InvalidAge2Exception(String s){
		super(s);
	}
}

class InvalidAge3RuntimeException extends RuntimeException{
	InvalidAge3RuntimeException(String s){
		super(s);
	}
}

class TestChiled{
	//void msg()throws IOException{
	void msg(){
	//void msg(){
		System.out.println("TestChiled.msg() child");
		throw new ArithmeticException();
	}
}


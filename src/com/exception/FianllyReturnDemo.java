package com.exception;

import java.util.List;

public class FianllyReturnDemo {
	 public static void main(String[] ar) {
		 System.out.println(test());
	 }
	@SuppressWarnings("unused")
	static String test()
	 {	
		 /*if(true)
			 return "one";//progrom exits here*/
		System.out.println("before try"); 
		try {
			System.out.println("Try started");
			/*if(true)
			{	System.out.println("before try return");
				//return "two";
				//System.exit(1);
			}*/
			throw new NullPointerException("My NullPointerException");
			
			//if an exception were thrown in the try block and not caught. By doing a return from the finally block, 
			//you suppress the exception entirely.
			//int i = 1/0;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			if(true)
			{	System.out.println("before catch return");
				
				if(true)
					throw new NullPointerException("My 2nd NullPointerException");
				
				return "four";
			}
		} finally {
			System.out.println("finally");
			if(true)
			{	System.out.println("before finally return");
				return "five";
			}
		}
		
		System.out.println("out side");
		return "six";
	 }
	 
}

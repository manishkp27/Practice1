package com.exception;

public class ExceptionInCatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			test();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("unused")
	static String test()
	 {	
		try {
			throw new NullPointerException("My NullPointer Exception from try");
			
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			if(true)
				throw new NullPointerException("My 2nd NullPointerException from catch");
		} finally {
			System.out.println("finally");
			//return "return from Finally";
			//if(true)
			//	throw new NullPointerException("My 3rd NullPointerException from finally");
		}
		
		return "returnedSix";
	 }
}

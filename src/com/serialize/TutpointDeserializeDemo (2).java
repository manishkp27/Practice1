package com.serialize;

import java.io.*;

public class TutpointDeserializeDemo {

	public static void main(String[] args) {
		Emolpyee1 e=null;
		try {
			FileInputStream fis = new FileInputStream("employee.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			e = (Emolpyee1)ois.readObject();
			System.out.println("Deserialized Employee...");
		      System.out.println("Name: " + e.name);
		      System.out.println("Address: " + e.address);
		      System.out.println("Address1: " + e.address1);
		      System.out.println("SSN: " + e.SSN);
		      System.out.println("Number: " + e.number);
		      System.out.println("Object string: " + (String)e.obj);
		      System.out.println("thread: " + e.thread);
		      
		      //Super class serialization  
		      System.out.println("super class data emp0: " + e.emp0);
		      
		      //sub class serialization
		      System.out.println("e.emp2.name : " + e.emp2.name);
		      
		      //edit received object
		      e.name="1111111";
		      System.out.println("Name: " + e.name);
		      
		      ois.close();fis.close();
			
		} catch (IOException | ClassNotFoundException ee) {ee.printStackTrace();}
		
	}

}

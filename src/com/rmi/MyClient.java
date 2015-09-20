package com.rmi;
import java.rmi.*;  
public class MyClient{  
public static void main(String args[]){  
	try{
		System.out.println("Client connecting to server...");
		Adder stub=(Adder)Naming.lookup("rmi://10.33.192.248:5000/sonoo");  
		
		System.out.println("Client:response from server :"+stub.Add(34,4));  
	}catch(Exception e){
		e.printStackTrace();
	}  
	}  
}
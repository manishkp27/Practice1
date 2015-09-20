package com.rmi;
//package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MyServer {

	public static void main(String[] args) {
		
		try{
			Adder stub = new AdderRemote();
			Naming.rebind("rmi://10.33.192.248:5000/sonoo", stub);//rmic and rmiregister commands are working on 248server
			System.out.println("Server Started");
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		catch(MalformedURLException e){
			e.printStackTrace();
		}
	}

}

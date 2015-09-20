package com.rmi;
//package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote{
	public int Add(int x,int y)throws RemoteException;

}

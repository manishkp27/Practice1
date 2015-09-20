package com.rmi;
//package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderRemote extends UnicastRemoteObject implements Adder{

	protected AdderRemote() throws RemoteException {
		super();
	}

	@Override
	public int Add(int x, int y) throws RemoteException {
		return x+y;
	}

}

package com.oops;

public class AbstractionDemo {
	public static void main(String[] args) {
		VehicleAbstract my2Wheeler = new TwoWheeler();  
        VehicleAbstract my4Wheeler = new FourWheeler();  
        my2Wheeler.start();  
        my2Wheeler.stop();  
        my4Wheeler.start();  
        my4Wheeler.stop(); 
        
        System.out.println();
	}

}

abstract class VehicleAbstract {  //abstract class may or may not contain abstract method
	public static final int psf = 11;
	private static final int i=0;
	static int j;
	final int k=11;
	
    public abstract void start();
    static void func2(){}
    public void stop(){  
        System.out.println("Stopping Vehicle in abstract class");  
    }  
}  
class TwoWheeler extends VehicleAbstract{  
    public void start() {  
        System.out.println("Starting Two Wheeler");       
    }

	//public abstract void stop(){}//not mandatory to implement nonabstract methods of abstract class  
}  
class FourWheeler extends VehicleAbstract{  
    public void start() {  
        System.out.println("Starting Four Wheeler");  
    }  
}  
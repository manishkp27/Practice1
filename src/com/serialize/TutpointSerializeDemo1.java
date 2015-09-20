package com.serialize;
import java.io.*;
import java.net.Socket;

public class TutpointSerializeDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//getEmployeeObject();
		
	}
	public static Emolpyee1 getEmployeeObject(){
		Emolpyee1 e = new Emolpyee1();
		e.name = "Reyan Ali";
	    e.address = "Phokka Kuan, Ambehta Peer";
	    e.address1 = "Phokka Kuan, Ambehta Peer1";
	    e.SSN = 111223331;
	    e.number = 101;
	    e.obj= new String("manish");
	      
	      
	    //Sub classes should explicitely implement Serializable or make the field transient to avoid NotSerializableException
	    e.thread = new Thread("myThread");
	    //e.outputStream = new ObjectOutputStream(new FileOutputStream("../employee.ser"));
	     
	    //Super class serialization  
	     e.emp0="super Emp0";
	     
	    //sub class serialization to avaoid NotSerializableException
	    e.emp2=new Employee2();
	    e.emp2.name="sub calss2";
	      try {
	    	  FileOutputStream fos = new FileOutputStream("employee.ser");
	    	  ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	  oos.writeObject(e);
	    	  
	    	  //Object clone = SerializationUtils.clone(e);
	    	  //Assert.assertEquals(e,clone);
	    	  
	    	  oos.close();fos.close();
	    	  System.out.printf("Serialized data is saved in employee.ser");
		} catch (IOException e1) {e1.printStackTrace();}
	    
	    return e;
	}
	
	public static byte[] prepareBytesToSend(String className){
		ObjectOutput out = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			out = new ObjectOutputStream(bos);
			if(className.equals("Emolpyee1")){
				out.writeObject(getEmployeeObject());
			}
			else if(className.equals("Employee0")){
					out.writeObject(new Employee0());
			}
			System.out.println("TutpointSerializeDemo1.prepareBytesToSend() length="+bos.toByteArray().length);
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}

//Super class serialization to avoid null value while reading
class Employee0 implements Serializable{
	private static final long serialVersionUID = 1L;
	//class Employee0 {
	String emp0;//="old";
	Employee0(){
		System.out.println("Employee0.Employee0() emp0="+emp0);
	}
}
class Emolpyee1 extends Employee0 implements Serializable{

	public String name;
	public transient String address;
	public static String address1;
	public static int number;
	public transient int SSN;
	public Object obj;
	
	//not serializable library classess
	public transient Thread thread;
	public OutputStream outputStream;
	public Socket socket;
	
	//sub class serialization to avaoid NotSerializableException
	public Employee2 emp2;
	
	// version of class maintained manualy to avoid future InvalidClassException while reading
	private static final long serialVersionUID = 1111122233;
	//int i;
	
	public void mailCheck(){
		System.out.println("Mailing a check to name:"+name+", address:"+address);
	}
}
//sub class serialization to avaoid NotSerializableException while serializing
class Employee2 implements Serializable{
	private static final long serialVersionUID = 1L;
	//class Employee2 {	
	public String name;
}
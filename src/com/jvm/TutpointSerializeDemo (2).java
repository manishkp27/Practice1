package com.jvm;
import java.io.*;

public class TutpointSerializeDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		readBytesFromClassFile("Emolpyee1");
		
	}
	public static Emolpyee1 getEmployeeObject(){
		Emolpyee1 e = new Emolpyee1();
		e.name = "Reyan Ali";
	    e.address = "Phokka Kuan, Ambehta Peer";
	    e.SSN = 111223331;
	    e.obj= new String("manish");
	    return e;
	}
	public static byte[] readBytesFromClassFile(String className){
		File file = new File("D:/EclipseWorkSpace/Practice/"+className+".class");
		int len = (int)file.length();
		byte[] raw = new byte[len];
		try {
			FileInputStream fin= new FileInputStream(file);
			int r = fin.read(raw);
			if(r!=len)
				throw new IOException("cant read all");
			System.out.println("TutpointSerializeDemo.readBytesFromClassFile() len:"+r);
			fin.close();
		} catch (IOException e) {e.printStackTrace();}
		
		return raw;
	}
	public static byte[] prepareBytesToSend1(String className){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos =null;
		byte[] byteArray =null;
		try {
			oos = new ObjectOutputStream(baos);
			if(className.equals("Emolpyee1")){
				oos.writeObject(getEmployeeObject());
				//oos.writeObject(Emolpyee1.class);
			}
			else if(className.equals("Employee0"))
				oos.writeObject(new Employee0());
			
			byteArray=baos.toByteArray();
			System.out.println("TutpointSerializeDemo1.prepareBytesToSend1() length="+byteArray.length);
			testDeserialize(byteArray);
		} catch (IOException e) {e.printStackTrace();}
		
		
		return byteArray ;
	}
	
	public static void testDeserialize(byte[] data) {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is;
	    Emolpyee1 emp=null;
		try {
			is = new ObjectInputStream(in);
			emp = (Emolpyee1)is.readObject();
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		
		ClassLoader classLoader =TutpointSerializeDemo.class.getClassLoader();
		
	    System.out.println(classLoader.getResource("com/jvm/TutpointSerializeDemo.class") +" "+emp.name);
	}
	
	public static byte[] prepareBytesToSend(String className){
		ObjectOutput out = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] byteArray =null;
		try {
			out = new ObjectOutputStream(bos);
			if(className.equals("Emolpyee1")){
				out.writeObject(getEmployeeObject());
			}
			else if(className.equals("Employee0")){
					out.writeObject(new Employee0());
			}
			byteArray = bos.toByteArray();
			System.out.println("TutpointSerializeDemo1.prepareBytesToSend() length="+byteArray.length);
			
			
			out.close();bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return byteArray;
	}

}

package com.serialize;

import java.io.*;
import java.util.*;

public class PersistSerialClass {

    public static void main(String [] args) {
        String filename = "time.ser";

        if(args.length > 0){
            filename = args[0];
        }
		
        SerialClass time = new SerialClass();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try{
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(time);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
     }
 }

//Customize to call constructor while read
class SerialClass implements Serializable {
    public Date currentTime;
    
    public SerialClass() {
    	currentTime = Calendar.getInstance().getTime();
    }
   
    private void writeObject(ObjectOutputStream out) throws IOException{
    	 System.out.println("SerialClass.writeObject()");
    	out.defaultWriteObject();
    	
    	//If you dont want to serialize a class of sub class of super serialized calss, throw exception
    	if(false)
    		throw new NotSerializableException("Dont Serialize");
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
    	System.out.println("SerialClass.readObject()");
    	//in.defaultReadObject();
    	currentTime = Calendar.getInstance().getTime();
    }    
}
/*class SerialClass implements Serializable {
    public Date currentTime;
    public SerialClass() {
        currentTime = Calendar.getInstance().getTime();
    }    
}*/

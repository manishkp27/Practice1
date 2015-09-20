package com.serialize;

import java.io.*;
import java.util.Calendar;

public class ReadSerialClass {
	public static void main(String [] args) {
        String filename = "time.ser";

        if(args.length > 0){
            filename = args[0];
        }
		
        SerialClass time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try{
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (SerialClass)in.readObject();
            
         // print out restored time
            System.out.println("Restored time: " + time.currentTime);

            // print out the current time
            System.out.println("Current time: " + Calendar.getInstance().getTime());
            
            in.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }

        

     }
 }
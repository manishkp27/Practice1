package com.data.structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	   public static void main(String[] args) throws IOException {
	      
	      FileInputStream fis = null;
	      int i = 0;
	      char c;
	      byte[] bs = new byte[4];
	      
	      try{
	         // create new file input stream
	         //fis = new FileInputStream("D:/EclipseWorkSpace/Practice/src/com/data/structure/test.txt");
	    	  //File file = new File("D:/EclipseWorkSpace/Practice/src/com/data/structure/test.txt");
	    	  File file = new File("D:/EclipseWorkSpace/Practice/build/classes/Emolpyee1.class");
	    	  
	    	  fis = new FileInputStream(file);
	    	  bs = new byte[(int) file.length()];
	         // read bytes to the buffer
	         i=fis.read(bs);
	         
	         // prints
	         System.out.println("Number of bytes read: "+i);
	         System.out.println("Bytes read: ");
	         
	         // for each byte in buffer
	         for(byte b:bs)
	         {
	            // converts byte to character
	            c=(char)b;
	            
	            // print
	            System.out.print(c);
	         }   
	      }catch(Exception ex){
	         // if any error occurs
	         ex.printStackTrace();
	      }finally{
	         
	         // releases all system resources from the streams
	         if(fis!=null)
	            fis.close();
	      }
	   }
	}

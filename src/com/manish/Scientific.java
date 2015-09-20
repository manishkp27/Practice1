package com.manish;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.swing.JButton;

public class Scientific {

	static public int aa(){
		return Integer.SIZE;
	}
	
	/*static public void(){
		
	}
	static public int qvoid(){
		return Math.PI;
	}*/
	private static class inner implements Runnable{
		@Override
		public void run() {
		}
		
	}
	public Scientific() {
		
	}

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		int i = args.length;
		
		//TreeSet<Integer,String> t;
		int i1=2;
		int i2=5;
		double d=3+i1/i2+2;
		System.out.println(d);
		System.out.println(3+i1/i2+2);
		
		/*Pattern p =  Pattern.compile("[\\s]");
		for(String word:p.split("heel\tmm\t")){
			System.out.println();
		}*/
		
		/*StringBuffer[] b = new StringBuffer[5];
		b[0].append("hellow,world");
		System.out.println(b[0]);*/
		
		/*Float f = new Float(3.1);
		Integer ii = new Integer(1);
		long m =2;
		System.out.println(""+m+f+ii);*/
		
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(new String("Hello\uD801\uDFEE"));
		
		byte bArray[] = baos.toByteArray();
		System.out.println(bArray);*/
		
		/*final String brainbench="";
		JButton button = new JButton("Brainbench");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(brainbench);
			}
		});*/
		
	}
	static void func(){
		
	}
}
interface i{
	static final int i=11;
	//static transient final int i1=11;
}

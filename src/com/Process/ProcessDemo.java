package com.Process;

import java.io.IOException;
import java.io.InputStream;

public class ProcessDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		//useingExec();
		
		
		
	}
	static void useingProcessBuilder() throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("echo","This is process builder example from jcg");
		Process process =pb.start();
		int errorCode = process.waitFor();
		System.out.println("echo command executed any error?"+ (errorCode==0?"no":"yes"));
		
	}
	static void useingExec() throws IOException, InterruptedException{
		// create a new process
		Process p = Runtime.getRuntime().exec("notepad.exe");

		Thread.sleep(3_000);

		InputStream is = p.getInputStream();
		for (int i = 0; i < is.available(); i++) {
			System.out.println("" + is.read());
		}
		System.out.println("Waiting to close notepad....");
		// cause this process to stop until process p is terminated
		p.waitFor();

		// when you manually close notepad.exe program will continue here
		System.out.println("Waiting over.");

		Thread.sleep(1000);
		p.destroy();
	}

}

package com.solution;

import java.io.File;

public class DirectoryReader {
	static long startTime,timecheck,elapsedTime;
	static int spc_count = -1;
	static String option,pattern;
	static Long timeout;
	

	static void Process(File aFile,String option, String pattern, Long timeout) {
		spc_count++;
		String spcs = "";
		
		//boolean fileName=aFile.getName().matches(pattern);
		timecheck = System.currentTimeMillis();
		elapsedTime = timecheck - startTime;
		
		for (int i = 0; i < spc_count; i++)
			spcs += " ";
		
		if (aFile.isFile()) {				
				System.out.println(spcs + "[FILE] " + aFile.getPath() );//aFile.getName()
		}
		else if (aFile.isDirectory()) {
			
			System.out.println(spcs + "[DIR] " + aFile.getName());
			
			File[] listOfFiles = aFile.listFiles();
			if (listOfFiles != null) {
				for (int i = 0; i < listOfFiles.length; i++)
					Process(listOfFiles[i],option,pattern,timeout);
			} else {
				System.out.println(spcs + " [ACCESS DENIED]");
			}}
			spc_count--;
		
	}


	public static void main(String args[]){
		args=new String[4];
		args[0]="D:\\Users\\u203957\\Desktop\\Master file";
		args[1]="File";
		args[2]="app(.*).txt";
		args[3]="5000000";
		System.out.println("**************Top Folder Name*********************"+args[0]);
		System.out.println("**************Search Option*********************"+args[1]);
		System.out.println("**************Search Pattern*********************"+args[2]);
		System.out.println("**************Timeout in seconds********************"+args[3]);
		startTime=System.currentTimeMillis();
		if (args.length > 0){
			option=args[1];
			pattern=args[2];
			timeout=Long.parseLong(args[3]);
		File aFile = new File(args[0]);
		Process(aFile,args[1],args[2],timeout);}
	}
}
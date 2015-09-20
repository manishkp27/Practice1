package com.solution2;

import java.io.File;
import java.util.*;

class FileFolder {
	public static void main(String args[]) {
		File contents = new File("D:\\EclipseWorkSpace\\ProGenieAdmin");
		int i=0;
		for(File entry:contents.listFiles()){
			System.out.println(""+(i++)+(entry.isDirectory()?"directory":"file"));
		}
		
	}
	
		
	static void func(){
		String[] data={"one two three","two three four","five six seven eight nine"};
		
		for (String d : data) {
			String[] data1 = d.split("\\s+");
			List ll= new LinkedList();		
			
			for (String s : data1) {
				//System.out.println(s);
				ll.add(s);
			}
			System.out.println("");
		}
	}
}
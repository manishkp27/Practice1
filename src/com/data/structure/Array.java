package com.data.structure;

public class Array {

	public static void main(String[] args) {
		//String[] str3 = new String[2]{};//cant define dimention expression when an array initializer is available
		String[] str2 = new String[2];
		String[] str1 = new String[]{"",""};
		String[] input = {"one","two","three","four","four"};
		System.out.println("\n Is Duplicatie:"+CheckDupllicate(input));
		
		int[] i = {1,2,3};
		
		//int[] k = new int[2]{};//cant define dimention expression when an array initializer is available
		//int[] k1 = int[2];
		int[] k2 = new int[2];
		//int[] k3 = new int[2]{1,2};
		int[] k4 = new int[]{};		System.out.println("k4 length="+k4.length);
		
		int[][] i1 = {{1,11},{2,22}};
		int[] j[]  = {{1,11},{2,22},{2,22}};
		int[][] i2 = {{1,11},new int[2]};
	}

	static boolean CheckDupllicate(String[] input){
		
		for(int i=0;i<input.length-1;i++){
			System.out.println("comp with:"+i);
			for(int j=i+1;j<input.length;j++){
				System.out.print(" "+j);
				if(input[i].equals(input[j]))
					return true;
			}
			System.out.println(" ");
		}
		return false;
	}
	
}

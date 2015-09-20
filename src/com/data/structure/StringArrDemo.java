package com.data.structure;
import java.util.*;

public class StringArrDemo {

	public static void main(String[] args) {
		/*for(char c:("manish".toCharArray())){
			System.out.println(c);
		}*/
		/*System.out.println("manish".charAt(2));
		
		System.out.println("manish".length());
		
		char[] arr = {'s','f','h'};
		System.out.println(arr.length);
		
		System.out.println("manish".substring(3));
		System.out.println("manish".substring(3,5));
		
		System.out.println(Integer.valueOf("123"));
		System.out.println(String.valueOf(123));
		*/
		/*char[] arr1 = {'s','f','h'};
		Arrays.sort(arr1);
		for(char c:arr1){
			System.out.println(c);
		}*/
		
		//char[] arr3 = {'s','f','h'};
		//System.out.println(Arrays.toString(arr3));
		
		//Integer[] arr2 = {4,3,5,645,2};
		//System.out.println(Arrays.toString(arr2));
		
		/*char[] arr4 = {'s','f','h'};
		System.out.println(arr4.length);
		char[] arr5 = Arrays.copyOf(arr4, 7);
		System.out.println(arr5.length);*/
		
		char[] arr6 = {'a','b','c','d'};
		char[] arr7= new char[10];
		System.arraycopy(arr6,2,arr7,4,2);
		System.out.println(Arrays.toString(arr7));
	}

}

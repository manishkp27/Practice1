package com.solution2;

import java.lang.reflect.Array;
import java.util.*;

public class Parlor {

	public static void main(String[] args) {
		
		System.out.println(simulateParlor2 (1, "ABBCCA") );
	}
	
	static int simulateParlor2(int n, String input){
		int result = 0;
		char[] arr = input.toCharArray();
		Set<Character> shop = new HashSet();
		boolean isReturn = false;
		
		for(char c:arr){
			//entering
			if(shop.size()<n){
				//add success
				if(!shop.add(c)){
					//served leaving
					shop.remove(c);
					System.out.println("done:"+c+" size="+shop.size());
				}
				else{
					System.out.println("served:"+c);
				}
			}
			//un serviced
			else{
				
				if(shop.contains(c)){
					shop.remove(c);
					System.out.println("done:"+c+" size="+shop.size());
				}
				else{
					System.out.println("--returned--:"+c);
					//unserved entering
					if(!isReturn){
						result++;
						isReturn =true;
					}
					//unserved leaving
					else{
						isReturn =false;
					}
				}
			}
		}
		
		return result;
	}
	
	static int simulateParlor (int n, String input){
		int result = 0;
		char[] arr = input.toCharArray();
		List shop = new ArrayList();
		boolean isReturn = false;
		
		for(char c:arr){
			//entering
			if(!shop.contains(c)){
				//adde success
				if(shop.size()<n){
					System.out.println("add:"+c);
					shop.add(c);
				}
				//un serviced
				else{
					System.out.println("--returned--:"+c);
					if(!isReturn){
						result++;
						isReturn =true;
					}
					else{
						isReturn =false;
					}
				}
			}
			//leaving
			else{
				System.out.println("remove:"+c);
				shop.remove(shop.indexOf(c));
			}
		}
		
		return result;
	}
}

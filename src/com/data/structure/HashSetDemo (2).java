package com.data.structure;

import java.util.*;


public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List<String> list=new ArrayList();
		Set<String> list=new HashSet();
		list.add("a");
		list.add("c");
		list.add("z");
		list.add("b");
		list.add("x");
		//list.add(1, "aa");
		
		//System.out.println(list.add("b"));
		
		for(String s:list){
			System.out.println(s);
		}
		
		list.remove("a");
		System.out.println("after removing a");
		
		for(String s:list){
			System.out.println(s);
		}

		/*for(Iterator itr=list.iterator();itr.hasNext();){
			list.remove(itr.next());
		}*/
		/*for(String s:list){
			System.out.println(s);
		}*/
	}
	
	

}

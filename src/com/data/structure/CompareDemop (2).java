package com.data.structure;
import java.util.*;
public class CompareDemop {

	public static void main(String[] args) {
		List<HDTV> lst = new ArrayList();
		lst.add(new HDTV(1,"one"));
		lst.add(new HDTV(3,"three"));
		lst.add(new HDTV(2,"two"));
		
		//Sorting using Comparator interface
		Collections.sort(lst,new SizeComp());
		for(HDTV h:lst){
			System.out.println("brand:"+h.brand);
		}
		
		//reverse sorting using Collection API
		Collections.sort(lst, Collections.reverseOrder( new SizeComp()));
		for(HDTV h:lst){
			System.out.println("brand:"+h.brand);
		}
		
		/*List<Integer> lst2 = new ArrayList();
		lst2.add(1);
		lst2.add(3);
		lst2.add(2);
		
		Collections.sort(lst2, Collections.reverseOrder());
		for(Integer h:lst2){
			System.out.println(h);
		}*/
		
		/*Set<Boys> lst3 = new TreeSet();
		lst3.add(new Boys(1,"one"));
		lst3.add(new Boys(3,"three"));
		lst3.add(new Boys(2,"two"));*/
		
		//Collections.sort(lst3);
		//Collections.sort(lst3, Collections.reverseOrder( new SizeComp()));
		/*for(HDTV h:lst){
			System.out.println(h.brand);
		}*/
	}

}
class Boys implements Comparable<Boys>{
	String name;
	int age;
	public Boys(int age,String name){
		this.name=name;
		this.age=age;
	}
	public int compareTo(Boys i){
		return this.age-i.age;
	}
}
class HDTV{
	int size;
	String brand;
	
	HDTV(int size, String brand){
		this.size=size;
		this.brand=brand;
	}
}

class SizeComp implements Comparator<HDTV>{
	public int compare(HDTV a,HDTV b){
		return a.size - b.size;		//Ascending order
		//return b.size-a.size;		//Descending order
		//return b.brand.compareTo(a.brand);//String comparision char to char
		
	}
}
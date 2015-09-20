package com.data.structure;

import java.util.*;
import java.util.Map.Entry;

public class IterateDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection c;
		//Map map = new HashMap();
		HashMap map = new HashMap();
		System.out.println(map.put("1","Manish"));
		System.out.println(map.put("11",null));//when inserted null returns null
		System.out.println(map.put("111",123));//can insert any data type
		System.out.println(map.put("2","Satish"));
		System.out.println(map.put("2","Satish1"));//Overwrite value with a String
		System.out.println(map.put("3","Ashish"));
		System.out.println(map.put("3",null));//Overwrite value with null
		
		System.out.println("***display***");
		//for(int i=0;i<map.size();i++){
		//	System.out.println(map.get(i));
		//}		
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Entry e = (Entry)iterator.next();
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		Vector v = new Vector();
		v.add("manish");
		v.add("satish");
		v.add("ashish");
		
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
		
		Iterator itrV = v.iterator();
		while(itrV.hasNext()){
			System.out.println(itrV.next());
		}
		
		Enumeration enu = v.elements();
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
	
}

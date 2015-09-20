package com.data.structure.implement;
import java.util.*;
import java.util.Map.Entry;
public class TestCache {

	public static void main(String[] args) {
		CrunchifyCacheExample<String, String> cache = new CrunchifyCacheExample<>(9000, 9000, 90000);
		cache.put("one", "manish");
		cache.put("two", "satish");
		cache.put("three", "ashish");
		cache.put("four", "rajneesh");
		cache.put("five", "navnish");
		
		//for(int i=0;i<4;i++){
			System.out.println(cache.get("one"));
			System.out.println(cache.get("two"));
			System.out.println(cache.get("three"));
			System.out.println(cache.get("four"));
			System.out.println(cache.get("five"));
		//}
	}

}

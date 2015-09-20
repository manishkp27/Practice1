package com.data.structure;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapSynchronization {
	public static void main(String [] args){
			Map <String,String> map = new HashMap<String,String>();
			map.put("one", "manish");
			map.put("two", "satish");
			map.put("three", "ashish");
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry e = (Entry)iterator.next();
				System.out.println(e.getKey()+" "+e.getValue());
			}
			Map syncMap = Collections.synchronizedMap(map);			
			System.out.println(syncMap);
			
			Map <String,String> hashtable = new Hashtable<String,String>();
			hashtable.put("one", "manish");
			hashtable.put("two", "satish");
			hashtable.put("three", "ashish");
			hashtable.put("four", "rajneesh");
			hashtable.put("five", "navnish");
			System.out.println(hashtable);
			
			//Map <String,String> concuHashMap = new ConcurrentHashMap<String,String>();
			ConcurrentMap <String,String> concuHashMap = new ConcurrentHashMap<String,String>();
			concuHashMap.put("one", "manish");
			concuHashMap.put("two", "satish");
			concuHashMap.put("three", "ashish");
			System.out.println(concuHashMap);
			
	}
}

package com.data.structure;
import java.util.*;
import java.util.Map.Entry;
/*
public V put(K key, V value) {
    if (key == null)
    return putForNullKey(value);
    int hash = hash(key.hashCode());
    int i = indexFor(hash, table.length);
    for (Entry<K , V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
 
    modCount++;
    addEntry(hash, key, value, i);
    return null;
}
*/

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,String> has = new HashMap();
		has.put("16", "16");
		has.put("17", "17");
		has.put("18", "18");
		has.put("19", "19");
		has.put("20", "20");
		has.put("22", "22");
		has.put("33", "33");
		has.put("1", "1");
		has.put("2", "2");
		has.put("3", "3");
		has.put("4", "4");
		has.put("5", "5");
		has.put("6", "6");
		has.put("7", "7");
		has.put("8", "8");
		has.put("9", "9");
		has.put("10", "10");
		has.put("11", "11");
		has.put("12", "12");
		has.put("13", "13");
		has.put("14", "14");
		has.put("15", "15");
		has.put("mmm", "manish");
		
		//System.out.println(has.equals(new HashMap()) +", "+has.containsValue("manish"));
		Set<Entry<String, String>> entrySet = has.entrySet();
		
		for(Map.Entry<String,String> entry: entrySet){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		/*for(String s:has.keySet()){
			System.out.println(s+" "+has.get(s));
		}*/
		
		/*Iterator<Map.Entry<String,String>> itr = has.entrySet().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().getKey()+" "+itr.next().getValue());
		}*/
		//Iterator its = has.
		
	System.out.println(has.get("a")+"\t" +"a".hashCode()+ "\t"+("a".hashCode()%16));
	System.out.println(has.get("1")+"\t" +"1".hashCode()+ "\t"+("1".hashCode()%16));
	System.out.println(has.get("2")+"\t" +"2".hashCode()+ "\t"+("2".hashCode()%16));
	System.out.println(has.get("15")+"\t" +"15".hashCode()+ "\t"+("15".hashCode()%16));
	System.out.println(has.get("16")+"\t" +"16".hashCode()+ "\t"+("16".hashCode()%16));
	System.out.println(has.get("20")+"\t" +"20".hashCode()+ "\t"+("20".hashCode()%16));
	System.out.println(has.get("21")+"\t" +"21".hashCode()+ "\t"+("21".hashCode()%16));
	System.out.println(has.get("22")+"\t" +"22".hashCode()+ "\t"+("22".hashCode()%16));
	System.out.println(has.get("3")+"\t" +"3".hashCode()+ "\t"+("3".hashCode()%16));
	System.out.println(has.get("30")+"\t" +"30".hashCode()+ "\t"+("30".hashCode()%16));
	System.out.println(has.get("33")+"\t" +"33".hashCode()+ "\t"+("33".hashCode()%16));
	}

}



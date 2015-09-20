package com.data.structure;
import java.util.*;
public class CollectionEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer,EmployeeA> hashmap= new HashMap();
		EmployeeA emp1 = new EmployeeA();
		
		hashmap.put(1, emp1);
		//hashmap.getOrDefault(null, null);
		hashmap.getOrDefault(null, emp1).func();
		//System.out.println(hashmap.get(1).func());
		
		Hashtable<Integer, EmployeeA> hashtable = new Hashtable<Integer,EmployeeA>();
	}

}
class EmployeeA{
	protected long employeeId;
	protected String firstName;
	protected String lastName;
	public void func(){
		System.out.println("manish");
	}
}

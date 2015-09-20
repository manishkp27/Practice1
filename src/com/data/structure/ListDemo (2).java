package com.data.structure;

import java.util.*;

public class ListDemo {

	public static void main(String [] args){
		//ArrayListDemo();
		//LinedListDemo();
		
		ArrayList<String> myList = new ArrayList<String>(11);//Initialize with capacity of 11 instead of default 10
		myList.add("manish0");myList.add("manish1");myList.add("manish2");
		myList.add("manish3");myList.add("manish4");
		
		//listIter(myList);
		
		//unmodifiableList(myList);
		
		trimEnsurecapacity(myList);
	}
	
	static void trimEnsurecapacity(ArrayList<String> myList){
		myList.trimToSize();//this will remove unused 11-5=6 locations
		myList.ensureCapacity(12);//increase capacity to 12
		System.out.println("these operations will not affect .size()");
		
		/*StringBuilder myBuffer = new StringBuilder(13);
		myBuffer.append("manish");
		myBuffer.trimToSize();
		myBuffer.ensureCapacity(11);
		System.out.println(myBuffer);*/
	}
	static void unmodifiableList(List<String> myList){
		List immutableLst = Collections.unmodifiableList(myList);
		System.out.println(immutableLst);
		immutableLst.add("test");
	}
	static void listIter(List<String> myList){
		ListIterator listIterator= myList.listIterator();
		
		while(listIterator.hasNext()){
			System.out.println(listIterator.next()+" "+listIterator.nextIndex());
			if(listIterator.nextIndex()==4){
				listIterator.remove();
			}
			listIterator.add("manishNew");
		}
		listIterator= myList.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next()+" "+listIterator.nextIndex());
		}
	}
	static void LinedListDemo(){
		LinkedList<String> myLList = new LinkedList<String>();
		myLList.add("manish0");	myLList.add("manish1");		
				
		myLList.addFirst("first");
		
		Iterator<String>lLItr = myLList.listIterator();
		
		while(lLItr.hasNext()){
			System.out.println(lLItr.next());
		}
		
		System.out.println("---toArray()");
		Object[] arr = null;
		arr =  myLList.toArray(new Object[1]);//new Object size can be any number
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		myLList.clear();
		System.out.println("--After clear hasNext:"+lLItr.hasNext());
	}
	
	static void ArrayListDemo(){
		//List<int> myList = new ArrayList<int> (); //primitives are not store primitives in ArrayList
		//List<Integer> myList = new ArrayList<Integer> (); // Only objects are allowed to store
		
		//Initialize arrayList
		List<String>coolStringList = Arrays.asList("ashish0","ashish1");
		
		//OR Initialize using any collection
		List<String> myList = new ArrayList<String> (coolStringList);
		
		myList.add("manish0");
		myList.add(0,"manish1");myList.add("manish2");myList.add("manish3");myList.add("manish3");myList.add("manish4");
		
		myList.addAll(coolStringList);
		System.out.println(myList.indexOf("manish3")+" "+myList.lastIndexOf("manish3"));
		
		myList.remove("manish3");myList.set(4, "MANISH5");myList.add(4, "MANISH4");
		
		Iterator<String> itr=myList.iterator();//listIterator(2);//
		System.out.println("----------list Size="+myList.size());
		while(itr.hasNext()){
			System.out.println(itr.next());
		}

		List<String> myList2= myList.subList(2,4);
		System.out.println("-------sub list Size="+myList2.size());
		for(int i=0;i<myList2.size();i++){
			System.out.println(myList2.get(i));
		}
	}
}

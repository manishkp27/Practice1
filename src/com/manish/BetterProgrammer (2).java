package com.manish;

import java.util.*;

public class BetterProgrammer {

	synchronized public static void main(String[] args) {
		//System.out.println(getSumOfNumbers("12    some text 3  7"));
		
		//System.out.println(countWords("12some text 3  7"));

		//int[] a={-4,-2,5,76,2,23};
		//System.out.println(getSumOfTwoClosestToZeroElements(a));
		
		System.out.println("\ntotal="+countWaysToJump(5));
		
	}
	public static int countWaysToJump(int N) {
		int steps=0;
		int j=0;
		for(int way=0;way<1;way++){
			System.out.println("Way num:"+way);
			j=1;
			for(int i=0;i<N;i++){
				System.out.print(j+" ");
				steps+=j;
				if(steps>N)
					break;
			}
		}
		return 0;
	}
	
	 public static int getSumOfTwoClosestToZeroElements(int[] a) {
		 Integer aa[] = new Integer[a.length];
		 for(int i=0;i<a.length;i++)
			 aa[i]=a[i];
		 
		 List<Integer> list = Arrays.asList(aa);
		 Collections.sort(list);
		 //System.out.println(Arrays.toString(list.toArray()));
		 
		 //+ve nums
		 Integer[] pos=new Integer[aa.length];
		 int p=aa[aa.length-1];
		 for(Integer i:aa){
			 if(i>=0 && p>i)
				 p=i;
		 }
		// System.out.println("positive nums="+p);
		 
		 //-ve nums
		 Integer[] neg=new Integer[aa.length];
		 int n=aa[0];
		 for(Integer i:aa){
			 if(i<0 && i>n)
				 n=i;
		 }
		 //System.out.println("negetive nums="+n);
		 
		// System.out.println(p>=(n*-1)?p:n);
		 return p>=(n*-1)?p:n;
	 }
	
	 public static int countWords(String s) {
		String[] nums= s.split(" ");
		int i=0;
		for(String ss:nums){
				if(!ss.equals(""))
					i ++;
		}
		
		return i;
	}
	
	public static int getSumOfNumbers(String s) {
		String[] nums= s.split(" ");
		int i=0;
		for(String ss:nums){
			try{
				i += Integer.parseInt(ss);
			}
			catch(NumberFormatException e){continue;}
		}
		
		return i;
	}

}
class CLASS{
	void func(){
		synchronized (this) {
			List l=new ArrayList();
			l.add("manihs");
			l.add(123);
			System.out.println(l.get(0).equals("man"));
			System.out.println(((int)l.get(1))/2);
			
			
			}
	}
}

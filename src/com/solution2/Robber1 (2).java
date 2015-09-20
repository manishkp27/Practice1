package com.solution2;
import java.util.*;
public class Robber1 {

	public static void main(String[] args) {
		int[] num = {1,23,34,56,23,54,67,34,2};
		System.out.println(rob(num));
	}
	static int rob(int[] num) {
        int res = 0;
        if(num==null){
        	return 0;
        }
        if(num.length==1){
        	return num[0];
        }
        
       Integer[] num1=new Integer[num.length];
       for(int i=0;i<num.length;i++){
    	   num1[i]=num[i];
       }
       
        List<Integer> numList =Arrays.asList(num1);
        
        Boolean[]robbed=new Boolean[num.length+2];
        
        Set<Integer> set = new HashSet<Integer>();
        for(Integer n: num1){
        	set.add(n);
        }
        Integer[] tempset = new Integer[set.size()]; //(Integer[]) set.toArray();
        int ii=0;
        for(Integer n:set){
        	tempset[ii++]=n;
        }
        Integer[] sorted=new Integer[tempset.length];
        System.arraycopy(tempset,0, sorted,0,tempset.length);
        Arrays.sort(sorted);
        
        int index=0;
        for(int i=sorted.length-1;i>=0;i--)
        {
        	index = numList.indexOf(sorted[i]);
	        if((robbed[index-1+1]==null ) &&(  robbed[index+1+1]==null )){
	        	robbed[index+1]=true;
	        	res=res+sorted[i];
        	}
        }
        //System.out.println( Arrays.toString(robbed));
        return res;
    }

}

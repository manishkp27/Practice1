package com.solution2;

import java.util.Arrays;
import java.util.List;

public class LongestIncSubseq {
	//static Integer[] data = new Integer[]{ 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	static Integer[] data = new Integer[]{ 10, 22, 9, 33, 21, 50 };
	public static void main(String[] args) {
		//find();
		find2();
	}
	
	static void find2(){
		List lData = Arrays.asList(data);
		System.out.println(lData);
		
		
	}
	
	static int find(){
		Integer[] subSeq=null,subSeqTemp =null;
		int len=0;
		for(int i=0;i<data.length;i++){
			subSeqTemp = subSeq(i);
			if(subSeqTemp.length>len)
			{	len=subSeqTemp.length;
				subSeq=subSeqTemp;
				System.out.println(Arrays.toString(subSeq)+"");
			}
		}
		return 0;
	}
	private static Integer[] subSeq(int i) {
		Integer [] temp=null,result = new Integer[data.length];
		int j=0;
		
		int print=data[i];
		int res=0;
		for(;i<data.length;i++){
			if(print<=data[i])
			{	//System.out.print(data[i]+", ");
				result[j++]=data[i];
				print=data[i];
				res++;
			}
		}
		temp = new Integer[res];
		System.arraycopy(result, 0, temp, 0, res);
		return temp;
	}
}

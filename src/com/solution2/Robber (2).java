package com.solution2;
import java.util.*;
public class Robber {

	public static void main(String[] args) {
		int[] num = {1,23,34,56,23,54,67,34,2};
        System.out.println( Arrays.toString(num));
        rob(num);
        //System.out.println(rob(num));
	}
	static int rob(int[] num) {
        int res = 0;
        
        //Create houses with  money
        House[] housSpace=new House[num.length];
        
        for(int i=0;i<num.length;i++){
        	housSpace[i]=new House(num[i]);
        }

        //sort the money in ascending order
        int[] sorted = new int[num.length];
        sorted = Arrays.copyOf(num, num.length);
        Arrays.sort(sorted);
        System.out.println( Arrays.toString(sorted));
        
        for(int i=0;i<num.length;i++)
        {	for(int j=0;j<num.length;j++)
            {	if(housSpace[j].money == sorted[i] && housSpace[j].rank==-1)
	        	{	housSpace[j].rank=i;
	        	System.out.println(housSpace[j].money+"->"+housSpace[j].rank);
	        	} 
            
            }
        }
        //print ranks
        /*for(int j=0;j<num.length;j++)
        {
        	System.out.println(housSpace[j].rank);
        		
        }*/
        return res;
    }

}
class House{
	int money;
	int rank;
	boolean lBurgled,rBurgled;
	
	public House(){	}
	
	public House(int money){
		this.money=money;
		this.rank=-1;
	}
}

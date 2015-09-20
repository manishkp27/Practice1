package com.solution2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sortPoints {

	//static int[][] array;
	static int[][] g;
	
	public static void main(String[] args) {
		
		String[] input1 = {"-3#8","9#3","-1#3","-8#9"};
		int x=-3,y=8;
		sortPoints1(input1,x,y);
	}

	public static String[] sortPoints1(String[] input1,int input2,int input3)
    {
		int[][] inputArray = formatInput(input1);
		int[] distArray = new int[input1.length];
		
		for(int i = 0; i < input1.length; i++)
		{
			distArray[i]=getDist(inputArray[i][0],inputArray[i][1],input2,input3);
		}
		
		//String[] output1 = Arrays.copyOf(input1,input1.length);
		String[] output1 = new String[input1.length];
		for(int i = 0; i < input1.length; i++)
		{
			output1[i] = input1[i];
		}
		
		int largest = -1;
		int largIndex=0;
		int[] tempDistArray = distArray;
		for(int i = 0; i < input1.length; i++)
		{
			for(int j = 0; j < input1.length; j++)
			{
				if(largest<tempDistArray[j])
				{
					largest = tempDistArray[j];
					largIndex = j;
				}
			}
			largest = -1;
			tempDistArray[largIndex] = -1;
			output1[i] = input1[largIndex];
		}
		
        return output1;
    }
	private static int getDist(int i, int j, int input2, int input3) {
		return (i-input2)*(i-input2)+(j-input3)*(j-input3);
	}
	private static int[][] formatInput(String[] temparrayN) {
		int[][] temparray = new int[temparrayN.length][2];
		for (int i = 0; i < temparrayN.length; i++) 
		{
			String[] a = temparrayN[i].split("#");
			temparray[i][0] = (Integer.parseInt(a[0]));
			temparray[i][1] = (Integer.parseInt(a[1]));
		}
		return temparray;
	}
	/*private static String construtcOP() {
		 int x = -1, y = -1;
		 String outptFinal;
		if (x == -1) {
			outptFinal = "{}";
			return outptFinal;
		}
		int value = g[x][y];
		outptFinal = "{";
		for (int i = 0; i < value;) {
			outptFinal += "(";
			for (int j = 0; j < value;) {
				outptFinal += x + i + "#" + (y + j);
				outptFinal += ",";
				j++;
			}
			outptFinal = outptFinal.substring(0, outptFinal.length() - 1);
			outptFinal += "),";

			i++;
		}
		outptFinal = outptFinal.substring(0, outptFinal.length() - 1);
		outptFinal += "}";
		return outptFinal;
	}*/
	
}

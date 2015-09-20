package com.solution2;

public class CandidateCode {
	static int[][] array;
	static int[][] g;
	public static void main(String[] args) {
		int[][] temparray = {	{1,1,0,1,1},
								{1,1,1,1,1},
								{0,1,1,1,1},
								{0,1,1,1,1},
								{1,1,0,1,1}
							};
		array = g = temparray;
		
		biggestSquare();
	//System.out.println(biggestSquare(array)); 
	}

	private static char[] biggestSquare() {
		
		getDoubSize();
		getTripleSize();
		getQuatSize();
		//getNSize(5);
		return null;
	}
	private static int[][] getQuatSize(int n) {

		for (int i=0;i<array.length-3;i++)
		{
			for (int j=0;j<array.length-3;j++)
			{
				if(array[i][j]==3)
				{	//check if forming square
					if(array[i][j+3]>=1 && array[i+3][j]>=1)
					{	g[i][j]++;
					
					}
					else
						System.out.print("0");
				}
			}
			System.out.println("");
		}
		printArr(g);
		return null;
	}
	
	private static int[][] getQuatSize() {

		for (int i=0;i<array.length-3;i++)
		{
			for (int j=0;j<array.length-3;j++)
			{
				if(array[i][j]==3)
				{	//check if forming square
					if(array[i][j+3]>=1 && array[i+3][j]>=1)
					{	g[i][j]++;
					
					}
					else
						System.out.print("0");
				}
			}
			System.out.println("");
		}
		printArr(g);
		return null;
	}
	private static int[][] getTripleSize() {

		for (int i=0;i<array.length-2;i++)
		{
			for (int j=0;j<array.length-2;j++)
			{
				if(array[i][j]==2)
				{	//check if forming square
					if(array[i][j+2]>=1 && array[i+2][j]>=1)
					{	g[i][j]++;
					
					}
					else
						System.out.print("0");
				}
			}
			System.out.println("");
		}
		printArr(g);
		return null;
	}
	
	private static int[][] getDoubSize() {

		for (int i=0;i<array.length-1;i++)
		{
			for (int j=0;j<array.length-1;j++)
			{
				if(array[i][j]==1)
				{	//check if forming square
					if(array[i][j+1]==1 && array[i+1][j]==1)
					{	g[i][j]++;
					
					}
					else
						System.out.print("0");
				}
			}
			System.out.println("");
		}
		printArr(g);
		return null;
	}

	static void printArr(int[][] g)
	{
		System.out.println("print array");
		for (int i=0;i<g.length;i++)
		{
			for (int j=0;j<g.length;j++)
			{
				System.out.print(g[i][j]);
			}
			System.out.println("");
		}
	}

}

package com.data.structure;

public class Primes {

	public static void main(String[] args) {
		System.out.println(getPrimes(100));
	}
	static int getPrimes(int N){
		int res=0;
		
		if(N>1)
		{	res++;
			System.out.println("prime:"+2);
		}
		
		boolean falg=false;
		for(int i=3;i<=N;i++)
		{
			for(int j=2; j<=i/2; j++)
			{
				if(i!=j && i%j==0)
				{	
					falg=true;
					//System.out.println(i+" "+j);
					break;
				}
			}
			if(falg!=true){
				System.out.println("prime:"+i);
				res++;
			}
			falg=false;
		}
		return res;
	}

}

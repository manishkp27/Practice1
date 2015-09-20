package com.data.structure;

import java.util.*;

public class Palindrom {


	public static void main(String[] args) {
		//System.out.println(isPalindrome("aabaa"));
		System.out.println(palindrome("aaasbsammaa"));
		System.out.println(isPalindrome("aaasbsammaa"));
	}
	
	public static int palindrome(String str) {
		
		 if(str==null)
			 return 0;
		 String s1;
		 str=str.replaceAll("\\s+","");
		 
	        int N = str.length();
	        Set<String> palindromeArray = new HashSet<String>();
	        for (int i = 1; i <= N; i++) {
	            for (int j = 0; j <= N; j++) {
	                //int k = i + j - 1;
	                //if (k >= N)
	            	if((i + j )>N)
	                    continue;
	                s1 = str.substring(j, i + j);
	                if (s1.equals(new StringBuilder(s1).reverse().toString())) {
	                    palindromeArray.add(s1);
	                }
	            }

	        }
	        return palindromeArray.size();
	}
	
	public static int isPalindrome(String str) {
		if (str.length() <= 2) {
	        return 1;
	    }
	    Set<CharSequence> out = new HashSet<CharSequence>();
	    int length = str.length();
	    for (int i = 0; i < length - 1; i++) {
	        for (int j = i , k = i; j >= 0 && k < length; j--, k++) {
	            if (str.charAt(j) == str.charAt(k)) {
	                out.add(str.subSequence(j, k + 1));
	            } else {
	                break;
	            }
	        }
	    }
	    return out.size();
	}
	
}
/*
public static void main(String[] args) {
	int num=12345;//4567654;
	System.out.println(reverse(num));

}

static boolean Palindrom(int num){
	System.out.println((int)(num/1000000)+","+num%10);
	return true;
}
static int reverse(int num){
	int res=0;
	while(num>=1){
		res=res*10+num%10;
		num=num/10;
	}
	return res;
}*/
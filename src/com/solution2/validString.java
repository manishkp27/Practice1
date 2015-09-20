package com.solution2;

import java.util.Stack;

public class validString {

	public static void main(String[] args) {
		String input1 = "[{{()}}][{{()}}][{{()}}]";
		String input = "({}[((({}})[{()}]))])";
		String input2 = "";
		System.out.println(validString1(input2));
	}
	public static String validString1(String input1)
    {
		if(input1==null)
			return "Correct";
		
		Character[] array = new Character[input1.length()];
		int arrLength=0;
		for (int i=0;i<input1.length();i++)
		{
			char cur = input1.charAt(i);
			if(cur == '{' || cur == '(' || cur == '[')
			{
				array[arrLength++]=cur;
			}
			else if(cur == '}' || cur == ')' || cur == ']')
			{
				if(arrLength<1)
				{
					return "Incorrect";
				}
				
				char prev = array[arrLength-1];
				if((prev=='{' && cur=='}') || (prev=='(' && cur==')') || (prev=='[' && cur==']') )
				{
					array[arrLength--]='0';
				}
			}
		}
		if(arrLength<1)
		{
			return "Correct";
		}
		else
			return "Incorrect";
		
    }
	public static String validString2(String input1)
    {
		if(input1==null)
			return "Correct";
		
		//Stack<Character> stack = new Stack<Character>();
		Character[] array = new Character[input1.length()];
		int arrLength=0;
		for (int i=0;i<input1.length();i++)
		{
			char cur = input1.charAt(i);
			if(cur == '{' || cur == '(' || cur == '[')
			{
				//stack.push(cur);
				array[arrLength++]=cur;
			}
			else if(cur == '}' || cur == ')' || cur == ']')
			{
				//if(stack.isEmpty())
				if(arrLength<1)
				{
					return "Incorrect";
				}
				
				//char prev = stack.peek();
				char prev = array[arrLength-1];
				if((prev=='{' && cur=='}') || (prev=='(' && cur==')') || (prev=='[' && cur==']') )
				{
					//stack.pop();
					array[arrLength--]='0';
				}
			}
		}
		//if(stack.isEmpty())
		if(arrLength<1)
		{
			return "Correct";
		}
		else
			return "Incorrect";
		
    }

}

package com.oops;

public class PolimorphismStatic {

	public static void main(String[] args) {
		OverLoadSample s = new OverLoadSample();
		s.print(5);
		s.print("manish");
		s.print(6,"satish");
	}

}

class OverLoadSample{
	void print(int i){
		System.out.println(i);
	}
	/*int print(int i){
		System.out.println(i);
		return i;
	}*/
	void print(String i){
		System.out.println(i);
	}
	void print(int i,String s){
		System.out.println(i+s);
	}
}
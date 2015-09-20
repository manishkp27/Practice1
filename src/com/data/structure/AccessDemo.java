package com.data.structure;

public class AccessDemo {

	public static void main(String[] args) {
		func('a', 'b');
	}
	private static void func(char i,char j){
		System.out.println("private void func(char i,char j)");
	}
	private void func(char j){
		System.out.println("private void func(char j)");
	}
	protected void func(int i,int j){
		func('a');
	}
	void func(){
		
	}
	public void func(int i){
		
	}	
	synchronized void func1(){
		
	}
	final void func2(){
		
	}
	static void func3(){
		
	}
	static int staticVar;
	final int staticVar1=0;
	static final int staticVar2=0;
	static final int staticVar2(){return 0;};
}

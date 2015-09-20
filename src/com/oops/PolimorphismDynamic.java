package com.oops;

public class PolimorphismDynamic {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		m.call();
		
		m=new Android();
		m.call();
		
		m=new IPhone();
		m.call();
	}

}
class Mobile{
	void call(){
		System.out.println("general mobile calling");}
}
class Android extends Mobile{
	void call() { 
		System.out.println("android calling"); }
}
class IPhone extends Mobile{
	void call() { 
		System.out.println("Iphone calling"); }
}
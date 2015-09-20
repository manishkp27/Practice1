

import java.io.Serializable;

public class Emolpyee1 implements Serializable{
	private static final long serialVersionUID = 1111122233;
	public String name;
	public String address;
	public static String address1;
	public static int number=intialize();
	public transient int SSN;
	public Object obj;
	static{
		System.out.println("Emolpyee1: this is static block");
	}
	{
		System.out.println("Emolpyee1: this is non static block");
	}
	public void mailCheck(){
		System.out.println("Emolpyee1.mailCheck() Mailing a check to name:"+name+", address:"+address);
	}
	public Emolpyee1(){
		System.out.println("Emolpyee1() Constructor call");
	}
	public Emolpyee1(String name,String address){
		System.out.println("Emolpyee1.Emolpyee1(String name,String address) Constructor call");
		this.name=name;
		this.address=address;
	}
	public static int intialize(){
		System.out.println("Emolpyee1.intialize() this is static initialization method");
		return 111;
	}
}

package com.manish;

public class Enum {

	public static void main(String[] args) {
		//System.out.println(new Cls(1).CONST);
		//System.out.println(Color.RED);
		//System.out.println(new Cls(30).CONST);

	}

}

class Cls{
	int i;
	
	Cls(int a){
		i=a;
	}
	public final int CONST=i;
	public enum e1 {RED1,BLACK2};
	
	public enum Color{RED, Green;}
}

enum Color{
	 RED("Red Color"), Green("Green Color");

	 private Color(String color){
	    this.color = color;
	    System.out.println("construtctor color:"+color);
	  }

	  private String color;

	  public String getColor(){
	    return this.color;
	  }

	  public String toString(){
	    return this.color;
	  }
	}
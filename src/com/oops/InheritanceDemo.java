package com.oops;

public class InheritanceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Mobile1{
	String model;
	Mobile1(String man, String o,String m, int c){
		model=m;
	}
}
class Android1 extends Mobile1{  
    //Constructor to set properties/characteristics of object  
    Android1(String man, String o,String m, int c){  
            super(man, o, m, c);  
        }  
    //Method to get access Model property of Object  
    public String getModel(){  
        return "This is Android Mobile- " + model;  
    }  
}  

class Blackberry extends Mobile1{  
    //Constructor to set properties/characteristics of object  
    Blackberry(String man, String o,String m, int c){  
                    super(man, o, m, c);  
                }  
    public String getModel(){  
        return "This is Blackberry-"+ model;  
    }  
}  
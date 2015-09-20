package com.design;

import javax.swing.BorderFactory;

interface Shape1{
	void draw();
}

// Concrete classes implementing shapre interface
class Rectangle implements Shape1{
	public void draw(){System.out.println("Inside Rectangle.draw()");}
}
class Square implements Shape1{
	public void draw(){System.out.println("Inside Square.draw()");}
}

//Factory to generate objects of concrete classes based on info provided
class ShapeFactory{
	Shape1 createShape(String shapeType){
		if(shapeType==null){
			return null;
		}
		else if(shapeType=="Rectangle"){
			return new Rectangle();
		}
		else if(shapeType=="Square"){
			return new Square();
		}
		return null;
	}
}

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		factory.createShape("Rectangle").draw();
		factory.createShape("Square").draw();
		
		//BorderFactory b;
		//String val = String.valueOf(1223);
		
	}

}

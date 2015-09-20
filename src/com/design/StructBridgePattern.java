package com.design;
public class StructBridgePattern {
	public static void main(String[] args) {
		Shape redCircleShape = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircleShape = new Circle(100, 100, 10, new GreenCircle());
		
		redCircleShape.draw();
		greenCircleShape.draw();
	}
}

interface DrawAPI{
	void drawCircle(int radious, int x, int y);
}
class RedCircle implements DrawAPI{
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", y:" + y + "]");		
	}
}
class GreenCircle implements DrawAPI{
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", y:" + y + "]");		
	}
}

abstract class Shape{
	DrawAPI drawAPI;
	Shape(DrawAPI drawAPI){
		this.drawAPI=drawAPI;
	}
	abstract void draw();
}

class Circle extends Shape{
	int x,y,radius;
	Circle(int x, int y, int radius,DrawAPI drawAPI) {
		super(drawAPI);
		this.x = x;  
	    this.y = y;  
	    this.radius = radius;
	}
	@Override
	void draw() {
		drawAPI.drawCircle(radius, x, y);
	}
}


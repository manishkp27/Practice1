package com.design;

public class OpenCloseDemo {
	public static void main(String[] args) {
		/*GraphicEditor editor = new GraphicEditor();
		Shape2 shape = new Rectangle2(); editor.drawShape(shape);
		shape = new Circle2(); editor.drawShape(shape);
		*/
		GraphiEditorN editorN = new GraphiEditorN();
		Shape2N shapeN = new Rectangle2N(); 
		editorN.drawShape(shapeN);
	}
}

//*************************This example which violates the Open Close Principle.
class GraphicEditor{
	public void drawShape(Shape2 s) {
 		if (s.m_type==1)
 			drawRectangle((Rectangle2)s);
 		else if (s.m_type==2)
 			drawCircle((Circle2)s);
 	}
 	public void drawCircle(Circle2 r) {System.out.println("Drawing Circle m_type="+r.m_type);}
 	public void drawRectangle(Rectangle2 r) {System.out.println("Drawing Rectangle m_type="+r.m_type);}
}

class Shape2 {
 	int m_type;
 }
 
 class Rectangle2 extends Shape2 {
 	Rectangle2() {
 		super.m_type=1;
 	}
 }
 
 class Circle2 extends Shape2 {
 	Circle2() {
 		super.m_type=2;
 	}
 } 

//*************************Fix design OpenClosePrinciple Violation.
class GraphiEditorN{
	public void drawShape(Shape2N s){
		s.draw();
	}
}
abstract class Shape2N{
	int m_type=1;
	abstract void draw();
}
class Rectangle2N extends Shape2N {
 	Rectangle2N() {
 		m_type=1;
 	}
	public void draw() {System.out.println("Drawing Rectangle2N m_type="+super.m_type);
	}
 }
 
 class Circle2N extends Shape2N {
 	Circle2N() {
 		super.m_type=2;
 	}
 	public void draw() {
 		System.out.println("Drawing Circle2N m_type="+super.m_type);
	}
 } 




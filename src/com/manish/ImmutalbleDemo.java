package com.manish;

public class ImmutalbleDemo {

	public static void main(String[] args) {
		/*OhNoMutable mutable = new OhNoMutable(1, 2);
		ImSoImmutable immutable = mutable;
		System.out.println(immutable.add());
		//String
		
		//mutable.field3=4;
		System.out.println(immutable.add());*/
		
		cls11 c= new cls11();
		System.out.println(c.i);
	}
}

class ImSoImmutable{
	private final int field1;
	private final int field2;
	
	public ImSoImmutable(int field1, int field2) {
		this.field1 = field1;
		this.field2 = field2;
	}
	
	public int add(){
		return field1+field2;
	}
}

final class OhNoMutable extends ImSoImmutable{

	public int field3=0;
	
	public OhNoMutable(int field1, int field2) {
		super(field1, field2);
	}
	public int add(){
		return super.add()+field3;
	}
}

final class cls11{
	int i,j;
	cls11(){
		
	}
	void update(){
		i=0;j=0;
	}
}


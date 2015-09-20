package com.oops;

import java.io.IOException;

public class InheritException {
	public static void main(String[] args) {
		/*int i=2;
		try{
			i=i/0;
		}
		catch(ArithmeticException e){
			e.printStackTrace();
		}
		finally{
			System.out.println(i);
		}*/
	}

}

class cl11{
	void main()throws IOException{}
	protected void main1(){}
}
class cl22 extends cl11{
	//void main()throws Exception{}		//Superior exceptions not compatible
	void main()throws IOException{}
	
	//void main1(){}		//cant reduce visibility
	public void main1(){}
}
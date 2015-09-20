package com.data.structure;

public class StringDemo {

	public static void main(String[] args) {
		/*String str= "Manish";
		System.out.println(reverseRecursively(str));
		
		 char a1 = '\u0061';
		 char \u0061 = 'a';
		 ch\u0061r b  = 'B';
				 
		 System.out.println(b);
		 */
		 /*StringBuilder sb = new StringBuilder("manish pal");
		 System.out.println(sb.length());
		 System.out.println(sb.capacity());
		 
		 StringBuffer sbuf =new StringBuffer("satish pal");
		 System.out.println(sbuf.length());
		 System.out.println(sbuf.capacity());
		 */
		
		/* String str = "manish kumar pal";
		 System.out.println(str.length());
		 System.out.println(str.substring(15));
		 System.out.println(str.substring(0,3));*/
		 //System.out.println(new String);
		 
		/* StringBuffer[] sb = new StringBuffer[5];
		 //sb[0]= new StringBuffer("manish kumar pal");	 System.out.println(sb[0]);		 
		 sb[0].append("123"); System.out.println(sb[0]);//Exception*/		 
		 
		
	}
	
	public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
        
    }
}

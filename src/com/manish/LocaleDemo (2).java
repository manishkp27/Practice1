package com.manish;

import java.text.CollationKey;
import java.text.Collator;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Locale;

public class LocaleDemo {

	public static void main(String[] args) {
		
		collator();
	}
	static void collator(){
		//String CompareTo
		//System.out.println("z".compareTo("a"));//1
		
		//Compare
		/*Collator collator = Collator.getInstance(Locale.UK);
		System.out.println(collator.compare("b", "a"));*///1
		
		//Rule based comapre
		try {
			RuleBasedCollator ruleBasedCollatorNumber;
			//ruleBasedCollator = new RuleBasedCollator("< a < b");//natural order a,b.c.. (a comes before b)
			/*ruleBasedCollator = new RuleBasedCollator("< b < a");//reverse order ...c,b,a (b comes before a)
			System.out.println(ruleBasedCollator.compare("z", "y"));*///1
			
			//System.out.println(ruleBasedCollator.compare("1", "2"));//-1
			/*ruleBasedCollatorNumber = new RuleBasedCollator("< 2 < 1");//reverse order
			System.out.println(ruleBasedCollatorNumber.compare("1", "2"));*///1
		
			//Grouping characters
			/*ruleBasedCollatorNumber = new RuleBasedCollator("< b,B,2 < a,A,1");//reverse order
			System.out.println(ruleBasedCollatorNumber.compare("a", "B"));
			System.out.println(ruleBasedCollatorNumber.compare("1", "2"));*/
			
			//combination of characters
			/*ruleBasedCollatorNumber = new RuleBasedCollator("< ch < b < a < c");//reverse order
			System.out.println(ruleBasedCollatorNumber.compare("boss", "carol"));
			System.out.println(ruleBasedCollatorNumber.compare("boss", "charlie"));*/
			
			//Improve perfor in sorting using collator key
			ruleBasedCollatorNumber = new RuleBasedCollator("< c,C < b,B < a,A");
			//ruleBasedCollatorNumber = new RuleBasedCollator("< a,A < b,B < c,C");
			CollationKey[] collationKey = new CollationKey [6];
			
			collationKey[0]=ruleBasedCollatorNumber.getCollationKey("boss");
			collationKey[1]=ruleBasedCollatorNumber.getCollationKey("carol");
			collationKey[2]=ruleBasedCollatorNumber.getCollationKey("andy");
			collationKey[3]=ruleBasedCollatorNumber.getCollationKey("amdy");
			collationKey[4]=ruleBasedCollatorNumber.getCollationKey("manish");
			collationKey[5]=ruleBasedCollatorNumber.getCollationKey("naman");
			
			Arrays.sort(collationKey);
			for(CollationKey c:collationKey){
				System.out.println(c.getSourceString());
			}
			
			String normalizedText = Normalizer.normalize("Text to normalize", Normalizer.Form.NFD);
			System.out.println(normalizedText);
			
			
		} catch (ParseException e) {e.printStackTrace();}  
	}

}

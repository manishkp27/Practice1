package com.manish;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong();
		//Long l=1L;
		long l1=0L, l2=111111L;
		/*if(l instanceof Long)
			System.out.println();*/
		
		atomicLong.compareAndSet(l1,l2);
		System.out.println(atomicLong );
	}

}

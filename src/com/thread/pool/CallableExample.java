package com.thread.pool;

import java.util.*;
import java.util.concurrent.*;

public class CallableExample {

	public static class WordLengthCallable implements Callable {
		private String word;
		public WordLengthCallable(String word) {
			this.word = word;
		}

		public Integer call() {
			return word.length();
		}
	}
	
	public static void main(String args[]) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Set<Future> setFutures  = new HashSet<Future>();
		String[] words={"1","222","3333"};
		
		for(String s:words){
			setFutures.add(executor.submit(new WordLengthCallable(s)));
		}
		
		int sum = 0;
	    for (Future<Integer> future : setFutures) {
	      sum += future.get();
	    }
	    System.out.printf("The sum of lengths is %s%n", sum);
	    System.exit(sum);
	}
	
}

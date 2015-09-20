package com.thread.threadGroup;

public class EnumThreads {

	public static void main(String[] args) {
		ThreadGroup systemTg=null, tg=Thread.currentThread().getThreadGroup();
		
		//Find system thread group
		while(tg!=null){
			systemTg=tg;
			tg=tg.getParent();
		}
		System.out.println("system Threadgruop:"+systemTg);
		
		//Display a list of all system and application threads, and their daemon status
		if(systemTg!=null){
			Thread[] thds = new Thread[systemTg.activeCount()];
			int n= systemTg.enumerate(thds);
			for(int i=0;i<n;i++){
				System.out.println(thds[i]+" "+thds[i].isDaemon());
			}
		}
	}

}

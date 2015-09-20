package com.thread.pool;

import java.util.*;

public class MyExecutorService {
	private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    public boolean isStopped = false;
    
    public MyExecutorService(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.stop();
        }
    }

}

class PoolThread extends Thread{
	private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }
    public void run(){
        while(!isStopped()){
            try{
                Runnable runnableTask = (Runnable) taskQueue.dequeue();
                runnableTask.run();
            } catch(Exception e){
            	e.printStackTrace();
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }
    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}


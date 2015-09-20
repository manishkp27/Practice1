package com.thread;
class Chat {
    boolean flag = false;
    public synchronized void Question(String msg) throws InterruptedException {
    	System.out.println("Chat.Question() msg:"+msg);
        if (flag) {
            	System.out.println("Chat.Question().wait() strt");
                wait();
                System.out.println("Chat.Question().wait() over");
        }
        System.out.println("Question:"+msg);
        flag = true;
        notify();
    }

    public synchronized void Answer(String msg) throws InterruptedException {
    	System.out.println("Chat.Answer() msg:"+msg);
        if (!flag) {
            	System.out.println("Chat.Answer().wait() strt");
                wait();
                System.out.println("Chat.Answer().wait() over");
        }

        System.out.println("Answer:"+msg);
        flag = false;
        notify();
    }
}

class T1 implements Runnable {
    Chat m;
    String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "Question").start();
        System.out.println("Thread Started: T1");
    }

    public void run() {
        for (int i = 0; i < s1.length; i++) {
            try {
				m.Question(s1[i]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}

class T2 implements Runnable {
    Chat m;
    String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

    public T2(Chat m2) {
        this.m = m2;
        new Thread(this, "Answer").start();
        System.out.println("Thread Started: T2");
    }

    public void run() {
        for (int i = 0; i < s2.length; i++) {
            try {
				//m.Answer(s2[i]);
            	boolean flag = false;
            	System.out.println("Chat.Answer() msg:"+s2[i]);
                if (!flag) {
                    	System.out.println("Chat.Answer().wait() strt");
                        wait();
                        System.out.println("Chat.Answer().wait() over");
                }

                System.out.println("Answer:"+s2[i]);
                flag = false;
                notify();
                
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
public class ChatThread {
    public static void main(String[] args) {
        Chat m = new Chat();
        new T2(m);
        new T1(m);
       
    }
}
package com.data.structure;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import com.data.structure.HashSetDemo;



//http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
public class ll {
	/*static void llTest(){
	LinkedList<String> ll = new LinkedList<>();
	ll.add("a");	
	for(String str:ll)
		System.out.println(str);	
	Iterator<String> itr = ll.iterator();
	while(itr.hasNext())
		System.out.println(itr.next());
	}*/
	
	public static void main(String[] args) {
		//llTest();
		
		MyLList<String> myllist = new MyLList<>();
		myllist .add("manish");
		myllist .add("satish");
		myllist .add("ashish");
		myllist.traverse();
		
		//myllist .addAfterData("satish","rajanish");
		//myllist.deleteFront();
		//myllist.traverse();
		
		//myllist.addLoop();
		//System.out.println("Has Loop:"+myllist.hasLoop());
		//myllist.reverse();
	}
}

class MyLList<T>{
	Node<T> head=null;
	Node<T> tail=null;
	int size = 0;
	
	void addLoop(){
		if(tail!=null)
			tail.nextRef=head;
		else
			System.out.println("addLoop() no data in Linkedlist");
	}
	
	void reverse(){
		Node tempSrc=head;
		Node tempDest=head;
		tempDest.nextRef=null;
		//Node revHead=null;
		Node local=null;
		
		//revHead.nextRef=null;
		while(tempSrc!=null)
		{
			local=tempSrc;
			tempSrc = tempSrc.nextRef;
			if(local!=null)
			{
				local.nextRef=tempDest;
				tempDest=local;
			}
		}
		
		System.out.println("Print reversed linked list");
		Node<T> print=tempDest;
		while(print!=null){
			System.out.println(print.data);
			print=print.nextRef;
		}
		
	}
	
	void reverseListIteratively(Node head) {
		if (head == null || head.nextRef == null)
			return; // empty or just one node in list

		Node Second = head.nextRef;

		// store third node before we change
		Node Third = Second.nextRef;

		// Second's nextRef pointer
		Second.nextRef = head; // second now points to head
		head.nextRef = null; // change head pointer to null

		// only two nodes, which we already reversed
		if (Third == null)
			return;

		Node CurrentNode = Third;

		Node PreviousNode = Second;

		while (CurrentNode != null) {
			Node NextNode = CurrentNode.nextRef;

			CurrentNode.nextRef = PreviousNode;

			/*
			 * repeat the process, but have to reset the PreviousNode and
			 * CurrentNode
			 */

			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}

		head = PreviousNode; // reset the head node
	}

	boolean hasLoop(){
		if(head==null )
			return false;
		
		Node slow = head, fast = head;
		
		while(true){
			System.out.println("slow:"+slow.data+", fast:"+fast.data);
			if(slow.nextRef!=null)
				slow=slow.nextRef;
			/*else
				return false;*/
			
			if(fast!=null && fast.nextRef!=null)
				fast=fast.nextRef.nextRef;
			else
				return false;
			
			
			if(slow==fast)
				return true;
		}
	}
	
	//more time consuming
	 boolean hasLoopVisited(){
	    if(head == null) return false;

	    Node slow = head, fast = head;
	    int taken = 0, limit = 2;

	    while(slow.nextRef != null && fast.nextRef != null){
	        fast = fast.nextRef;
	        taken++;
	        if(slow == fast) 
	        	return true;

	        if(taken == limit){
	            taken = 0;
	            limit <<= 1;    // equivalent to limit *= 2;
	            slow = fast;    // teleporting the turtle (to the hare's position) 
	        }
	    }
	    return false;
	}
	
	//add to end
	void add(T data){
		Node<T> nd= new Node<T>(data);
		
		//add first element
		if(head==null)
			head=tail=nd;
		else{
			tail.nextRef=nd;
			tail=tail.nextRef;
		}
		
	}
	void addFirst(T data)
	{
		head = new Node<T>(data,head);
		
	}
	void addAfterData(T data,T after)
	{
		Node<T> temp=head;
		
		while(temp!=null)
		{
			if(temp.data.equals(data))
			{
				System.out.println("data found to add after");
				temp.nextRef=new Node<T>(after,temp.nextRef);
			}
			temp=temp.nextRef;
		}
	}
	
	void deleteFront()
	{
		Node<T> temp=head;
		if(head==null)
			System.out.println("no nodes exists");
		else if(head.nextRef!=null){
			head = head.nextRef;
			System.out.println("delete:"+temp.data);
			temp = null;
		
		}
		else
		{System.out.println("delete:"+head.data);
			head = null;
		}
	}
	void deleteAfterData(T after)
	{
		Node<T> temp=head;
		Node<T> delete=null;
		while(temp!=null)
		{
			if(temp.data.equals(after) && temp.nextRef!=null)
			{
				System.out.println("data found to add after");
				delete=temp.nextRef;
				temp.nextRef=temp.nextRef.nextRef;
				delete=null;
			}
			temp=temp.nextRef;
		}
	}
	void traverse()
	{
		System.out.println("----traverse----");
		Node<T> temp=head;
		
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.nextRef;
		}
	}
}

class Node<T>
{
	T data;
	Node<T> nextRef;
	
	Node(T data){
		this.data=data;
		nextRef = null;
	}
	Node(T data, Node<T> next){
		this.data=data;
		nextRef = next;
	}
}
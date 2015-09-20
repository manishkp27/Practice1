package com.data.structure;
import java.util.*;
public class TreeDemo2 {

	public static void main(String[] arg){
		/*TreeSet tree=new TreeSet();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		System.out.println(tree.iterator().next());*/
		
		MyTree tree = new MyTree();
		tree.add(4);tree.add(7);
		tree.add(3);
		tree.add(2);
		tree.add(8);
		tree.add(1);
		tree.add(12);
		tree.add(6);
		tree.preorder();
		tree.inorder();
		tree.postorder();
	}
}
class MyTree {
	Node1 root;
	
	MyTree(){
		root=null;
	}
	void inorder(){
		System.out.println("\ninorder:");
		inorder(root);
	}
	void inorder(Node1 r){
		if(r!=null){
			inorder(r.left);
			System.out.print(r.data+" ");
			inorder(r.right);
		}
	}
	void preorder(){
		System.out.println("\npreorder:");
		preorder(root);
	}
	void preorder(Node1 r){
		if(r!=null){
			System.out.print(r.data+" ");
			preorder(r.left);
			preorder(r.right);
		}
	}
	void postorder(){
		System.out.println("\npostorder:");
		postorder(root);
	}
	void postorder(Node1 r){
		if(r!=null){
			postorder(r.left);
			postorder(r.right);
			System.out.print(r.data+" ");
		}
	}
	
	void remove(int data){
		if(root==null){
			return;
		}
		else{
			root = remove(root,data);
		}
	}
	Node1 remove(Node1 node, int data){
		Node1 p,p2,n;
		if(node.data==data){
			Node1 lt,rt;
			
			lt=node.left;
			rt=node.right;
			if(lt==null && rt==null)
				return null;
			else if(lt==null){
				p=rt;
				return p;
			}
			else if(rt==null){
				p=lt;
				return p;
			}
			else{
				p2=rt;
				p=rt;
				while(p.left!=null)
					p=p.left;
				p.left=lt;
				return p2;
			}
		}
		if(data<node.data){
			n=remove(node.left,data);
			node.left=n;
		}
		else{
			n=remove(node.right,data);
			node.right=n;
		}
		
		return n;
		
	}
	
	void add(int data){
		this.root=add(root,data);
	}
	
	Node1 add(Node1 node, int data){
		if(node==null){
			node=new Node1(data);
		}
		else
		{	if(data<=node.data){
				node.left= add(node.left,data);
			}
			else if(data>node.data){
				node.right= add(node.right,data);
			}
		}
		
		return node;
	}

	int countNodes(){
		return countNodes(root);
	}
	int countNodes(Node1 node){
		if(node==null){
			return 0;
		}
		else{
			int l=1;
			l += countNodes(node.left);
			l += countNodes(node.right);
			return l;
		}
	}
	
}

class Node1 {
	Integer data;
	Node1 left,right;
	
	public Node1(int data){
		this.data=data;
		left=null;
		right=null;
	}
}

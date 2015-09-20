package com.data.structure;
import java.util.*;
public class TreeDemo {

	public static void main(String[] arg){
		
		/*TreeSet tree=new TreeSet();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		System.out.println(tree.iterator().next());*/
		
		MyTree_1 tree = new MyTree_1();
		tree.add(3);
		tree.add(4);
		tree.add(2);
		tree.add(8);
		//tree.add(1);
		//tree.add(12);
		//tree.add(6);
		//System.out.println(tree.countNodes());
		
		//tree.remove(3);
		//System.out.println(tree.diameterofTree());
		
		System.out.println("TreeDemo over");
	}
}
class MyTree_1 {
	BSTNode root;
	
	MyTree_1(){
		root=null;
	}

	int diameterofTree(){
		int depth=0;
		if(root!=null){
			depth=1;
			depth += diameterofTree(root.left);
			depth += diameterofTree(root.right);
		}
		
		return depth;
	}
	int diameterofTree(BSTNode node){
		int depth=0;
		
		if(node!=null){
			int depthL = diameterofTree(node.left);
			int depthR = diameterofTree(node.right);
			depth =( depthL>depthR?depthL:depthR) +1;
		}
		
		return depth;
	}
	
	public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
	
	//search
	public boolean search(int val)
    {
        return search(root, val);
    }
	private boolean search(BSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.data;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
	void remove(int data){
		if(root==null){
			return;
		}
		else{
			root = remove(root,data);
		}
	}
	BSTNode remove(BSTNode node, int data){
		BSTNode p,p2,n;
		if(node.data==data){
			BSTNode lt,rt;
			
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
	
	BSTNode add(BSTNode node, int data){
		if(node==null){
			node=new BSTNode(data);
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
	int countNodes(BSTNode node){
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

class BSTNode {
	Integer data;
	BSTNode left,right;
	
	public BSTNode(int data){
		this.data=data;
		left=null;
		right=null;
	}
}

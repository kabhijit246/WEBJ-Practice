//Preorder traversal and Inorder traversal of binary tree
package com.beehyv.assignment.trees.traversal;

import com.beehyv.assignment.trees.Node;

public class TreeTraversal {

	private void preorderTraversal(Node node) {
		if (node == null) 
			return; 

		//first print data of node 
		System.out.print(node.data + " "); 

		//then recur on left subtree 
		preorderTraversal(node.left); 

		//now recur on right subtree
		preorderTraversal(node.right); 
	}

	private void inorderTraversal(Node node) {
		if (node == null) 
			return; 

		//first recur on left subtree
		inorderTraversal(node.left); 

		//then print the data of node
		System.out.print(node.data + " "); 

		//now recur on right subtree
		inorderTraversal(node.right); 
	}

	public static void main(String[] args) 
	{ 
		TreeTraversal tree = new TreeTraversal(); 
		Node first = new Node(1); 
		first.left = new Node(2); 
		first.right = new Node(3); 
		first.left.left = new Node(4); 
		first.left.right = new Node(5);
		first.left.right.right = new Node(6);
		first.left.right.right.right = new Node(7);

		System.out.println("Preorder traversal of binary tree is:"); 
		tree.preorderTraversal(first); 

		System.out.println("\nInorder traversal of binary tree is:"); 
		tree.inorderTraversal(first);  
	}
}

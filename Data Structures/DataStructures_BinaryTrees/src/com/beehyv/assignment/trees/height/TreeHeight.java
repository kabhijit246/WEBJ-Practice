//calculating height of binary tree.
package com.beehyv.assignment.trees.height;

import com.beehyv.assignment.trees.Node;

public class TreeHeight {

	private int height(Node node)  
	{ 
		if (node == null) 
			return 0; 

		else 
		{ 
			//calculate height of each subtree
			int heightLeft = height(node.left); 
			int heightRight = height(node.right); 

			//use the larger one
			if (heightLeft > heightRight) 
				return (heightLeft + 1); 
			else 
				return (heightRight + 1); 
		} 
	}

	public static void main(String[] args) {
		TreeHeight tree = new TreeHeight(); 
		Node first = new Node(1); 
		first.left = new Node(2); 
		first.right = new Node(3); 
		first.left.left = new Node(4); 
		first.left.right = new Node(5);
		first.left.right.right = new Node(6);
		first.left.right.right.right = new Node(7);
		System.out.println("Height of tree is: " + tree.height(first)); 
	}
}

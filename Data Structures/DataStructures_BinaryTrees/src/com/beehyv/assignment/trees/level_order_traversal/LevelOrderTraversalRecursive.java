package com.beehyv.assignment.trees.level_order_traversal;

import com.beehyv.assignment.trees.Node;

public class LevelOrderTraversalRecursive {

	private void levelOrderTraversal(Node node) {
		int h = height(node);  
		for (int i = 1; i <= h; i++) 
		{ 
			currentLevelPrint(node, i); 
			System.out.println(); 
		} 
	} 

	private int height(Node node) {
		if (node == null) 
			return 0; 

		else 
		{ 
			//calculate depth of each subtree
			int heightLeft = height(node.left); 
			int heightRight = height(node.right); 

			//use the larger one
			if (heightLeft > heightRight) 
				return (heightLeft + 1); 
			else 
				return (heightRight + 1);
		}
	}

	private void currentLevelPrint(Node node, int i) {
		if (node == null) 
			return; 
		if (i == 1) 
			System.out.print(node.data+ " "); 
		else if (i > 1) 
		{ 
			currentLevelPrint(node.left, i-1); 
			currentLevelPrint(node.right, i-1); 
		} 
	}

	public static void main(String[] args) {
		LevelOrderTraversalRecursive tree = new LevelOrderTraversalRecursive();
		Node first = new Node(1); 
		first.left = new Node(2); 
		first.right = new Node(3); 
		first.left.left = new Node(4); 
		first.left.right = new Node(5);
		first.left.right.right = new Node(6);
		first.left.right.right.right = new Node(7);
		tree.levelOrderTraversal(first);
	}
}

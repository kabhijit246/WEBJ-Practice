package com.beehyv.assignment.trees.search_tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.beehyv.assignment.trees.Node;

public class BinarySearchTree {

	List<Integer> list = new LinkedList<Integer>();

	//this method convert a binary tree to binary search tree 
	private Node conversion(Node node) {  
		//Converts binary tree to list  
		conversionTreeToList(node);  

		//list sorting
		Collections.sort(list);

		//Converts list to binary search tree  
		Node n = conversionListToTree(0, list.size()-1);  
		return n;  
	}

	//this method will convert binary tree to list
	private void conversionTreeToList(Node node) {
		//Check whether tree is empty  
		if(node == null){  
			System.out.println("Tree is empty");  
			return;  
		}  
		else {  
			if(node.left != null)  
				conversionTreeToList(node.left);  

			//Adds nodes of binary tree to treeList  
			list.add(node.data);

			if(node.right != null)  
				conversionTreeToList(node.right);    
		}        
	}

	//this method will convert list to binary search tree
	private Node conversionListToTree(int i, int j) {
		//It will avoid overflow  
		if (i > j) {  
			return null;  
		}  

		//Variable will store middle element of list and make it root of binary search tree  
		int mid = (i + j)/2;  
		Node node = new Node(list.get(mid));  

		//Construct left subtree  
		node.left = conversionListToTree(i, mid-1);  

		//Construct right subtree  
		node.right = conversionListToTree(mid+1, j);  

		return node;  
	}

	//this method perform inorder traversal on binary tree 
	private void inorderTraversal(Node node) {
		//Check whether tree is empty  
		if(node == null){  
			System.out.println("Tree is empty");  
			return;  
		}  
		else {  
			if(node.left != null)  
				inorderTraversal(node.left);

			System.out.print(node.data + " ");  

			if(node.right != null)  
				inorderTraversal(node.right);       
		}        
	}

	public static void main(String[] args) 
	{ 
		BinarySearchTree tree = new BinarySearchTree(); 
		Node first = new Node(1); 
		first.left = new Node(2); 
		first.right = new Node(3); 
		first.left.left = new Node(4); 
		first.left.right = new Node(5); 
		first.left.right.right = new Node(6);
		first.left.right.right.right = new Node(7);

		//Print given binary tree  
		System.out.println("Inorder traversal of binary tree:");  
		tree.inorderTraversal(first);  

		//Converts binary tree to corresponding binary search tree  
		Node binarySearchTree = tree.conversion(first);  

		//Print corresponding binary search tree  
		System.out.println("\nInorder traversal of resulting binary search tree:");  
		tree.inorderTraversal(binarySearchTree);  
	}
}

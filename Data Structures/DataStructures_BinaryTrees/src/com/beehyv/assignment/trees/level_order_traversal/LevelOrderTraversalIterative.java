//to print the elements of tree as level order by iteration
package com.beehyv.assignment.trees.level_order_traversal;

import java.util.LinkedList;
import java.util.Queue;
import com.beehyv.assignment.trees.Node;

public class LevelOrderTraversalIterative {

	private void levelOrderTraversal(Node node) {
		if(node == null) 
			return; 

		//Create an empty queue for level order traversal 
		Queue<Node> queue =new LinkedList<Node>(); 

		//adding node in queue and initialize height 
		queue.add(node); 

		while(true) 
		{  
			int nodeCount = queue.size(); 
			if(nodeCount == 0) 
				break; 

			//removing all nodes of current level and adding all nodes of next level 
			while(nodeCount > 0) 
			{ 
				Node n = queue.peek(); 
				System.out.print(n.data + " "); 
				queue.remove(); 

				if(n.left != null) 
					queue.add(n.left); 

				if(n.right != null) 
					queue.add(n.right); 

				nodeCount--; 
			} 
			System.out.println(); 
		} 

	}

	public static void main(String[] args) {
		LevelOrderTraversalIterative tree = new LevelOrderTraversalIterative();
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

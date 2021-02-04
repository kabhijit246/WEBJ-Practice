//to print top view of the binary tree
package com.beehyv.assignment.trees.top_view;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import com.beehyv.assignment.trees.Node;

public class TopViewBinaryTree {

	static class QueueObjectPair { 
		Node node; 
		int value; 
		QueueObjectPair(Node node, int value) { 
			this.node = node; 
			this.value = value; 
		}  
	}

	private void topView(Node node) {
		if (node == null) { 
			return; 
		} 

		Queue<QueueObjectPair> queue =  new LinkedList<QueueObjectPair>(); 

		// map to store node at each vertical distance 
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); 

		queue.add(new QueueObjectPair(node, 0));

		//temporary node 
		Node temp = null;  
		while (queue.size() > 0) { 
			temp = queue.peek().node;
			int v = queue.peek().value;
			queue.remove(); 

			//If any node is not at that vertical distance just insert that node in map and print it 
			if (map.get(v) == null) {
				map.put(v, temp.data); 
			} 

			//Continue for left node 
			if (temp.left != null) { 
				queue.add(new QueueObjectPair(temp.left, v-1)); 
			} 

			// Continue for right node 
			if (temp.right != null) { 
				queue.add(new QueueObjectPair(temp.right, v+1)); 
			} 
		} 
		for(Integer data:map.values()){ 
			System.out.print(data + " "); 
		} 
	}

	public static void main(String[] args) 
	{ 
		TopViewBinaryTree tree = new TopViewBinaryTree(); 
		Node first = new Node(1); 
		first.left = new Node(2); 
		first.right = new Node(3); 
		first.left.left = new Node(4); 
		first.left.right = new Node(5); 
		first.left.right.right = new Node(6);
		first.left.right.right.right = new Node(7);
		System.out.println("Nodes in top view of Binary Tree are:");  
		tree.topView(first);
	}
}

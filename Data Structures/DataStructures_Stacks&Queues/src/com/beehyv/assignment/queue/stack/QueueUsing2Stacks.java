//Implementation of queue using 2 stacks
package com.beehyv.assignment.queue.stack;

import java.util.Stack;

public class QueueUsing2Stacks {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public void enQueue(int i) {
		//transfering all elements from s1 to s2  
		while (!s1.isEmpty()) 
		{  
			s2.push(s1.pop());   
		}  

		//element pushed to s1  
		s1.push(i);  

		//Pushing everything back to s1 from s2 
		while (!s2.isEmpty())  
		{  
			s1.push(s2.pop());    
		} 

		System.out.println(i +" is pushed to the queue");
	}

	public int deQueue() {
		//if first stack is empty  
		if (s1.isEmpty())  
		{  
			System.out.println("Queue is Empty");  
			System.exit(0);  
		}  

		//top element of s1 
		int p = s1.peek();  
		s1.pop();  
		return p;  
	}
}

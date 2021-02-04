//Implementation of stack using two queues.
package com.beehyv.assignment.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int i) {
		q1.add(i);  //pushing all elements to q1 initially
		System.out.println(i+ " is pushed to the stack");
	}

	public int peek() {
		if (q1.isEmpty()) {
			System.out.println("Empty stack");
			System.exit(0); 
		}
		//Leave one element in q1 and push others in q2.
		while(q1.size() != 1) { 
			q2.add(q1.peek()); //transfering all elements of q1 to q2 except the last element
			q1.remove();      //removing all the elements from q1 except the last element
		} 

		//last pushed element or last element of q1
		int temp = q1.peek(); 

		//removing last element of q1 (q1 is empty now)
		q1.remove(); 

		//now last element of q1 is also pushed to q2 
		q2.add(temp); 

		//now swap the two queues names 
		Queue<Integer> q = q1; 
		q1 = q2; 
		q2 = q; 

		return temp; 
	}

	public int pop() {
		if (q1.isEmpty()) {
			System.out.println("Empty stack");
			System.exit(0);
		}

		//Leave one element in q1 and push others in q2. 
		while(q1.size() != 1) { 
			q2.add(q1.peek());   //transfering all elements of q1 to q2 except the last element
			q1.remove();        //removing all the elements from q1 except the last element
		} 

		//remove the last element left in q1 
		int p = q1.remove();  

		//now swap the names of two queues 
		Queue<Integer> q = q1; 
		q1 = q2; 
		q2 = q; 

		return p;
	}
}

//Implementation of queues with push, pop and peek operations.
package com.beehyv.assignment.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
	Queue<Integer> queue = new LinkedList<Integer>();

	//adding elements to queue
	public void push(int i) {
		queue.add(i);
		System.out.println(i +" is pushed to the queue");
	}

	//element in front of queue
	public int peek() {
		if(queue.isEmpty()) {
			System.out.println("Empty Queue");
			System.exit(0);
			return 0;
		}
		else {
			int p = queue.peek();
			return p;
		}
	}

	//taking out front element of queue
	public int pop() {
		if(queue.isEmpty()) {
			System.out.println("Empty Queue");
			System.exit(0);
			return 0;
		}
		else {
			int p = queue.remove();
			return p;
		}
	}
}

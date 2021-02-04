package com.beehyv.assignment.queues;

public class Main {
	public static void main(String[] args) {
		Queues q = new Queues();
		q.push(101);
		q.push(202);
		q.push(303);
		q.push(404);
		q.push(505);
		q.push(606);
		System.out.println(q.peek() +" is at front of queue.");
		System.out.println(q.pop() +" eliminated from the front of queue.");
		System.out.println("Now "+ q.peek() +" is at front of queue.");
	}
}

package com.beehyv.assignment.queue.stack;

public class Main {
	public static void main(String[] args) {
		QueueUsing2Stacks qs = new QueueUsing2Stacks();
		qs.enQueue(1);
		qs.enQueue(2);
		qs.enQueue(3);
		qs.enQueue(4);
		qs.enQueue(5);
		qs.enQueue(6);
		System.out.println(qs.deQueue() +" is eliminated from the front of queue");
	}
}

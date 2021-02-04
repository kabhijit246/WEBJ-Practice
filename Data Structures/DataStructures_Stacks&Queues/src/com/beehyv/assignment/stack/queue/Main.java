package com.beehyv.assignment.stack.queue;

public class Main {
	public static void main(String[] args) {
		StackUsing2Queues sq = new StackUsing2Queues();
		sq.push(111);
		sq.push(222);
		sq.push(333);
		sq.push(444);
		sq.push(555);
		sq.push(666);
		System.out.println(sq.peek() +" is a peek value of stack");
		System.out.println(sq.pop() + " popped out from stack");
		System.out.println("Now "+ sq.peek() +" is a peek value of stack");
	}
}

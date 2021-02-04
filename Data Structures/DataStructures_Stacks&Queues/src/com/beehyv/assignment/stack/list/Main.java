package com.beehyv.assignment.stack.list;

public class Main {
	public static void main(String[] args) {
		StackLinkedList sll = new StackLinkedList();
		sll.push(11);
		sll.push(22);
		sll.push(33);
		sll.push(44);
		sll.push(55);
		sll.push(66);
		System.out.println(sll.peek() +" is a peek value of stack");
		System.out.println(sll.pop() +" popped out from stack");
		System.out.println("Now "+ sll.peek() +" is a peek value of stack");
	}
}

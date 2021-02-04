package com.beehyv.assignment.stack.array;

public class Main {
	public static void main(String[] args) {
		StackArray sa = new StackArray();
		sa.push(1001);
		sa.push(2002);
		sa.push(3003);
		sa.push(4004);
		sa.push(5005);
		sa.push(6006);
		System.out.println(sa.peek() +" is a peek value of stack");
		System.out.println(sa.pop() +" popped out from stack");
		System.out.println("Now "+ sa.peek() +" is a peek value of stack");
	}
}

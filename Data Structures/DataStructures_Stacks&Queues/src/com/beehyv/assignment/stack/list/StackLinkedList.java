////implementation of stack using linkedlist
package com.beehyv.assignment.stack.list;

import java.util.LinkedList;
import java.util.List;

public class StackLinkedList {
	List<Integer> list = new LinkedList<Integer>();

	//pushing elements in stack
	public void push(int i) {
		list.add(i);
		System.out.println(i +" pushed into stack");
	}

	//element at the top of stack or peek value of stack
	public int peek() {
		if (list.isEmpty()) { 
			System.out.println("Empty Stack"); 
			System.exit(0);
			return 0;
		} 
		else {
			int i = list.size();
			int l = list.get(i-1);
			return l;
		}
	}

	//taking out element from the top of stack
	public int pop() {
		if (list.isEmpty()) { 
			System.out.println("Empty Stack"); 
			System.exit(0);
			return 0;
		} 
		else {
			int i = list.size();
			int l = list.remove(i-1);
			return l;
		}
	}
}

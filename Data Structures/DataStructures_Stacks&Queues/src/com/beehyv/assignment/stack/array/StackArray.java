//Implementation of stack using array of size k.
package com.beehyv.assignment.stack.array;

public class StackArray {
	int k = 45;
	int a[] = new int[k];   //array of size k
	int top = -1;    

	//pushing elements into stack 
	public void push(int i) {
		if (top >= (k - 1)) { 
			System.out.println("Stack is full"); 
		} 
		else { 
			a[++top] = i; 
			System.out.println(i + " pushed into stack"); 
		} 	
	}

	//element at top of the stack or peek value of stack
	public int peek() {
		if (isEmpty()) { 
			System.out.println("Empty Stack"); 
			System.exit(0);
			return 0; 
		} 
		else { 
			int p = a[top]; 
			return p; 
		} 
	}

	//taking out elements from the top of stack
	public int pop() {
		if (isEmpty()) { 
			System.out.println("Empty Stack"); 
			System.exit(0);
			return 0; 
		} 
		else { 
			int p = a[top--]; 
			return p; 
		} 
	}

	//checking if stack is empty
	public boolean isEmpty() {
		return (top < 0);
	}	
}

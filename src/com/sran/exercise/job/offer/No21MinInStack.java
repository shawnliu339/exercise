package com.sran.exercise.job.offer;

import java.util.Stack;

public class No21MinInStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> stack = new MyStack<Integer>();
		
		System.out.println(stack.min());
		stack.pop();
		
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(0);
		
		System.out.println(stack.min());
		
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		
		

	}
	
	
	
	

}

class MyStack<T extends Comparable<T>> {
	private Stack<T> dataStack = new Stack<T>();
	private Stack<T> minStack = new Stack<T>();
	
	public T top() {
		return dataStack.peek();
	}
	
	public void push(T item) {
		dataStack.push(item);
		
		if (minStack.isEmpty() || minStack.peek().compareTo(item) > 0 ) {
			minStack.push(item);
		} else {
			minStack.push(minStack.peek());
		}
		
	}
	
	public T pop() {
		if (minStack.isEmpty() || dataStack.isEmpty()) {
			return null;
		}
		
		minStack.pop();
		return dataStack.pop();
	}
	
	public T min() {
		if (minStack.isEmpty()) {
			return null;
		}
		
		return minStack.peek();
	}
	
}
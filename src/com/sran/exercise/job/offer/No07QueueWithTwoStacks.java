package com.sran.exercise.job.offer;

import java.util.EmptyStackException;
import java.util.Stack;

public class No07QueueWithTwoStacks {

	public static void main(String[] args) {
		CQueue<Integer> intQ = new CQueue<Integer>();
		intQ.appendTail(1);
		intQ.deleteHead();
		intQ.deleteHead();
		System.out.println("========");
		intQ.appendTail(1);
		intQ.deleteHead();

	}

}

class CQueue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public CQueue() {
		this.stack1 = new Stack<T>();
		this.stack2 = new Stack<T>();
	}

	public void appendTail(T node) {
		stack1.push(node);
	}

	public T deleteHead() {
		T head = null;
		try {
			//灵活对条件取反，可以大大降低条件长度
			if (stack2.size() <= 0) {
				while (stack1.size() > 0)
					stack2.push(stack1.pop());
			}
			head = stack2.pop();
		} catch (EmptyStackException e) {
			System.out.println("Queue is empty!");
		}
		return head;
	}
}

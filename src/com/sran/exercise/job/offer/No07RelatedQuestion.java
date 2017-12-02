package com.sran.exercise.job.offer;

import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class No07RelatedQuestion {

	public static void main(String[] args) {
		MyStack2<Integer> stack = new MyStack2<Integer>();
		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}

class CStack<T> {
	private Queue<T> queue1;
	private Queue<T> queue2;

	public CStack() {
		this.queue1 = new LinkedList<T>();
		this.queue2 = new LinkedList<T>();
	}

	public void push(T node) {

		//再次注意条件的选择
		if (queue2.size() > 0 && queue1.size() <= 0)
			queue2.add(node);
		else
			queue1.add(node);
	}

	public T pop() {
		if (queue1.size() <= 0 && queue2.size() <= 0)
			return null;
		if (queue1.size() > 0 && queue2.size() <= 0) {
			while (queue1.size() > 0) {
				if (queue1.size() == 1)
					return queue1.remove();

				queue2.add(queue1.remove());
			}
		} else {
			while (queue2.size() > 0) {
				if (queue2.size() == 1)
					return queue2.remove();

				queue1.add(queue2.remove());
			}

		}
		return null;
	}
}

class MyStack2<T> {
	private Queue<T> queue1;
	private Queue<T> queue2;
	
	public MyStack2() {
		this.queue1 = new LinkedList<T>();
		this.queue2 = new LinkedList<T>();
	}
	
	public void push(T item) {
	    if (queue2.size()>0 && queue1.size()<=0) {
	        queue2.add(item);
	    } else {
	        queue1.add(item);
	    }
	}

	public T pop () {

	    if(queue1.isEmpty()) {
	        Queue<T> temp = queue1;
	        queue1 = queue2;
	        queue2 = temp;
	    }

	    while (queue1.size()>1) {
	        T item = queue1.remove();
	        queue2.add(item);
	    }

	    T head = null;
	    try {
	        head = queue1.remove();
	    } catch (NoSuchElementException e) {
	        System.out.println("Stack is empty!");
	    }
	    
	    return head;
	}
}

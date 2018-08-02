package com.sran.exercise.job;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {

	Test1 test1 = new Test1("test, but out of constructor");
	
	public static void printListReversing (ListNode head) {
		if (head == null) {
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while (head != null) {
			stack.push(head.value);
			head = head.next;
		}
		while (stack.empty() != true) {
			System.out.print(stack.pop().toString() + ',');
		}
	}
	
	static {
		System.out.println("class is loaded");
	}

	public Test() {
		this.test1 = new Test1("test");
		
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.add(3);
		heap.add(4);
		heap.add(1);
		heap.add(5);
		for(Integer a : heap) {
			System.out.println(a);
		}
		System.out.println(heap.poll());
		for(Integer a : heap) {
			System.out.println(a);
		}
		
	}

}

class Test1 {
	public Test1(String str) {
		System.out.println("new a test1 in " + str);
	}
}
class ListNode {
	int value;
	ListNode next;
}
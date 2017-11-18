package com.sran.exercise.job.offer;

import java.util.Iterator;
import java.util.LinkedList;

public class No45LastNumberInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastNumberInCircleByStdLib(4000, 997));
		System.out.println(lastNumberInCircle(4000, 997));
	}

	public static int lastNumberInCircleByStdLib(int n, int m) {
		if (n <= 0 || m < 0) {
			return -1;
		}

		LinkedList<Integer> circle = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			circle.add(i);
		}
		Iterator<Integer> iterator = circle.iterator();
		while (circle.size() > 1) {
			if (!iterator.hasNext()) {
				iterator = circle.iterator();
			}
			iterator.next();
			for (int i = 1; i < m; i++) {
				
				if (!iterator.hasNext()) {
					iterator = circle.iterator();
				}
				iterator.next();
			}
			iterator.remove();
			
		}

		return circle.getFirst();
	}

	public static int lastNumberInCircle(int n, int m) {
		if (n <= 0 || m < 0) {
			return -1;
		}

		CircleNode node = createCircle(n);
		while (node.next != node || node.prev != node) {
			for (int i = 1; i < m; i++) {
				node = node.next;
			}
			deleteNode(node);
			node = node.next;
		}

		return node.val;
	}

	public static CircleNode createCircle(int n) {
		if (n <= 0) {
			return null;
		}
		CircleNode head = new CircleNode(0);
		CircleNode node = head;
		for (int i = 1; i < n; i++) {
			node.next = new CircleNode(i);
			node.next.prev = node;
			node = node.next;
		}

		node.next = head;
		head.prev = node;

		return head;
	}

	public static void deleteNode(CircleNode node) {
		if (node == null) {
			return;
		}

		CircleNode prev = node.prev;
		CircleNode next = node.next;
		prev.next = next;
		next.prev = prev;
	}

}

class CircleNode {
	int val;
	CircleNode prev;
	CircleNode next;

	public CircleNode(int val) {
		this.val = val;
	}
}

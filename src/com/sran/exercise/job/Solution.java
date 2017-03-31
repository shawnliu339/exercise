package com.sran.exercise.job;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = new LinkedListNode(2);
		LinkedListNode tail = head;
		tail = _insert_node_into_singlylinkedlist(head, tail, 1);
		tail = _insert_node_into_singlylinkedlist(head, tail, 3);
		tail = _insert_node_into_singlylinkedlist(head, tail, 4);
		tail = _insert_node_into_singlylinkedlist(head, tail, 6);
		deleteOdd(head);
		System.out.println("da an" + head.toString());

	}

	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int node_value) {
			val = node_value;
			next = null;
		}
	};

	public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
		if (head == null) {
			head = new LinkedListNode(val);
			tail = head;
		} else {
			tail.next = new LinkedListNode(val);
			tail = tail.next;
		}
		return tail;
	}

	/*
	 * Complete the function below.
	 */
	/*
	 * For your reference: LinkedListNode { int val; LinkedListNode *next; };
	 */

	static LinkedListNode deleteOdd(LinkedListNode list) {

		LinkedListNode head = list;
		if (list == null) {
			return null;
		} else if (list.next == null) {
			if (list.val % 2 != 0) {
				return null;
			}
			return list;
		} else {
			LinkedListNode current = list;
			LinkedListNode former = list;
			while (current.next != null) {
				if (current.val % 2 != 0) {
					if (former == current) {
						head = current.next;
						former = head;
						current = current.next;
					} else {
						former.next = current.next;
						current = current.next;
					}
				}
				former = current;
				current = former.next;
			}
			if (current.val % 2 != 0) {
				former.next = null;
			}
		}

		return head;

	}
}

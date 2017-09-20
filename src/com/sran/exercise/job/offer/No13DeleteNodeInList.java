package com.sran.exercise.job.offer;

public class No13DeleteNodeInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head = new ListNode1(1);
		createList(head);
		ListNode1 node = getNode(head, 3);
		System.out.println(node.value);
	}

	public static void deleteNode(ListNode1 head, ListNode1 deleteNode) {
		deleteNode.value = deleteNode.next.value;
		deleteNode.next = deleteNode.next.next;
	}

	private static void createList(ListNode1 head) {
		for (int i = 2; i <= 10; i++) {
			ListNode1 node = new ListNode1(i);
			head.next = node;
		}
	}

	private static ListNode1 getNode(ListNode1 head, int index) {
		if (head == null || index < 0) {
			return null;
		}
		ListNode1 node = head;
		int start = 0;
		while (node.next != null) {
			if(start == index) {
				return node;
			}
			node = node.next;
			start++;
		}
		return node;
	}
}

class ListNode1 {
	public int value;
	public ListNode1 next;

	public ListNode1() {
	}

	public ListNode1(int value) {
		this.value = value;
	}

	public ListNode1(int value, ListNode1 next) {
		this.value = value;
		this.next = next;
	}
}

package com.sran.exercise.job.offer;

public class No13DeleteNodeInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head = new ListNode1(1);
		createList(head);
		printList(head);
		ListNode1 deleteNode = getNode(head, 9);
		deleteNode(head, deleteNode);
		printList(head);
	}

	public static void deleteNode(ListNode1 head, ListNode1 deleteNode) {

		// 非尾情况
		if (deleteNode.next != null) {

			// 多个节点，删除头结点
			if (head == deleteNode) {
				head.value = deleteNode.next.value;
				head.next = deleteNode.next.next;
				return;
			}

			// 多个节点，删除非尾节点
			deleteNode.value = deleteNode.next.value;
			deleteNode.next = deleteNode.next.next;

			// 删除只有一个节点的情况
		} else if (deleteNode == head) {
			head = null;

		} else {
			// 多个节点，删除尾节点
			ListNode1 node = head;
			while (node.next != deleteNode) {
				node = node.next;
			}
			
			node.next = null;
		}

	}

	private static void createList(ListNode1 head) {

		for (int i = 2; i <= 10; i++) {
			ListNode1 node = new ListNode1(i);
			append(head, node);
		}
	}

	private static void append(ListNode1 head, ListNode1 addNode) {
		if (head == null) {
			head = addNode;
		} else {

			ListNode1 node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = addNode;
		}

	}

	private static void printList(ListNode1 head) {
		ListNode1 node = head;
		System.out.print(node.value + " ");
		while (node.next != null) {
			node = node.next;
			System.out.print(node.value + " ");
		}
		System.out.println();
	}

	private static ListNode1 getNode(ListNode1 head, int index) {
		if (head == null || index < 0) {
			return null;
		}
		ListNode1 node = head;
		int start = 0;
		while (node.next != null) {
			if (start == index) {
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

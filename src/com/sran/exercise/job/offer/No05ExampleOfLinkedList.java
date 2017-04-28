package com.sran.exercise.job.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No05ExampleOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList link = new LinkedList();
		link.print();
		link.append(1);
		link.append(2);
		link.append(3);
		link.append(2);
		link.print();
		System.out.println();
		link.print();

	}

}

class LinkedList {

	ListNode head;
	
	public void delete(int value) {
		if (head == null)
			return;
		if (head.value == value) {
			head = head.next;
		} else {
			ListNode node = head;
			// 该循环条件让循环永远停在需要删除的节点的前一项
			while (node.next != null && node.next.value != value)
				node = node.next;
			if (node.next != null && node.next.value == value) {
				node.next = node.next.next;
			}
		}
	}

	public void append(int value) {

		ListNode newNode = new ListNode();
		newNode.value = value;
		newNode.next = null;

		if (head == null) {

			head = newNode;
		} else {

			ListNode node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}

	}

	public void print() {
		if (head == null)
			System.out.println("null");
		else {
			ListNode node = head;
			System.out.print(node.value + " ");
			while (node.next != null) {
				node = node.next;
				System.out.print(node.value + " ");
			}
		}
	}
}

class ListNode {

	int value;
	ListNode next;
}

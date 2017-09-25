package com.sran.exercise.job.offer;

import java.util.List;

public class No16ReverseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head = createList();
		printList(reverseListByIteration(head));
	}
	
	public static ListNode1 reverseList(ListNode1 head) {
		if (head == null) {
			return null;
		}
		
		ListNode1 previous = null;
		ListNode1 current = head;
		ListNode1 next = head.next;
		while (next != null) {
			current.next = previous;
			
			previous = current;
			current = next;
			next = next.next;
			
			if (next == null) {
				current.next = previous;
			}
		}
		
		return current;
	}
	
	/**
	 * 通过迭代翻转单项链表
	 * 思路：翻转当前项前，先翻转后一项
	 * @param current
	 * @return
	 */
	public static ListNode1 reverseListByIteration(ListNode1 current) {
		if (current == null || current.next == null) {
			return current;
		}
		
		ListNode1 next = current.next;
		ListNode1 reversedHead = reverseListByIteration(next);
		next.next = current;
		current.next = null;
		return reversedHead;
	}
	
	private static void append (ListNode1 head, ListNode1 newNode) {
		if (head == null) {
			head = newNode;
			return;
		}
		
		ListNode1 node = head;
		while (node.next != null) {
			node = node.next;
		}
		
		node.next = newNode;
	}
	
	private static ListNode1 createList() {
		ListNode1 head = new ListNode1(1);
		
		for (int i=2; i<=10; i++) {
			ListNode1 addNode = new ListNode1(i);
			append(head, addNode);
		}
		
		return head;
		
	}
	
	private static void printList(ListNode1 head) {
		if (head == null) {
			System.out.println("[]");
			return;
		} else {
			
			System.out.print("[" + head.value + ",");
			ListNode1 node = head;
			while (node.next != null) {
				node = node.next;
				System.out.print(node.value + ",");
			}
			
			System.out.println("]");
		}
	}

}

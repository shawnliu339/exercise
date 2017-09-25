package com.sran.exercise.job.offer;

public class No15KthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head = create();
		printList(head);
		System.out.println(findNode(head, 8));

	}
	
	public static ListNode1 findNode(ListNode1 head, int n) {
		
		if (n <=0 || head == null) {
			return null;
		}
		
		ListNode1 ahead = head;
		for (int i=0; i<n-1; i++) {
			if (ahead.next != null) {
				ahead = ahead.next;
			} else {
				return null;
			}
		}
		
		ListNode1 behind = head;
		
		while (ahead.next != null) {
			ahead = ahead.next;
			behind = behind.next;
		}
		
		return behind; 
	}
	
	private static ListNode1 create () {
		ListNode1 head = new ListNode1(1);
		for (int i=2; i<=10; i++) {
			append(head, new ListNode1(i));
		}
		return head;
	}
	
	private static void append(ListNode1 head, ListNode1 add) {
		if (head == null) {
			head = add;
		} else {
			ListNode1 node = head;
			
			while (node.next != null) {
				node = node.next;
			}
			
			node.next = add;
		}
	}
	
	private static void printList(ListNode1 head) {
		if (head == null) {
			System.out.println("[]");
			return;
		}
		
		if (head.next == null) {
			System.out.println("[" + head.value + "]");
			return;
		}
		
		if (head.next != null) {
			ListNode1 node = head;
			System.out.print("[");
			while (node.next != null) {
				node = node.next;
				System.out.print(node.value + ",");
			}
			System.out.println("]");
		}
	}

}

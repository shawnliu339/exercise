package com.sran.exercise.job.offer;

import java.util.HashSet;

public class No15RelatedQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head = createList();
		System.out.println(isRingListByHashMap(head));

	}
	
	public static boolean isRingListBy2Pointers(ListNode1 head) {
		if (head == null) {
			return false;
		}
		
		ListNode1 fast = head;
		ListNode1 slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isRingListByHashMap(ListNode1 head) {
		if (head == null) {
			return false;
		}
		HashSet<ListNode1> set = new HashSet<ListNode1>();
		ListNode1 node = head;
		while (node.next != null) {
			if (set.contains(node)){
				return true;
			} else {
				set.add(node);
			};
			node = node.next;
		}
		
		return false;
	}
	
	
	public static ListNode1 findMiddle (ListNode1 head) {
		
		if(head == null) {
			return null;
		}
		
		ListNode1 fast = head;
		ListNode1 slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	private static void append (ListNode1 head, ListNode1 addNode) {
		if (head == null) {
			head = addNode;
			return;
		}
		
		ListNode1 node = head;
		while (node.next != null) {
			node = node.next;
		}
		
		node.next = addNode;
		
	}
	
	private static ListNode1 createList() {
		ListNode1 head = new ListNode1(1);
		for (int i=2; i<=100; i++) {
			append(head, new ListNode1(i));
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
			
			System.out.print("]");
			System.out.println();
		}
	}

}

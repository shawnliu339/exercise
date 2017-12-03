package com.sran.exercise.job.offer2;

public class NO18DeleteDuplicatedNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(1);
		ListNode node7 = new ListNode(1);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		NO18DeleteDuplicatedNode o = new NO18DeleteDuplicatedNode();
		ListNode node = o.deleteDuplication(head);
		System.out.println();
	}

	public ListNode deleteDuplication(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode node = head;
		ListNode prev = null;
		while (node != null) {
			
			if (node.next!=null && node.val == node.next.val) {
				ListNode repeated = node;
				while (node != null && node.val == repeated.val) {
					node = node.next;
				}
				if (repeated.val != head.val) {
					prev.next = node;
				} else {
					head = node;
				}
			} else {
				prev = node;
				node = node.next;
			}
			
		}

		return head;
	}

}

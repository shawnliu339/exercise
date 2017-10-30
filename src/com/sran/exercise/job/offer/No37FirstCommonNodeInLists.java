package com.sran.exercise.job.offer;

public class No37FirstCommonNodeInLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode findCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}

		ListNode node = pHead1;
		int length1 = getListLength(pHead1);
		int length2 = getListLength(pHead2);

		int lengthDif = length2 - length1;
		ListNode longListHead = pHead2;
		ListNode shortListHead = pHead1;

		if (lengthDif < 0) {
			longListHead = pHead1;
			shortListHead = pHead2;
			lengthDif = length1 - length2;
		}

		for (int i = 0; i < lengthDif; i++) {
			longListHead = longListHead.next;
		}

		node = null;
		while (longListHead != null && 
				shortListHead != null) {
			if (longListHead == shortListHead) {
				node = longListHead;
				break;
			}
			longListHead = longListHead.next;
			shortListHead = shortListHead.next;
		}

		return node;
	}

	public static int getListLength(ListNode head) {
		ListNode node = head;
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}

		return length;
	}

}

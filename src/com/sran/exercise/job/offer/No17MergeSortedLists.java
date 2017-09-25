package com.sran.exercise.job.offer;

public class No17MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode1 head1 = createList(1);
		ListNode1 head2 = createList(3);
		printList(mergeByLoop(head1, head2));
	}
	
	public static ListNode1 mergeByLoop(ListNode1 head1, ListNode1 head2) {  
        if (head1 == null) {
        	return head2;
        } else if (head2 == null) {
        	return head1;
        }
        
        ListNode1 mergedHead = null;
        
        if (head1.value <= head2.value) {
        	mergedHead = head1;
        	head1 = head1.next;
        } else {
        	mergedHead = head2;
        	head2 = head2.next;
        }
        
        ListNode1 currentMergedHead = mergedHead;
        while (head1 != null && head2 != null) {
        	if (head1.value <= head2.value) {
        		currentMergedHead.next = head1;
        		currentMergedHead = currentMergedHead.next;
        		head1 = head1.next;
        	} else {
        		currentMergedHead.next = head2;
        		currentMergedHead = currentMergedHead.next;
        		head2 = head2.next;
        	}
        }
        
        currentMergedHead.next = (head1 == null)? head2: head1;
        
        return mergedHead;  
    }  
	
	public static ListNode1 mergeByIteration(ListNode1 head1, ListNode1 head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		
		ListNode1 mergedHead = null;
		
		if (head1.value <= head2.value) {
			mergedHead = head1;
			mergedHead.next = mergeByIteration(head1.next, head2);
		} else {
			mergedHead = head2;
			mergedHead.next = mergeByIteration(head1, head2.next);
		}
		
		return mergedHead;
		
	}

	public static void append(ListNode1 head, ListNode1 addNode) {
		if (head == null) {
			head = addNode;
			return;
		}

		while (head.next != null) {
			head = head.next;
		}

		head.next = addNode;
	}

	private static ListNode1 createList(int num) {
		ListNode1 head = new ListNode1(1 + num);
		for (int i = 2; i <= 10; i++) {
			append(head, new ListNode1(i + num));
		}

		return head;
	}

	private static void printList(ListNode1 head) {
		if (head == null) {
			System.out.println("[]");
			return;
		}

		System.out.print("[" + head.value + ",");
		while (head.next != null) {
			head = head.next;
			System.out.print(head.value + ",");
		}

		System.out.println("]");
	}

}

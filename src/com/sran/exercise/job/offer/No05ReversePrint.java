package com.sran.exercise.job.offer;

import java.util.Stack;

public class No05ReversePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList2 link = new LinkedList2();
		link.print();
		link.append(1);
		link.append(2);
		link.append(3);
		link.append(2);
		link.print();
		System.out.println();
		link.reversedPrintByIteration();

	}

}

class LinkedList2 extends LinkedList  {
	
	public void reversedPrintByIteration() {
		reversedPrintByIteration(head);
	}
	
	public void reversedPrintByIteration(ListNode node) {

		if (node != null) {
			
			if (node.next != null) {
				//此处改变了node的值造成了输出后移一位
				//node = node.next;
				reversedPrintByIteration(node.next);
			}
			
			System.out.print(node.value + " ");
		}
	}
	
	//翻转并非翻转输出
	public void reverseByLoop() {
		
		ListNode prev = null;
		//用于存储下一项，否则head脱离链表时，head.next指针反指前一项时会失去原链表的下一项
		ListNode next;
		
		while (head != null) {
			//每次循环开始后移next指针，相当于前一次head和next一起下移
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		head = prev;
		
		
	}
	
	public void reversedPrintByStack() {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = head;
		while (node != null)	{
			stack.push(node);
			node = node.next;
		}
		
		while (stack.isEmpty() == false) {
			node = stack.pop();
			System.out.print(node.value + " ");
		}
	}
}

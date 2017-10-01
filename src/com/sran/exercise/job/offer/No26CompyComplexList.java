package com.sran.exercise.job.offer;

import java.util.HashMap;

public class No26CompyComplexList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node1 = new RandomListNode(1);
		node1.next = new RandomListNode(2);
		node1.next.next = new RandomListNode(3);
		node1.next.random = node1.next.next;
		RandomListNode node = cloneListBySmart(node1);
	}
	
	public static RandomListNode cloneListBySmart(RandomListNode head) {
		cloneList(head);
		linkRandomNode(head);
		return cutClonedList(head);
	}
	
	public static void cloneList(RandomListNode head) {
		if (head == null) {
			return;
		}
		
		RandomListNode node = head;
		while (node != null) {
			RandomListNode clonedNode = new RandomListNode(node.label);
			clonedNode.next = node.next;
			node.next = clonedNode;
			node = clonedNode.next;
		}
	}
	
	public static void linkRandomNode (RandomListNode head) {
		if (head == null) {
			return;
		}
		
		RandomListNode node = head;
		while (node != null) {
			RandomListNode clonedNode = node.next;
			if (node.random != null) {
				clonedNode.random = node.random.next;
			}
			node = clonedNode.next;
		}
	}
	
	public static RandomListNode cutClonedList (RandomListNode head) {
		if (head == null) {
			return null;
		}
		
		RandomListNode node = head;
		RandomListNode clonedHead = node.next;
		RandomListNode clonedNode = node.next;
		node.next = clonedNode.next;
		node = node.next;
		
		while (node != null) {
			
			clonedNode.next = node.next;
			clonedNode = clonedNode.next;
			node.next = clonedNode.next;
			node = node.next;
		}
		
		/* 源代码出问题
		RandomListNode clonedHead = head.next;
		RandomListNode node = head;
		RandomListNode clonedNode = clonedHead;
		
		while (clonedNode != null && clonedNode.next != null) {
			node.next = clonedNode.next;
			node = node.next;
			clonedNode.next = clonedNode.next.next;
			clonedNode = clonedNode.next;
		}
		 */
		
		return clonedHead;
		
	}
	
	
	/* 使用Hashtable复制复杂链表 */
	public static RandomListNode cloneByHash(RandomListNode pHead) {
		if(pHead == null) {
			return null;
		}
		RandomListNode cloneHead = new RandomListNode(1);
		HashMap<RandomListNode, RandomListNode> hashTable = new HashMap<RandomListNode, RandomListNode>();
		cloneByHash(pHead, cloneHead, hashTable);
		return cloneHead;
	}
	
	public static void cloneByHash(RandomListNode node, 
			RandomListNode cloneNode, 
			HashMap<RandomListNode, RandomListNode> hashTable) {
		if (node == null) {
			return;
		}
		
		hashTable.put(node, cloneNode);
		cloneNode.label = node.label;
		if (node.next != null && !hashTable.containsKey(node.next)) {
			cloneNode.next = new RandomListNode(1);
			cloneByHash(node.next, cloneNode.next, hashTable);
		} else {
			cloneNode.next = hashTable.get(node.next);
		}
		
		if (node.random != null && !hashTable.containsKey(node.random)) {
			cloneNode.random = new RandomListNode(1);
			cloneByHash(node.random, cloneNode.random, hashTable);
		} else {
			cloneNode.random = hashTable.get(node.random);
		}
		
	}

}

class RandomListNode {
	int label;
	RandomListNode next;
	RandomListNode random;
	
	RandomListNode(int label) {
        this.label = label;
    }
}

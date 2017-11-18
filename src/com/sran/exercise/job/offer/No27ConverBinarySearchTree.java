package com.sran.exercise.job.offer;

public class No27ConverBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode convertTreeToLinkedList (TreeNode head) {
		
		if ( head == null) {
			return null;
		}
		
		TreeNode headOfList = convertNode(head, null);
		while (headOfList != null && headOfList.left != null) {
			headOfList = headOfList.left;
		}
		
		return headOfList;
		
	}
	
	public TreeNode convertNode(TreeNode node, TreeNode lastNodeInLinkedList) {
		if ( node == null) {
			return null;
		}
		
		TreeNode currentTreeNode = node;
		if (currentTreeNode.left != null) {
			lastNodeInLinkedList = convertNode(currentTreeNode.left, lastNodeInLinkedList);
		}
		
		//将树节点接到最后一个链表节点的后面。
		//由于是双向链表，所以先将树节点的左指针指向最后一个节点
		currentTreeNode.left = lastNodeInLinkedList;
		//再将最后一个链表节点的有指针指向树节点
		if (lastNodeInLinkedList != null) {
			lastNodeInLinkedList.right = currentTreeNode;
		}
		//最后一个链表节点后移
 		lastNodeInLinkedList = currentTreeNode;
		
		if (currentTreeNode.right != null) {
			lastNodeInLinkedList = convertNode(currentTreeNode.right, lastNodeInLinkedList);
		}
		
		return lastNodeInLinkedList;
	}
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

	@Override
	public String toString() {
		return "TreeNode [val=" + val +  "]";
	}
    

}

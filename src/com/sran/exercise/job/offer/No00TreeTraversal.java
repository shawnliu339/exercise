package com.sran.exercise.job.offer;

import java.util.HashSet;
import java.util.Stack;

public class No00TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = createTree();
		postOrderByLoop(root);
		System.out.println();
		postOrder(root);
	}
	
	public static void preOrderByLoop(TreeNode root) {
		if (root==null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node!=null || !stack.isEmpty()) {
			while (node!=null) {
				System.out.print(node.val + ",");
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}
	
	public static void inOrderByLoop(TreeNode root) {
		if (root==null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (node!=null || !stack.isEmpty()) {
			while (node!=null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.val + ",");
				node = node.right;
			}
		}
	}
	
	public static void postOrderByLoop(TreeNode root) {
		if (root==null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> timesStack = new Stack<Boolean>();
		TreeNode node = root;
		
		while (node!=null || !stack.isEmpty()) {
			while(node!=null) {
				stack.push(node);
				timesStack.push(true);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				if (timesStack.pop()==true) {
					timesStack.push(false);
					stack.push(node);
					node = node.right;
				} else {
					System.out.print(node.val + ",");
					node = null;
				}
			}
		}
	}
	
	public static void preOrder(TreeNode root ) {
		
		if (root==null) {
			return;
		}
		
		TreeNode node = root;
		System.out.print(node.val + ",");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(TreeNode root) {
		if (root==null) {
			return;
		}
		
		TreeNode node = root;
		inOrder(node.left);
		System.out.print(node.val + ",");
		inOrder(node.right);
	}
	
	public static void postOrder(TreeNode root) {
		if (root==null) {
			return;
		}
		
		TreeNode node = root;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + ",");
	}
	
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node11 = new TreeNode(2);
		root.left = node11;
		TreeNode node12 = new TreeNode(3);
		root.right = node12;
		TreeNode node111 = new TreeNode(4);
		node11.left = node111;
		TreeNode node112 = new TreeNode(5);
		node11.right = node112;
		TreeNode node122 = new TreeNode(6);
		node12.right = node122;
		TreeNode node1122 = new TreeNode(7);
		node112.right = node1122;
		return root;
	}

}

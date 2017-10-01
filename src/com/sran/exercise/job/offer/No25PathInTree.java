package com.sran.exercise.job.offer;

import java.util.Stack;

public class No25PathInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode1 root = createTree();
		
		findPath(root, 22);

	}

	public static void findPath(BinaryTreeNode1 root, int expectedSum) {
		if (root == null) {
			return;
		}
		
		int currentSum = 0;
		Stack<Integer> path = new Stack<Integer>();
		findPath(root, expectedSum, path, currentSum); 
	}

	public static void findPath(
			BinaryTreeNode1 root, 
			int expectedSum, 
			Stack<Integer> path, 
			int currentSum) {

		if (root == null) {
			return;
		}

		path.push(root.value);
		currentSum += root.value;
		
		boolean isLeaf = root.left == null && root.right == null;
		if (isLeaf && expectedSum == currentSum) {
			printPath(path);
		}
		
		findPath(root.left, expectedSum, path, currentSum);
		findPath(root.right, expectedSum, path, currentSum);
		
		path.pop();
		currentSum -= root.value;
	}
	
	public static void printPath(Stack<Integer> path) {
		if (path.isEmpty()) {
			return;
		}
		
		for (Integer value : path ) {
			System.out.print(value + " ");
		}
		
		System.out.println();
	}
	
	private static void appendLeftNode(BinaryTreeNode1 root, BinaryTreeNode1 leftNode) {
		if (root == null || leftNode == null) {
			return;
		}

		root.left = leftNode;
	}

	private static void appendRightNode(BinaryTreeNode1 root, BinaryTreeNode1 leftNode) {
		if (root == null || leftNode == null) {
			return;
		}

		root.right = leftNode;
	}

	private static BinaryTreeNode1 createTree() {
		BinaryTreeNode1 root = new BinaryTreeNode1(10);

		BinaryTreeNode1 currentRoot = root;
		BinaryTreeNode1 node = new BinaryTreeNode1(5);
		appendLeftNode(currentRoot, node);
		currentRoot = node;
		node = new BinaryTreeNode1(4);
		appendLeftNode(currentRoot, node);
		node = new BinaryTreeNode1(7);
		appendRightNode(currentRoot, node);
		currentRoot = root;
		node = new BinaryTreeNode1(12);
		appendRightNode(currentRoot, node);
		return root;
	}

}

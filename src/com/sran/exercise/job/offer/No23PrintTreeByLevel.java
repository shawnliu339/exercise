package com.sran.exercise.job.offer;

import java.util.LinkedList;
import java.util.Queue;

public class No23PrintTreeByLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode1 root = createTree();
		printTree(root);
	}

	public static void printTree(BinaryTreeNode1 node) {

		if (node == null) {
			return;
		}

		Queue<BinaryTreeNode1> queue = new LinkedList<BinaryTreeNode1>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.value + " ");
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

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
		BinaryTreeNode1 root = new BinaryTreeNode1(8);

		BinaryTreeNode1 currentRoot = root;
		BinaryTreeNode1 node = new BinaryTreeNode1(8);
		appendLeftNode(currentRoot, node);
		currentRoot = node;
		node = new BinaryTreeNode1(9);
		appendLeftNode(currentRoot, node);
		node = new BinaryTreeNode1(2);
		appendRightNode(currentRoot, node);
		currentRoot = node;
		node = new BinaryTreeNode1(4);
		appendLeftNode(currentRoot, node);
		node = new BinaryTreeNode1(7);
		appendRightNode(currentRoot, node);
		currentRoot = root;
		node = new BinaryTreeNode1(7);
		appendRightNode(currentRoot, node);
		return root;
	}

}

package com.sran.exercise.job.offer;

public class No19MirrorOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode1 root = createTree();
		mirrorRecursively(root);
		printRecursively(root);
	}
	
	public static void mirrorRecursively (BinaryTreeNode1 root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		
		BinaryTreeNode1 tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if (root.left != null) {
			mirrorRecursively(root.left);
		}
		
		if (root.right != null) {
			mirrorRecursively(root.right);
		}
	}
	
	private static void printRecursively (BinaryTreeNode1 root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + ",");
		printRecursively(root.left);
		printRecursively(root.right);
	}
	
	private static void appendLeftNode(BinaryTreeNode1 root, BinaryTreeNode1 leftNode) {
		if (root == null || leftNode==null) {
			return;
		}
		
		root.left = leftNode;
	}
	
	private static void appendRightNode(BinaryTreeNode1 root, BinaryTreeNode1 leftNode) {
		if (root == null || leftNode==null) {
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
		//appendLeftNode(currentRoot, node);
		node = new BinaryTreeNode1(7);
		appendRightNode(currentRoot, node);
		currentRoot = root;
		node = new BinaryTreeNode1(7);
		appendRightNode(currentRoot, node);
		return root;
	}

}

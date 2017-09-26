package com.sran.exercise.job.offer;

public class No18SubstructureInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode1 root = createTree();
		BinaryTreeNode1 subTree = createTree2();
		System.out.println(hasSubstructure(root, subTree));
	}
	
	public static boolean hasSubstructure (BinaryTreeNode1 tree, BinaryTreeNode1 subTree) {
		if (tree == null || subTree== null) {
			return false;
		}
		
		boolean result = false;
		
		if (tree.value == subTree.value) {
			result = isSubstructure(tree, subTree);
		}
		
		if (!result) {
			result = isSubstructure(tree.left, subTree);
		}
		
		if (!result) {
			result = isSubstructure(tree.right, subTree);
		}
		
		return result;
	}
	
	public static boolean isSubstructure (BinaryTreeNode1 tree, BinaryTreeNode1 subTree) {
		
		if (subTree == null) {
			return true;
		}
		if (tree == null) {
			return false;
		}
		if (tree.value != subTree.value) {
			return false;
		}
		return isSubstructure(tree.left, subTree.left) && isSubstructure(tree.right, subTree.right);
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
	
	private static BinaryTreeNode1 createTree2() {
		BinaryTreeNode1 root = new BinaryTreeNode1(8);
		
		BinaryTreeNode1 currentRoot = root;
		BinaryTreeNode1 node = new BinaryTreeNode1(9);
		appendLeftNode(currentRoot, node);
		node = new BinaryTreeNode1(2);
		appendRightNode(currentRoot, node);
		return root;
	}
	
	
	private static void printTree(BinaryTreeNode1 root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + ",");
		printTree(root.left);
		printTree(root.right);
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

}

class BinaryTreeNode1 {
	int value;
	BinaryTreeNode1 left;
	BinaryTreeNode1 right;
	
	public BinaryTreeNode1() {}
	
	public BinaryTreeNode1(int value) {
		this.value = value;
	}
}
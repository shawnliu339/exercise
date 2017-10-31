package com.sran.exercise.job.offer;

import java.util.Stack;

public class No39TreeDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = createTree();
		System.out.println(treeDepth(root));
	}

	public static int treePathByRecursion(TreeNode root) {

		if (root == null) {
			return 0;
		}
		TreeNode node = root;
		int depthOfLeft = treePathByRecursion(node.left);

		int depthOfRight = treePathByRecursion(node.right);

		return depthOfLeft > depthOfRight ? depthOfLeft + 1 : depthOfRight + 1;
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

	public static int treeDepth(TreeNode root) {
		int depth = 0;
		if (root == null) {
			return depth;
		}

		Stack<TreeNode> path = new Stack<TreeNode>();
		depth = calculateTreeDepth(root, path, depth);
		return depth;
	}

	public static int calculateTreeDepth(TreeNode root, Stack<TreeNode> path, int depth) {
		if (root == null) {
			return depth;
		}
		TreeNode node = root;
		path.push(node);
		depth = calculateTreeDepth(node.left, path, depth);
		depth = calculateTreeDepth(node.right, path, depth);
		if (path.size() > depth) {
			depth = path.size();
		}

		path.pop();
		return depth;
	}

}

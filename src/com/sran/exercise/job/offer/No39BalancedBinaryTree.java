package com.sran.exercise.job.offer;

public class No39BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 0;
		System.out.println(i.intValue());
	}
	private static boolean isBinary = true;
	
	public static boolean isBalancedBinaryTree(TreeNode root) {
		if (root==null) {
			return true;
		}
		
		isBinary = true;
		treeDepthByRecursion(root);
		return isBinary;
	}
	
	public static int treeDepthByRecursion(TreeNode root) {

		if (root == null) {
			return 0;
		}
		TreeNode node = root;
		int depthOfLeft = treeDepthByRecursion(node.left);

		int depthOfRight = treeDepthByRecursion(node.right);
		
		int diff = depthOfLeft - depthOfRight;
		if (diff<-1 || diff>1) {
			isBinary = false;
		}

		return depthOfLeft > depthOfRight ? depthOfLeft + 1 : depthOfRight + 1;
	}

}

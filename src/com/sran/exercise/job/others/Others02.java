package com.sran.exercise.job.others;

import java.util.Collection;

public class Others02 {
	
	int lastVist = Integer.MIN_VALUE;
	
	public boolean isBinary(TreeNode head) {
		if (head == null) 
			return true;
		
		boolean left = isBinary(head.left);
		if (lastVist <= head.value) {
			lastVist = head.value;
		} else {
			return false;
		}
		
		boolean right = isBinary(head.right);
		return left && right;
		
	}
	
	boolean isBalanced = false;
	
	public int calcuateDepth (TreeNode head) {
		if (head == null) {
			return 0;
		}
		
		int left = calcuateDepth(head.left);
		int right = calcuateDepth(head.right);
		if (Math.abs(right-left)<1)
			isBalanced = true;
		
		return left>right?left++:right++;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
}
package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No24RelatedQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPreorder(new int[] { 5, 7, 6, 9, 11, 10, 8 }));
		System.out.println(isPreorder(new int[] { 8,5,9,4,10,9,11}));
	}
	
	public static boolean isPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return false;
		} else if (preorder.length == 1) {
			return true;
		}
		
		int leftIndex = 1;
		int rootIndex = 0;
		
		while (leftIndex < preorder.length - 1) {
			if (preorder[leftIndex] > preorder[rootIndex]) {
				break;
			}
			leftIndex++;
		}
		
		int rightIndex = leftIndex;
		while (rightIndex < preorder.length - 1) {
			if (preorder[rightIndex] < preorder[rootIndex]) {
				return false;
			}
			rightIndex++;
		}
		
		boolean left = true;
		if (leftIndex>1) {
			int[] leftTree = Arrays.copyOfRange(preorder, 1, leftIndex);
			left = isPreorder(leftTree);
		}
		
		boolean right = true;
		if (leftIndex<preorder.length - 1) {
			int[] rightTree = Arrays.copyOfRange(preorder, leftIndex, preorder.length);
			right = isPreorder(rightTree);
		}
		
		return left && right;
	}

}

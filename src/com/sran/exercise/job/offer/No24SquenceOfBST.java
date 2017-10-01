package com.sran.exercise.job.offer;

import java.util.Arrays;

public class No24SquenceOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(VerifySquenceOfBST(new int[] { 5, 7, 6, 9, 11, 10, 8 }));
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0) {
			return false;
		}

		int rootIndex = sequence.length - 1;
		
		//必须要使用该循环条件，如果使用if中的条件的非作为循环条件，则会出现数组溢出错误。
		int leftIndex = 0;
		while (leftIndex <= rootIndex - 1) {
			if (sequence[leftIndex] > sequence[rootIndex]) {
				break;
			}
			leftIndex++;
		}

		int rightIndex = leftIndex;
		while (rightIndex <= rootIndex - 1) {
			if (sequence[rightIndex] < sequence[rootIndex]) {
				return false;
			}
			rightIndex++;
		}

		// 注意递归检查左右子树是否为二叉搜索树。
		// 如[7, 5, 6, 9, 11, 10, 8]的左子树不为二叉搜索树。
		boolean left = true;
		if (leftIndex > 0) {
			int[] leftTree = Arrays.copyOf(sequence, leftIndex);
			left = VerifySquenceOfBST(leftTree);
		}

		boolean right = true;
		if (leftIndex < rootIndex) {
			int[] rightTree = Arrays.copyOfRange(sequence, leftIndex, rootIndex);
			right = VerifySquenceOfBST(rightTree);
		}

		return left && right;
	}

}

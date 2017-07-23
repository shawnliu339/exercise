package com.sran.exercise.job.offer;

public class No06RecreateTree {

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode head = constructTree(preorder, inorder);
		System.out.println(head);

	}

	private static BinaryTreeNode constructTree(int[] preorder, int[] inorder) {

		if (preorder == null || inorder == null)
			return null;

		BinaryTreeNode root = new BinaryTreeNode();
		root.m_nValue = preorder[0];
		root.m_pLeft = null;
		root.m_pRight = null;

		// mid的长度无法随重建树的过程改变，因此最后无法实现
		// 解决方法，上来先确定左子树和右子树的数量然后继续操作
		int leftNum = 0;
		int rightNum = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.m_nValue) {
				leftNum = i;
				rightNum = inorder.length - i - 1;
				break;
			}
		}

		// left
		if (leftNum > 0) {
			// 构建左子树的前序序列和中序序列
			int[] leftPre = split(preorder, 1, preorder.length - 1);
			int[] leftIn = split(inorder, 0, leftNum);
			root.m_pLeft = constructTree(leftPre, leftIn);
		}

		// right
		if (rightNum > 0) {
			// 注意右子树的切割起点，以及切割长度
			int[] rightPre = split(preorder, leftNum + 1, preorder.length - 1 - leftNum);
			int[] rightIn = split(inorder, leftNum + 1, rightNum);
			root.m_pRight = constructTree(rightPre, rightIn);
		}

		return root;

	}

	private static int[] split(int[] array, int start, int length) {
		int[] splitedArray = new int[length];
		for (int i = 0; i < length; i++) {
			splitedArray[i] = array[start + i];
		}

		return splitedArray;
	}

}

class BinaryTreeNode {
	int m_nValue;
	BinaryTreeNode m_pLeft;
	BinaryTreeNode m_pRight;
}

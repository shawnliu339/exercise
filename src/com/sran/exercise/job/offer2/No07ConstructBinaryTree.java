package com.sran.exercise.job.offer2;

public class No07ConstructBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode node = reConstructBinaryTree(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
				new int[] { 4, 7, 2, 1, 5, 3, 8, 6 });
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}

		int[] range = new int[2];
		//range存取中序遍历当前index和长度
		range[0] = 0;
		range[1] = pre.length - 1;
		return partition(in, 0, in.length - 1, pre, range);
	}

	public static TreeNode partition(int[] inOrder, int start, int end, int[] preOrder, int[] range) {

		int rootValue = preOrder[range[0]];
		TreeNode root = new TreeNode(rootValue);

		if (range[0] > range[1]) {
			return null;
		}

		int rootIndex = 0;
		//中序遍历找根节点的值
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == rootValue) {
				rootIndex = i;
				break;
			}

			if (i == end) {
				System.out.println("input invalid");
			}
		}

		//无左子树
		if (rootIndex != start) {
			range[0]++;
			root.left = partition(inOrder, start, rootIndex - 1, preOrder, range);
		}
		
		//无右子树
		if (rootIndex != end) {
			range[0]++;
			root.right = partition(inOrder, rootIndex + 1, end, preOrder, range);
		}

		return root;
	}

}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode() {

	}

	public TreeNode(int val) {
		this.val = val;

	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

}

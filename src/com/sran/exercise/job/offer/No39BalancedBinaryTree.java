package com.sran.exercise.job.offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class No39BalancedBinaryTree {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("b", 123);
		map.put("a", 234);
		map.put("c", 234);
		Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Integer> entry = entries.next();
			System.out.println("key:" + entry.getKey() + "," + "value:" + entry.getValue());
		}
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

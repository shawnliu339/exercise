package com.sran.exercise.job.offer;

import java.util.Iterator;
import java.util.LinkedList;

public class No50CommonNodeFromTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(12);
		TreeNode node11 = new TreeNode(5);
		root.left = node11;
		TreeNode node12 = new TreeNode(18);
		root.right = node12;
		TreeNode node111 = new TreeNode(2);
		node11.left = node111;
		TreeNode node112 = new TreeNode(9);
		node11.right = node112;
		TreeNode node121 = new TreeNode(15);
		TreeNode node122 = new TreeNode(19);
		node12.left = node121;
		node12.right = node122;
		TreeNode node1212 = new TreeNode(17);
		TreeNode node12121 = new TreeNode(16);
		node121.right = node1212;
		node1212.left = node12121;
		System.out.println(getFirstCommonNode(node12121, node122, root).toString());
		System.out.println(getLowestCommonNode(node12121, node122, root).toString());
	}
	
	public static TreeNode getFirstCommonNode(TreeNode node1, TreeNode node2, TreeNode root) {
		if (node1==null || node2==null || root==null) {
			return null;
		}
		TreeNode commonNode = root;
		if (root.val>node1.val && root.val>node2.val) {
			commonNode = getFirstCommonNode(node1, node2, root.left);
		} else if (root.val<node1.val && root.val<node2.val) {
			commonNode = getFirstCommonNode(node1, node2, root.right);
		} else {
			return commonNode;
		}
		
		return commonNode;
	}
	
	public static TreeNode getLowestCommonNode(TreeNode node1, TreeNode node2, TreeNode root) {
		if (node1==null || node2==null || root==null) {
			return null;
		}
		
		LinkedList<TreeNode> path1 = new LinkedList<TreeNode>();
		getPath(root, node1, path1);
		LinkedList<TreeNode> path2 = new LinkedList<TreeNode>();
		getPath(root, node2, path2);
		return getCommonParent(path1, path2);
	}
	
	public static TreeNode getCommonParent(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
		if (path1==null || path2==null) {
			return null;
		}
		
		Iterator<TreeNode> it1 = path1.iterator();
		Iterator<TreeNode> it2 = path2.iterator();
		TreeNode lastCommonNode = null;
		while (it1.hasNext() && it2.hasNext()) {
			TreeNode node1 = it1.next();
			TreeNode node2 = it2.next();
			
			if (node1.val==node2.val) {
				lastCommonNode = node1;
			}
		}
		
		return lastCommonNode;
	}
	
	public static boolean getPath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
		
		if(root==null || node==null) {
			return false;
		}
		
		if (root.val == node.val) {
			return true;
		}
		path.add(root);
		
		boolean found = false;
		if (!found) {
			found = getPath(root.left, node, path);
		}
		
		if (!found) {
			found = getPath(root.right, node, path);
		}
		
		if (found==false && !path.isEmpty()) {
			path.removeLast();
		}
		
		return found;
	}

}

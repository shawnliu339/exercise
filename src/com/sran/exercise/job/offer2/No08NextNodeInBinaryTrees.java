package com.sran.exercise.job.offer2;

public class No08NextNodeInBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode head = new TreeLinkNode(1);
		createTree(head);
		System.out.println(GetNext(head.left.right).toString());
	}

	public static TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// 有右子树则找右子树的最左叶节点
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}

		// 没有右子树，则向上找当前节点是父节点的左子节点的节点
		TreeLinkNode parent = pNode.next;
		while (parent != null) {
			if (parent.left == pNode) {
				return parent;
			}
			parent = parent.next;
			pNode = pNode.next;
		}

		return null;
	}

	public static void createTree(TreeLinkNode head) {
		TreeLinkNode node = head;
		node.val = 1;
		TreeLinkNode node1 = new TreeLinkNode(2);
		node1.next = node;
		TreeLinkNode node2 = new TreeLinkNode(3);
		node2.next = node;
		node.left = node1;
		node.right = node2;
		TreeLinkNode node11 = new TreeLinkNode(4);
		node11.next = node1;
		TreeLinkNode node12 = new TreeLinkNode(5);
		node12.next = node1;
		node1.left = node11;
		node1.right = node12;
		TreeLinkNode node122 = new TreeLinkNode(6);
		node122.next = node12;
		node12.right = node122;
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeLinkNode [val=" + val + "]";
	}
}
package algorithms.testcase;

import algorithms.models.TreeNode;

public class TreeNodeTestCase {

	/**
	 * @author suzymf
	 * @date 2018年10月31日
	 * @return
	 * @todo TODO
	 */
	public static TreeNode getTestCase() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.right = node2;
		node2.left = node3;
		return root;
	}

	public static TreeNode getTestCase2() {
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node4.left = node5;
		node5.left = node6;
		return root;
	}
	/*
	 * 
	 *    5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	 * */
	
	public static TreeNode getTestCase3() {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		
		node3.left = node5;
		node3.right = node6;
		node6.right=node9;
		return root;
	}
	/*
		      5
		     / \
		    4   8
		   /   / \
		  11  13  4
		 /  \    / \
		7    2  5   1
	 * */
	public static TreeNode getTestCase4() {
		TreeNode root = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		TreeNode node10 = new TreeNode(5);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		
		node3.left = node5;
		node3.right = node6;
		node6.right=node9;
		node6.left = node10;
		return root;
	}
	
	
	
}

package algorithms.tree;

import algorithms.models.TreeNode;

public class P100SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return chkSame(p, q);
	}

	public boolean chkSame(TreeNode p, TreeNode q) {
		// 同时为null,则为true
		if (null == p && null == q) {
			return true;
		}
		// 如果都不为null,且相同,则为true,继续往下检查
		if (!(null != p && null != q && q.val == p.val)) {
			return false;
		}
		boolean result = chkSame(p.left, q.left);
		if (!result) {
			return false;
		}
		result = chkSame(p.right, q.right);
		if (!result) {
			return false;
		}
		return true;
	}

	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.right = node2;
		node2.left = node3;
		
		TreeNode newNode = root.clone();
		/*TreeNode node4 = new TreeNode(4);
		newNode.left = node4;*/
		TreeNode.preOrderPrint(root);
		System.out.println("done");
		TreeNode.preOrderPrint(newNode);
		System.out.println("done");
		
		boolean isSame = isSameTree(root, newNode);
		System.out.println(isSame);
	}

	public static void main(String[] args) {
		new P100SameTree().test();
	}

}

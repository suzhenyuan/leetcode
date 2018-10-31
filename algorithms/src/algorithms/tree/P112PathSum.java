package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

import algorithms.models.TreeNode;
import algorithms.testcase.TreeNodeTestCase;

public class P112PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		List<Integer> paths = new ArrayList<Integer>();
		if (null == root) {
			return sum == 0;
		}
		int nodeSum=0;
		deepInto(root, paths, nodeSum);

		for (Integer v : paths) {
			System.out.println(v);
			if (v == sum) {
				return true;
			}
		}
		return false;
	}

	public void deepInto(TreeNode node, List<Integer> sum, int nodeSum) {
		nodeSum +=node.val;
		if (null == node.left && null == node.right) {
			sum.add(nodeSum);
			return;
		}
		if (null != node.left) {
			deepInto(node.left, sum, nodeSum);
		}
		if (null != node.right) {
			deepInto(node.right, sum, nodeSum);
		}
	}

	private void test() {
		boolean b = hasPathSum(TreeNodeTestCase.getTestCase3(), 22);

		System.out.println(b);

	}

	public static void main(String[] args) {
		new P112PathSum().test();
	}

}

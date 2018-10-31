package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

import algorithms.models.TreeNode;

public class P107BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrderBottom(root, list, 0);

		List<List<Integer>> rl = new ArrayList<List<Integer>>();
		for (int i = list.size() - 1; i >= 0; i--) {
			rl.add(list.get(i));
		}
		return rl;
	}

	public void levelOrderBottom(TreeNode root, List<List<Integer>> list, int level) {
		if (null == root) {
			return;
		}

		if (list.size()==level || list.get(level) == null) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(root.val);
		levelOrderBottom(root.left, list, level + 1);
		levelOrderBottom(root.right, list, level + 1);
	}

	public void test() {
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node3.left = node4;
		node3.right = node5;
		List<List<Integer>> vals = levelOrderBottom(root);
		for (List<Integer> l : vals) {
			for (Integer i : l) {
				System.out.print(i + "->");
			}
			System.out.println("done");
		}
	}

	public static void main(String[] args) {

		new P107BinaryTreeLevelOrderTraversalII().test();
	}

}

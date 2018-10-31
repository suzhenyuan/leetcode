package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

import algorithms.models.TreeNode;
import algorithms.testcase.TreeNodeTestCase;

public class P113PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		search(root, paths, path);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (List<Integer> v : paths) {
			int s = 0;
			for (Integer l : v) {
				s += l;
			}
			if (s == sum) {
				result.add(v);
			}
		}
		return result;
	}

	public void search(TreeNode root, List<List<Integer>> paths, List<Integer> path) {
		path.add(root.val);
		if (null == root.left && null == root.right) {
			List<Integer> ll = new ArrayList<Integer>();
			for (Integer l : path) {
				ll.add(l);
			}
			paths.add(ll);
			return;
		}
		if (null != root.left) {
			search(root.left, paths, path);
			path.remove(path.size() - 1);
		}
		if (null != root.right) {
			search(root.right, paths, path);
			path.remove(path.size() - 1);
		}
	}

	private void test() {
		List<List<Integer>> vals = pathSum(TreeNodeTestCase.getTestCase4(), 8);
		for (List<Integer> l : vals) {
			for (Integer i : l) {
				System.out.print(i + "->");
			}
			System.out.println("done");
		}

	}

	public static void main(String[] args) {
		new P113PathSumII().test();
	}
}

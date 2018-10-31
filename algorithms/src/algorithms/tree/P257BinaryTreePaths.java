package algorithms.tree;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import algorithms.models.TreeNode;
import algorithms.testcase.TreeNodeTestCase;

public class P257BinaryTreePaths {


	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (null == root) {
			return paths;
		}
		String rps = "";

		deepInto(root, paths, rps);

		return paths;
	}

	public void deepInto(TreeNode node, List<String> paths, String rps) {
		rps += "->" + node.val;
		if (null == node.left && null == node.right) {
			paths.add(rps.substring(2));
			return;
		}
		if (null != node.left) {
			deepInto(node.left, paths, rps);
		}
		if (null != node.right) {
			deepInto(node.right, paths, rps);
		}
	}

	public static void main(String[] args) {

		new P257BinaryTreePaths().test();
	}

	private void test() {
		List<String> paths = binaryTreePaths(TreeNodeTestCase.getTestCase2());
		for (String s : paths) {
			System.out.println(s);
		}
	}

}

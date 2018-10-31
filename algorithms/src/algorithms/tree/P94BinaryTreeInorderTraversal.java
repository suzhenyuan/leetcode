package algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithms.models.TreeNode;

public class P94BinaryTreeInorderTraversal {
	/**
	 * @author suzymf
	 * @date 2018年10月31日
	 * @param root
	 * @return
	 * @todo 中序遍历，先左再中后右
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> vals = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (null != cur || !stack.isEmpty()) {
			while(null != cur){
				//所有的左节点压栈
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			//取左子树或者中节点
			vals.add(cur.val);
			//继续从右子树开始枚举
			cur = cur.right;
		}
		return vals;
	}

	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.right = node2;
		node2.left = node3;
		List<Integer> vals = inorderTraversal(root);
		for (Integer i : vals) {
			System.out.print(i + "->");
		}
	}

	public static void main(String[] args) {
		new P94BinaryTreeInorderTraversal().test();
	}
}

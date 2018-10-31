package algorithms.tree;


import algorithms.models.TreeNode;

public class P110BalancedBinaryTree {
	
	public boolean isBalanced(TreeNode root) {
		int h = getHeight(root);
		return h>=0;
	}

	public int getHeight(TreeNode root){
		if(null == root){
			return 0;
		}
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		System.out.println(lh+";"+rh);
		if(lh==-1|| rh==-1 || Math.abs(lh-rh)>1){
			return -1;
		}
		
		return lh>rh?lh+1:rh+1; 
	}
	public void test() {
		TreeNode root = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(7);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		/*node4.left = node5;
		node5.left=node6;*/
		boolean isSame = isBalanced(root);
		System.out.println(isSame);
	}

	public static void main(String[] args) {

		new P110BalancedBinaryTree().test();
	}

}

package algorithms.models;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	
	public TreeNode clone(){
		TreeNode root = new TreeNode(this.val);
		clone(this,root);
		return root;
	}
	public void clone(TreeNode from ,TreeNode to){
		if(from.left!= null){
			to.left = new TreeNode(from.left.val);
			clone(from.left,to.left);
		}
		if(from.right!= null){
			to.right = new TreeNode(from.right.val);
			clone(from.right,to.right);
		}
	}
	
	public static TreeNode createTreeNode(Integer[] nums){
		TreeNode root = new TreeNode(nums[0]);
		createTreeNode(root,nums,0);
		TreeNode.inOrderPrint(root);
		return root;
	}
	public static void createTreeNode(TreeNode root,Integer[] nums, int parentIndex){
		
		int lcIndex = parentIndex*2+1;
		int rcIndex = parentIndex*2+2;
		if(lcIndex< nums.length && null != nums[lcIndex]){
			root.left = new TreeNode(nums[lcIndex]);
			createTreeNode(root.left,nums,lcIndex);
		}
		if(rcIndex<nums.length && null != nums[rcIndex]){
			root.right = new TreeNode(nums[rcIndex]);
			createTreeNode(root.right,nums,rcIndex);
		}
	}
	
	public static void inOrderPrint(TreeNode root){
		inOrderPrint(root,0);
		System.out.println("--------中序遍历done--------------");
	}
	public static void inOrderPrint(TreeNode root, int level){
		if(null ==root){
			return;
		}
		inOrderPrint(root.left,level+1);
		for(int i=0; i<level;i++){
			System.out.print("\t");
		}
		System.out.println(root.val);
		inOrderPrint(root.right,level+1);
	}
	
	
	
	public static void preOrderPrint(TreeNode root){
		preOrderPrint(root,0);
		System.out.println("--------先序遍历done--------------");
	}
	public static void preOrderPrint(TreeNode root,int level){
		if(null ==root){
			return;
		}
		for(int i=0; i<level;i++){
			System.out.print("\t");
		}
		System.out.println(root.val);
		preOrderPrint(root.left,level+1);		
		preOrderPrint(root.right,level+1);
	}
	public static void postOrderPrint(TreeNode root){
		postOrderPrint(root,0);
		System.out.println("--------后序遍历done--------------");
	}
	
	public static void postOrderPrint(TreeNode root,int level){
		if(null ==root){
			return;
		}
		postOrderPrint(root.left,level+1);		
		postOrderPrint(root.right,level+1);
		for(int i=0; i<level;i++){
			System.out.print("\t");
		}
		System.out.println(root.val);
	}
}

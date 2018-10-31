package algorithms.tree;

import java.util.ArrayList;
import java.util.List;


import algorithms.models.TreeNode;

public class P437PathSumIII {
	public int pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		search(root, paths, path,sum);
		
		for (List<Integer> l : paths) {
			for (Integer i : l) {
				System.out.print(i + "->");
			}
			System.out.println("done");
		}
		return paths.size();
	}

	public void search(TreeNode root, List<List<Integer>> paths, List<Integer> path, int sum) {
		path.add(root.val);
		if (null == root.left && null == root.right) {
			
			for(int i=0; i<path.size(); i++){
				Integer s = path.get(i);
				int j=i+1;
				if(s ==sum){
					j=i;
				}else{
					for(j=i+1; j<path.size(); j++){
						s+=path.get(j);
						if(sum == s){
							break;
						}
					}
				}
				if(j<path.size()){
					List<Integer> ll = new ArrayList<Integer>();
					for(int k=i; k<=j; k++){
						ll.add(path.get(k));
					}
					paths.add(ll);
				}
			}
			return;
		}
		if (null != root.left) {
			search(root.left, paths, path,sum);
			path.remove(path.size() - 1);
		}
		if (null != root.right) {
			search(root.right, paths, path,sum);
			path.remove(path.size() - 1);
		}
	}

	private void test() {
		int size= pathSum(TreeNode.createTreeNode(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 8);
		System.out.println(size);

	}

	public static void main(String[] args) {
		new P437PathSumIII().test();
	}
}

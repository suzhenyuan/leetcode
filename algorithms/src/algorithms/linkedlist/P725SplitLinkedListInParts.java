package algorithms.linkedlist;


public class P725SplitLinkedListInParts {


	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] lns = new ListNode[k];
		ListNode[] tails = new ListNode[k];
		int len = 0;
		ListNode cur = root;
		while (null != cur) {
			cur = cur.next;
			len++;
		}
		// 每组数量
		int numPerGroup = len / k;
		// 前mod组是多一个元素的
		int mod = len % k;
		cur = root;
		int curLen = 0;
		cur =root;
		for(int i=0; i< k; i++){
			//当前分组数量
			curLen = numPerGroup+(i<mod?1:0);
			for(int j=0; j<curLen; j++){
				if (lns[i] == null) {
					lns[i] = cur;
					tails[i] = lns[i];
				} else {
					tails[i].next = cur;
					tails[i] = tails[i].next;
				}
				cur = cur.next;
				tails[i].next = null;
				if(null == cur){
					return lns;
				}
			}
		}
		return lns;
	}

	public void test() {
		ListNode[] lns = splitListToParts(ListNode.createLists(10), 6);
		for (int i = 0; i < lns.length; i++) {
			ListNode.print(lns[i]);
		}
	}

	public static void main(String[] args) {
		new P725SplitLinkedListInParts().test();
	}

}

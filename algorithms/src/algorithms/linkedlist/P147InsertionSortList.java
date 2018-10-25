package algorithms.linkedlist;


public class P147InsertionSortList {
	public ListNode insertionSortList(ListNode head) {

		if(null == head || null == head.next){
			return head;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;
		//第二列
		ListNode secHead = head.next;
		head.next=null;
		
		while(null != secHead){
			ListNode sp = pre;
			while(null != sp.next){
				//sp是当前有效节点的前一个
				if(secHead.val< sp.next.val){
					break;
				}
				sp = sp.next;
			}
			if(null != sp.next){
				//找到了需要插入sp前面的节点
				ListNode t = sp.next;
				sp.next = secHead;
				secHead = secHead.next;
				sp.next.next = t;
				sp = sp.next;
			}else{
				//否则拼接到最后去
				sp.next = secHead;
				secHead = secHead.next;
				sp.next.next = null;
				sp = sp.next;
			}
		}
		return pre.next;
	}

	public static void testRotate(int num) {
		System.out.println("------------------");
		int[] nums = {0,8,0,4,2,3};
		ListNode head = ListNode.createLists(nums);
		ListNode.print(head);
		ListNode node = new P147InsertionSortList().insertionSortList(head);
		ListNode.print(node);
	}

	public static void main(String[] args) {
		testRotate(8);
	}
}

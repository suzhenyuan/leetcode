package algorithms.linkedlist;

public class P25ReverseNodesInKGroup {
	
	
	/**
	 * @author suzymf
	 * @date 2018年10月30日
	 * @param head
	 * @param k
	 * @return
	 * @todo 分段反转
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode slow = pre;
		ListNode fast = slow;
		while(true){
			int t = k;
			//fast往前移动t个
			while (t>0 && null != fast) {
				fast = fast.next;
				t--;
			}
			if(t>0 || null == fast){
				break;
			}
			//fast的next作为后一个链表的起点
			ListNode next = fast.next;
			fast.next = null;
			slow.next = reverse(slow.next);
			//slow move to end
			while(null != slow.next){
				slow = slow.next;
			}
			slow.next = next;
			fast = slow;
		}
		return pre.next;
	}
	private ListNode reverse(ListNode head) {
		ListNode pre = new ListNode(-1);
		ListNode slow = head;
		while(null != slow){
			ListNode next = slow.next;
			slow.next = pre.next;
			pre.next = slow;
			slow = next;
		}
		return pre.next;
	}
	public void test() {

		ListNode head = ListNode.createLists(5);
		ListNode ln = reverseKGroup(head,2);
		ListNode.print("反转结果",ln);

	}
	public static void main(String[] args) {
		new P25ReverseNodesInKGroup().test();

	}

}

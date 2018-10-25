package algorithms.linkedlist;


public class P143ReorderList {
	/**
	 * @author suzymf
	 * @date 2018年10月25日
	 * @param head
	 * @todo 首尾交叉连接:找到中点,分割,把后一个链表反转,然后再合并
	 */
	public static void reorderList(ListNode head) {

		if(null == head || null == head.next){
			return ;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;

		ListNode slow = pre, fast = slow.next;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// slow.next is middle node
		ListNode nextHead = reverse(slow.next);
		ListNode.print("finish",nextHead);
		slow.next = null;
		ListNode s1 = pre, s2 = nextHead;
		while(s1.next != null && s2 != null){
			ListNode t = s1.next.next;
			s1.next.next = s2;
			s2 = s2.next;
			s1.next.next.next = t;
			//move forward by two steps
			s1 = s1.next.next;
			
		}
		if(s2 !=null){
			s1.next = s2;
		}
		head = pre.next;
		ListNode.print("finish",head);
	}

	public static ListNode reverse(ListNode head) {
		ListNode nh = null;
		while (head != null) {
			ListNode t = nh;
			nh = head;
			head = head.next;
			nh.next = t;
		}
		return nh;
	}

	public static void main(String[] args) {
		reorderList(ListNode.createLists(7));
	}
}

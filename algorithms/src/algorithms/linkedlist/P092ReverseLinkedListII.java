package algorithms.linkedlist;

public class P092ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode preStart = getListNodeByIndex(pre, m);

		ListNode head2 = null;
		ListNode tail2 = null;
		ListNode cur = preStart.next;
		//cur是从第m个节点开始,到第n个节点,做反转
		for (int i=m;i<=n;i++) {
			ListNode node = cur.next;
			cur.next = head2;
			if (null == head2) {
				tail2 = cur;
			}
			head2 = cur;
			preStart.next = node;
			cur = node;
		}
		//新链表首尾相连
		tail2.next = preStart.next;
		preStart.next = head2;
		return pre.next;


	}

	/**
	 * @author suzymf
	 * @date 2018年10月25日
	 * @param head
	 * @param index
	 * @return
	 * @todo 找出起始节点的前一个节点
	 */
	public static ListNode getListNodeByIndex(ListNode head, int index) {
		ListNode pre = head;
		for (int i = 1; i < index && pre != null; i++) {
			pre = pre.next;
		}
		return pre;
	}

	public static void testRotate(int num) {
		System.out.println("------------------");
		ListNode head = ListNode.createLists(num);
		ListNode.print(head);
		ListNode n = reverseBetween(head,2,4);
		ListNode.print(n);
	}
	public static void main(String[] args){
		testRotate(5);
	}
}

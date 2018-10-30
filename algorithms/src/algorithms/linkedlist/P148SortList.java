package algorithms.linkedlist;

public class P148SortList {

	/**
	 * @author suzymf
	 * @date 2018年10月29日
	 * @param head
	 * @return
	 * @todo 归并排序
	 */
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	/**
	 * @author suzymf
	 * @date 2018年10月29日
	 * @param preStart 分段的前一个节点
	 * @param end 最后一个节点
	 * @return
	 * @todo
	 */
	public ListNode mergeSort(ListNode head) {
		// 判断:preStart与end只有两个元素,就把他们交换,然后返回
		if(null == head || head.next == null){
			return head;
		}else if(head.next.next == null){
			//两个节点
			ListNode next = head.next;
			if(head.val < next.val){
				return head;
			}
			next.next = head;
			head.next = null;
			return next;			
		}else{
			ListNode pre = new ListNode(0);
			pre.next = head;
			ListNode slow = pre.next;
			ListNode fast = slow.next;
			while (null != fast && null != fast.next) {
				slow = slow.next;
				fast = fast.next.next;
			}
			//slow 作为前一个链表的最后一个节点，slow.next作为后一个链表的起始节点
			ListNode next =slow.next;
			slow.next = null;
			ListNode.print("前半段",pre.next);
			ListNode.print("后半段",next);
			head=mergeSort(pre.next);
			next = mergeSort(next);
			return merge(head, next);
		}
	}

	/**
	 * @author suzymf
	 * @date 2018年10月30日
	 * @param la
	 * @param lb
	 * @return
	 * @todo 链表归并
	 */
	public ListNode merge(ListNode la, ListNode lb) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while(null != la && null != lb){
			if(la.val<lb.val){
				tail.next = la;
				la = la.next;
			}else{
				tail.next = lb;
				lb = lb.next;
			}
			tail = tail.next;
		}
		if(null == la){
			tail.next = lb;
		} if(null == lb){
			tail.next = la;
		}
		return head.next;
	}

	public void test() {

		ListNode head = ListNode.createLists(10, true);
		ListNode ln = sortList(head);
		ListNode.print("排序结果",ln);

	}

	public static void main(String[] args) {
		new P148SortList().test();
	}
}

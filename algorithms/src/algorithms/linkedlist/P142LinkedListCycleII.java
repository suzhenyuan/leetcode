package algorithms.linkedlist;

public class P142LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {

		ListNode slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				//快慢指针在同一个位置,再设置一个指针，从起点开始，直到他们相遇，相遇的节点即为相交的节点
				ListNode start = head;
				while (start != slow) {
					start = start.next;
					slow = slow.next;
				}
				return start;
			}
		}
		return null;
	}

	public void test() {

		ListNode head = ListNode.createLists(10);
		ListNode tail = ListNode.getTail(head);
		int c = 4;
		ListNode mid = head;
		while(c>0){
			c--;
			mid = mid.next;
		}
		tail.next = mid;
		ListNode.print(head);
		ListNode ln = detectCycle(head);
		ListNode.print(ln);

	}

	public static void main(String[] args) {
		new P142LinkedListCycleII().test();
	}
}

package algorithms.linkedlist;

public class P328OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		if (null == head || head.next == null) {
			return head;
		}

		ListNode odd = head, even = head.next, evenHead = even;
		while (odd != null && null != even && even.next != null) {
			odd.next = even.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	public static void testRotate(int num) {
		System.out.println("------------------");
		ListNode head = ListNode.createLists(num);
		ListNode.print(head);
		ListNode n = oddEvenList(head);
		ListNode.print(n);
	}

	public static void main(String[] args) {
		testRotate(5);
	}
}

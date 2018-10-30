package algorithms.linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode createLists(int[] nums) {
		ListNode head = new ListNode(0);
		ListNode next = head;
		for (int i = 0; i < nums.length; i++) {
			next.next = new ListNode(nums[i]);
			next = next.next;
		}
		return head.next;
	}

	public static ListNode createLists(int num) {
		return createLists(num,false);
	}
	public static ListNode createLists(int num,boolean random) {
		ListNode head = new ListNode(0);
		ListNode next = head;
		for (int i = 1; i <= num; i++) {
			int val = random?(int)(Math.random()*100):i;
			next.next = new ListNode(val);
			next = next.next;
		}
		ListNode.print("生成的链表",head.next);
		return head.next;
	}
	public static ListNode getTail(ListNode head) {
		ListNode tail = head;
		while (null != tail && null != tail.next) {
			tail = tail.next;
		}
		return tail;
	}

	public static void print(String text, ListNode head) {
		System.out.print(text + ": ");
		print(head);
	}

	public static void print(ListNode head) {
		int total = 20;
		ListNode next = head;
		while (next != null) {
			System.out.print(next.val + "->");
			next = next.next;
			total--;
			if (total <= 0) {
				System.out.println("链表不为空");
				break;
			}
		}
		System.out.println("null");
	}
}

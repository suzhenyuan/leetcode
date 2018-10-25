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
		ListNode head = new ListNode(0);
		ListNode next = head;
		for (int i = 1; i <= num; i++) {
			next.next = new ListNode(i);
			next = next.next;
		}
		ListNode.print(head.next);
		return head.next;
	}
	public static void print(String text,ListNode head) {
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

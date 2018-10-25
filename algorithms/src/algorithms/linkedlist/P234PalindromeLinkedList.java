package algorithms.linkedlist;

public class P234PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		if (null == head || null == head.next) {
			return true;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;

		ListNode slow = pre;
		ListNode fast = pre.next;

		while (null != fast) {
			slow = slow.next;
			fast = fast.next != null ? fast.next.next : null;
		}
		System.out.println("slow:"+slow.val);
		ListNode head2 = reverse(slow.next);
		slow.next = null;
		

		System.out.println("第1个列表");
		ListNode.print(head);
		System.out.println("第二个列表");
		ListNode.print(head2);
		ListNode n1 = head;
		ListNode n2 = head2;
		boolean found = false;
		while (n1 != null && n2 != null) {
			if (n1.val != n2.val) {
				found = true;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return !found;

	}

	public static ListNode reverse(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;

		ListNode newhead = null;
		ListNode next = pre.next;
		while (next != null) {
			pre.next = next.next;
			next.next = newhead;
			newhead = next;
			next = pre.next;
		}
		return newhead;
	}
	
	public static void testRotate(int num){
		System.out.println("------------------");
		int[] nums={};
		ListNode head = ListNode.createLists(nums);
		ListNode.print(head);
		boolean result = isPalindrome(head);
		System.out.println(result);
	}

	public static void main(String[] args) {
		testRotate(8);
	}
}

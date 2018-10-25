package algorithms.linkedlist;

public class P82RemoveDuplicatesFromSortedListII {


	/**
	 * @author suzymf
	 * @date 2018年10月24日
	 * @param head
	 * @return
	 * @todo Given a sorted linked list, delete all duplicates such that each element appear only once. Example 1: Input: 1->1->2 Output: 1->2
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		if (null == head) {
			return head;
		}
		ListNode slow = pre.next;
		ListNode fast = slow.next;

		while (fast != null) {
			if (slow.val == fast.val) {
				slow.next = fast.next;
				if (null != slow) {
					fast = slow.next;
				}
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return pre.next;
	}

	/**
	 * @author suzymf
	 * @date 2018年10月24日
	 * @param head
	 * @return
	 * @todo Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 * 
	 *       Example 1: Input: 1->2->3->3->4->4->5 Output: 1->2->5
	 */
	public static ListNode deleteDuplicatesII(ListNode head) {
		ListNode pre = new ListNode(-1);
		pre.next = head;
		if (null == head) {
			return head;
		}
		ListNode preSlow = pre;
		ListNode slow = preSlow.next;
		ListNode fast = slow.next;

		while (fast != null) {
			if (slow.val == fast.val) {
				fast = fast.next;
			} else {
				if (slow.next == fast) {
					// 意味着slow节点与紧挨着的fast节点数值不同
					preSlow = slow;
					slow = fast;
					fast = fast.next;
				} else {
					preSlow.next = fast;
					slow = fast;
					fast = fast.next;
				}
			}
		}

		if (slow.next != null) {
			preSlow.next = null;
		} else {
			preSlow.next = slow;
		}
		return pre.next;
	}

	public static void testRotate(int num, int k) {
		System.out.println("------------------");
		int[] nums = {1, 2, 2, 2, 3, 3, 4, 4, 5, 5};
		ListNode head = ListNode.createLists(nums);
		ListNode.print(head);
		ListNode n = deleteDuplicates(head);
		ListNode.print(n);
	}

	public static void main(String[] args) {
		testRotate(5, 2);
	}
}

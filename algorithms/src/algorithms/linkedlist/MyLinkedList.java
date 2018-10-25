package algorithms.linkedlist;

public class MyLinkedList {
	public class ListNode {
		public int val;
		public ListNode pre;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}


	private ListNode head;
	private ListNode tail;

	private int size = 0;

	/** Initialize your data structure here. */
	public MyLinkedList() {}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		if (null == head) {
			return -1;
		}
		ListNode ln = head;
		int val = -1;
		for (int i = 0; i < index && null != ln; i++) {
			ln = ln.next;
		}
		if (null != ln) {
			val = ln.val;
		}
		return val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		if (null == head) {
			head = new ListNode(val);
			tail = head;
		} else {
			ListNode n = new ListNode(val);
			head.pre = n;
			n.next = head;
			head = n;
		}
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (null == head) {
			head = new ListNode(val);
			tail = head;
		} else {
			ListNode n = new ListNode(val);
			tail.next = n;
			n.pre = tail;
			tail = n;
		}
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater
	 * than the length, the node will not be inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > size) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
		} else if (index == size) {
			addAtTail(val);
		} else {
			ListNode n = new ListNode(val);
			ListNode cur = head;
			int i = 1;
			for (; i < index && null != cur; i++) {
				cur = cur.next;
			}
			// insert after cur
			cur.next.pre = n;
			n.next = cur.next;
			cur.next = n;
			n.pre = cur;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		ListNode cur = head;
		int i = 0;
		for (; i < index && null != cur; i++) {
			cur = cur.next;
		}
		if (null != cur) {
			// remove cur
			if (null != cur.pre) {
				cur.pre.next = cur.next;
			}
			if (null != cur.next) {
				cur.next.pre = cur.pre;
			}
			size--;
		}
	}

	public void print() {
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

	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		/*
		 * linkedList.print(); linkedList.addAtTail(3); linkedList.print();
		 */
		linkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
		linkedList.print();
		int val = linkedList.get(1); // returns 2
		System.out.println(val);
		val = linkedList.get(0); // returns 2
		System.out.println(val);
		val = linkedList.get(2); // returns 2
		System.out.println(val);
		/*
		 * linkedList.deleteAtIndex(1); // now the linked list is 1->3 linkedList.print(); val = linkedList.get(1); // returns 3 System.out.println(val);
		 */
	}
}

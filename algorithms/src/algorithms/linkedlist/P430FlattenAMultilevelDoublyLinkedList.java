package algorithms.linkedlist;

public class P430FlattenAMultilevelDoublyLinkedList {

	Node ln = new Node();
	Node tail = ln;
	public Node flatten(Node head) {
		
		if (null != head) {
			ln.next = new Node(head.val, null, null, null);
			tail = ln.next;		
			flattenNode(head.child);
			flattenNode(head.next);
		}
		
		return ln.next;
	}

	private void flattenNode(Node node) {
		if (null != node) {
			System.out.print(tail.val + "->");
			tail.next = new Node(node.val, null, null, null);
			tail.next.prev = tail;
			tail = tail.next;
			flattenNode(node.child);
			flattenNode(node.next);
		}
	}

	private void test() {

		Node head = new Node(1, null, null, null);
		Node node2 = new Node(2, null, null, null);
		head.next = node2;
		node2.prev = head;
		Node node3 = new Node(3, null, null, null);
		node2.next = node3;
		node3.prev = node2;

		Node node4 = new Node(4, null, null, null);
		node3.next = node4;
		node4.prev = node3;
		Node node5 = new Node(5, null, null, null);
		node4.next = node5;
		node5.prev = node4;
		Node node6 = new Node(6, null, null, null);
		node5.next = node6;
		node6.prev = node5;

		Node node7 = new Node(7, null, null, null);
		node3.child = node7;
		Node node8 = new Node(8, null, null, null);
		node7.next = node8;
		node8.prev = node7;

		Node node9 = new Node(9, null, null, null);
		node8.next = node9;
		node9.prev = node8;

		Node node10 = new Node(10, null, null, null);
		node9.next = node10;
		node10.prev = node9;

		Node node11 = new Node(11, null, null, null);
		node8.child = node11;
		Node node12 = new Node(12, null, null, null);
		node11.next = node12;
		node12.prev = node11;

		Node node = flatten(head);
		System.out.println("done");
		Node l = node.next;
		while (null != l) {
			System.out.print(l.val + "->");
			l = l.next;
		}
	}

	public static void main(String[] args) {
		new P430FlattenAMultilevelDoublyLinkedList().test();
	}


}

package algorithms.linkedlist;

/**
 * @author suzymf
 * @date 2018年10月24日
 * @todo 
 * if len>k,则(len-k)所在节点即为新链表的头节点
 * if k<len,则((k/len+1)*len%k)所在节点即为新链表的头节点
 */
public class P61RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		
		ListNode pre = new ListNode(0);
		pre.next = head;

		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		System.out.println("len:"+len+",k:"+k);
		if (len == 0 || len==1 || k== 0 || len ==k ) {
			return pre.next;
		}
		if (len<k && k%len==0) {
			return pre.next;
		}
		//分组：
		int index = len > k ? len - k : (k/len+1)*len -k;
		System.out.println("index:"+index);
		//index 所在的节点作为新节点的head

		ListNode slow = pre;
		ListNode fast = slow.next;
		for (int i = 0; i < index; i++) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = null;
		pre.next = fast;
		while (fast.next != null) {
			fast = fast.next;
		}
		fast.next = head;

		return pre.next;

	}
	
	public static void testRotate(int num, int k){
		System.out.println("------------------");
		ListNode head = ListNode.createLists(num);
		ListNode.print(head);
		ListNode n= rotateRight(head,k);
		ListNode.print(n);
	}

	public static void main(String[] args) {
		testRotate(0,0);
		testRotate(1,99);
		testRotate(5,2);
		testRotate(4,2);
		testRotate(2,4);
		testRotate(2,5);
		testRotate(2,2);
	}
}

package algorithms.linkedlist;


public class P445AddTwoNumbersII {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		
		ListNode pre = new ListNode(0);
		pre.next = l1;		
		ListNode s1=pre,s2=l2;
		int ten =0;
		while(s1.next != null && s2 != null){
			int val = s1.next.val+s2.val+ten;
			s1.next.val = val%10;
			ten = val/10;
			s1 = s1.next;
			s2 = s2.next;
		}
		ListNode.print("s1",pre.next);
		if(s2 !=null){
			s1.next = s2;
		}
		while(s1.next !=null){
			int val = s1.next.val+ten;
			s1.next.val = val%10;
			ten = val/10;
			s1 = s1.next;
		}
		if(ten>0){
			s1.next = new ListNode(ten);
		}
		
		return reverse(pre.next);
	}
	public static ListNode reverse(ListNode ln) {
		ListNode nh=null;
		while(ln != null){
			ListNode tmp = ln.next;
			ln.next = nh;
			nh =ln;
			ln = tmp;
		}
		return nh;
	}

	public static void testRotate(int num, int k) {
		System.out.println("------------------");
		int[] n1={7,2,4,3};
		int[] n2 ={5,6,4};
		ListNode n = addTwoNumbers( ListNode.createLists(n1),  ListNode.createLists(n2));
		ListNode.print(n);
	}

	public static void main(String[] args) {
		testRotate(5,4);
	}
}

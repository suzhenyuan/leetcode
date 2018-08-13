package algorithms;

public class P002_AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

		int[] lv1=new int[]{3,7};
		int[] lv2=new int[]{9,2};
		P002_AddTwoNumbers p = new P002_AddTwoNumbers();
		ListNode l1 = p.init(lv1);
		ListNode l2 = p.init(lv2);
		p.printListNode(l1);
		p.printListNode(l2);
		
		p.printListNode(p.addTwoNumbers(l1, l2));
	}
	public ListNode init(int[] values){
		ListNode r= new ListNode(values[0]);
		ListNode n = r;
		for(int i=1;i<values.length; i++){
			n.next = new ListNode(values[i]);
			n = n.next;
		}
		return r;
	}
	public void printListNode(ListNode ln) {
		System.out.print(ln.val);
		ListNode n = ln.next;
		while (n!=null) {
			System.out.print("->"+n.val);	
			n = n.next;
		}
		System.out.println("");
	}

	/**
	 * @author suzymf
	 * @date 2018年8月13日
	 * @param l1
	 * @param l2
	 * @return
	 * @todo 看了提示信息，才想起，为什么不返回root.next呢？就不用去判断是否第一个节点了。
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode result = root;
		ListNode lr1 = l1;
		ListNode lr2 = l2;
		int ten=0;
		while(null != lr1 && null != lr2){
			int v = (lr1.val+lr2.val+ten)%10;
			ten = (lr1.val+lr2.val+ten)/10;
			lr1 = lr1.next;
			lr2 = lr2.next;
			result.next = new ListNode(v);
			result = result.next;
			
		}
		ListNode tail = null;
		if(null == lr1){
			tail = lr2;
		}
		else if(null == lr2){
			tail = lr1;
		}
		
		while(tail !=null){
			int v = (tail.val+ten)%10;
			ten = (tail.val+ten)/10;
			result.next = new ListNode(v);
			result = result.next;
			tail = tail.next;
		}
		//if the last sum > 10
		if(ten>0){
			result.next = new ListNode(ten);
		}
		
		return root.next;
	}

}

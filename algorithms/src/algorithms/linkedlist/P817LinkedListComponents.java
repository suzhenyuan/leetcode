package algorithms.linkedlist;

public class P817LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
		int total = 0;
		ListNode cur = head;
		boolean continueSearchMode = false;
		while (null != cur) {
			if (found(cur.val, G)) {
				if(!continueSearchMode){
					total ++;
					continueSearchMode = true;
					System.out.println("start:"+cur.val);
				}
			}else{
				continueSearchMode =false;
				System.out.println("end:"+cur.val);
			}
			cur = cur.next;
		}
		return total;
	}

	public boolean found(int val, int[] G) {
		int i = 0;
		for (i = 0; i < G.length; i++) {
			if (val == G[i]) {
				return true;
			}
		}
		return false;
	}

	public void test() {

		ListNode head = ListNode.createLists(4);
		int[] g = {1,2,4};
		int total = numComponents(head, g);
		System.out.println(total);

	}

	public static void main(String[] args) {
		new P817LinkedListComponents().test();
	}
}

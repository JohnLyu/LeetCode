package removeNthNodeFromEndOfList;

public class SolutionGuard {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) return null;
    	ListNode preHead = new ListNode(-1);
    	preHead.next = head;
    	ListNode cur = preHead;
    	for (int i = 0 ; i <= n; i++) {
    		cur = cur.next;
    	}
    	ListNode pre = preHead;
    	while (cur != null) {
    		cur = cur.next;
    		pre = pre.next;
    	}
    	pre.next = pre.next.next;
    	return preHead.next;
    }
}

package removeNthNodeFromEndOfList;

public class Solution {
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
    	ListNode cur = head;
    	for (int i = 0 ; i < n; i++) {
    		cur = cur.next;
    	}
    	if (cur == null) return head.next;
    	else cur = cur.next;
    	ListNode pre = head;
    	while (cur != null) {
    		cur = cur.next;
    		pre = pre.next;
    	}
    	pre.next = pre.next.next;
    	return head;
    }
}

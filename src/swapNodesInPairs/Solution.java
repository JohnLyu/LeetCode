package swapNodesInPairs;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode swapPairs(ListNode head) {
    	ListNode preHead = new ListNode(-1);
    	preHead.next = head;
    	ListNode pre = preHead;
    	while (pre.next != null && pre.next.next != null) {
    		ListNode first = pre.next;
    		pre.next = pre.next.next;
    		first.next = pre.next.next;
    		pre.next.next = first;
    		pre = first;
    	}
    	return preHead.next;
    }
}

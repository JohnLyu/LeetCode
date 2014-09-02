package reverseNodesInKGroup;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k < 2) return head;
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        preHead.next = head;
        ListNode[] section = new ListNode[k];
        while (true) {
        	section[0] = pre.next;
        	if (section[0] == null) return preHead.next;
        	for (int i = 1; i < k; i++) {
        		if (section[i - 1].next == null) return preHead.next;
        		section[i] = section[i - 1].next;
        	}
        	pre.next = section[k - 1];
        	section[0].next = section[k - 1].next;
        	for (int i = 1; i < k; i++) {
        		section[i].next = section[i - 1];
        	}
        	pre = section[0];
        }
    }
}

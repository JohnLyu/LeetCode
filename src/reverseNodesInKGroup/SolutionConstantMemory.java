package reverseNodesInKGroup;

public class SolutionConstantMemory {
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
        
        
        return null;
    }
}

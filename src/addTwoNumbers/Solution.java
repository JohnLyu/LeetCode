package addTwoNumbers;

public class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null) return l2;
    	if (l2 == null) return l1;
    	
    	int carry = 0;
    	ListNode res = new ListNode(0);
    	ListNode cur = res;
    	while (l1 != null || l2 != null) {
    		int val = 0;
    		if (l1 == null) {
    			val = l2.val + carry;
    			l2 = l2.next;
    		} else if (l2 == null) {
    			val = l1.val + carry;
    			l1 = l1.next;
    		} else {
    			val = l1.val + l2.val + carry;
    			l1 = l1.next;
    			l2 = l2.next;
    		}
			if (val > 9) {
				val -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			cur.next = new ListNode(val);
			cur = cur.next;
    	}
    	if (carry == 1) {
    		cur.next = new ListNode(1);
    	}
        return res.next;
    }
    
//    public static void main(String[] args) {
//    	ListNode l1 = new ListNode(1);
//    	ListNode l2 = new ListNode(9);
//    	l2.next = new ListNode(9);
//    	ListNode l3 = addTwoNumbers(l1, l2);
//    	while (l3 != null) {
//    		System.out.print(l3.val + " ");
//    		l3 = l3.next;
//    	}
//    }
}
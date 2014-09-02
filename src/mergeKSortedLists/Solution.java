package mergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void heapify(ListNode[] heap, int size, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left < size) {
			int min = index;
			if (heap[index].val > heap[left].val) min = left;
			if (right < size && heap[min].val > heap[right].val) min = right;
			if (min != index) {
				ListNode temp = heap[index];
				heap[index] = heap[min];
				heap[min] = temp;
				heapify(heap, size, min);
			}
		}
	}

	public void buildHeap(ListNode[] heap, int size) {
		for (int i = size / 2 - 1; i > -1; i--) {
			heapify(heap, size, i);
		}
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode preHead = new ListNode(-1);
		int len = lists.size();
		if (len == 0)
			return preHead.next;
		ListNode[] heap = new ListNode[len];
		int size = 0;
		for (int i = 0; i < len; i++) {
			if (lists.get(i) != null) {
				heap[size++] = lists.get(i);
			}
		}
		buildHeap(heap, size);
		ListNode cur = preHead;
		while (size > 0) {
			cur.next = heap[0];
			cur = cur.next;
			if (cur.next != null) {
				heap[0] = heap[0].next;
			} else {
				if (size == 1) break;
				heap[0] = heap[--size];
			}
			heapify(heap, size, 0);
		}
		return preHead.next;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(new ListNode(1));
		lists.add(new ListNode(0));
		s.mergeKLists(lists);
	}
}

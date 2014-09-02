package removeDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len < 2) return len;
        int left = 1, right = 1;
    	while (right < len) {
    		if (A[right] != A[right - 1]) {
    			A[left++] = A[right];
    		}
    		right++;
    	}
    	return left;
    }
}

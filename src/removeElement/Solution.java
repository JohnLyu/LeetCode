package removeElement;

public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int left = 0;
        for (int i = 0; i < len; i++) {
        	if (A[i] != elem) {
        		A[left++] = A[i];
        	}
        }
    	return left;
    }
}

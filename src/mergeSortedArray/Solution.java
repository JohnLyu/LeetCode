package mergeSortedArray;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int ap = m - 1;
        int bp = n - 1;
        int cp = m + n - 1;
        
        while (ap > -1 && bp > -1) {
        	A[cp--] = A[ap] > B[bp] ? A[ap--] : B[bp--];
        }
    	while (bp > -1) {
    		A[cp--] = B[bp--];
    	}
    }
}

package medianOfTwoSortedArrays;

public class Solution {
	public int findKthNumber(int[] A, int al, int ar, int[] B, int bl, int br, int k) {
		if (ar < al) {
			return B[bl + k - 1];
		}
		if (br < bl) {
			return A[al + k - 1];
		}
		int am = (al + ar) / 2;
		int bm = (bl + br) / 2;
		int num = am - al + bm - bl + 2;
		
		if (A[am] == B[bm]) {
			if (num == k || num - 1 == k) {
				return A[am];
			} else if (num > k) {
				return findKthNumber(A, al, am - 1, B, bl, bm - 1, k);
			} else {
				return findKthNumber(A, am + 1, ar, B, bm + 1, br, k - num);
			}
		} else if (A[am] < B[bm]) {
			if (num > k) {
				return findKthNumber(A, al, ar, B, bl, bm - 1, k);
			} else {
				return findKthNumber(A, am + 1, ar, B, bl, br, k - (am - al + 1));
			}
		} else {
			if (num > k) {
				return findKthNumber(A, al, am - 1, B, bl, br, k);
			} else {
				return findKthNumber(A, al, ar, B, bm + 1, br, k - (bm - bl + 1));
			}
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int num = A.length + B.length;
		if ((num) % 2 == 1) return findKthNumber(A, 0, A.length - 1, B, 0, B.length - 1, num / 2 + 1);
		else {
			double m1 = findKthNumber(A, 0, A.length - 1, B, 0, B.length - 1, num / 2);
			double m2 = findKthNumber(A, 0, A.length - 1, B, 0, B.length - 1, num / 2 + 1);
			return (m1 + m2) / 2;
		}
	}
}

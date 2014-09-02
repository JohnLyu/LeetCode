package reverseInteger;

public class Solution {
    public int reverse(int x) {
    	if (x == 0) return x;
    	boolean neg = false;
        if (x < 0) {
        	neg = true;
        	x = -x;
        }
        int res = 0;
        while (x > 0) {
        	res = res * 10 + x % 10;
        	x /= 10;
        }
        if (neg) res = -res;
    	return res;
    }
}

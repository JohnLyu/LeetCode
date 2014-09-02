package divideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        long res = 0;
        long divisor2 = (long)divisor;
        long dividend2 = (long)dividend;
        boolean neg = dividend2 < 0 && divisor2 > 0 || dividend2 > 0 && divisor2 < 0;
        if (dividend < 0) dividend2 = -dividend2;
        if (divisor < 0) divisor2 = -divisor2;
        long divisor3 = divisor2;
        long add = 1;
        while (divisor2 < dividend2) {
        	divisor2 <<= 1;
        	add <<= 1;
        }
        while (divisor2 >= divisor3) {
        	if (divisor2 <= dividend2) {
        		dividend2 -= divisor2;
        		res += add;
        	}
        	divisor2 >>= 1;
        	add >>= 1;
        }
        if (neg) res = -res;
    	return (int)res;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.divide(2147483647, 1));
    }
}

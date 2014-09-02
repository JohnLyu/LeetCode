package stringToInteger;

public class Solution {
    public int atoi(String str) {
    	if (str == null || str.length() == 0) return 0;
        str = str.trim();
        boolean pos = true;
        int begin = 0;
        if (str.charAt(0) == '+') begin = 1;
        if (str.charAt(0) == '-') {
        	begin = 1;
        	pos = false;
        }
        long res = 0L;
        for (int i = begin; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if (c < '0' || c > '9') break;
        	long temp = Long.parseLong(String.valueOf(c));
        	res = res * 10 + temp;
        }
        if (!pos) res = -res;
        if (res > 2147483647) res = Integer.MAX_VALUE;
        if (res < -2147483648) res = Integer.MIN_VALUE;
    	return (int)res;
    }
}

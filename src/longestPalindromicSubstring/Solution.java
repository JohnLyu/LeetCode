package longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return null;
        boolean[][] isPal = new boolean[len][len];
    	
        for (int i = 0; i < len - 1; i++) {
        	isPal[i][i] = true;
        	isPal[i + 1][i] = true;
        }
    	isPal[len - 1][len - 1] = true;
    	
    	int max = 1, left = 0, right = 0;
    	for (int delta = 1; delta < len; delta++) {
    		for (int i = 0; i < len - delta; i++) {
    			isPal[i][i + delta] = isPal[i + 1][i + delta - 1] && s.charAt(i) == s.charAt(i + delta);
    			if (isPal[i][i + delta] && delta + 1 > max) {
    				max = delta + 1;
    				left = i;
    				right = i + delta;
    			}
    		}
    	}
    	return s.substring(left, right + 1);
    }
}

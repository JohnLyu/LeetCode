package palindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int weight = 1, temp = x;
        while (temp > 9) {
        	temp /= 10;
        	weight *= 10;
        }
    	while (x > 0) {
    		if ((x % 10) != (x / weight)) return false;
    		x = x % weight / 10;
    		weight /= 100;
    	}
    	return true;
    }
    
//    public static void main(String[] args) {
//    	int x = 1001;
//    	Solution s = new Solution();
//    	s.isPalindrome(x);
//    }
}

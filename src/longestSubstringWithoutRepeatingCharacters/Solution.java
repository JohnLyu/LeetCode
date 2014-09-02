package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) return 0;
    	int max = 0;
    	int left = 0, right = 0;
    	Set<Character> set = new HashSet<Character>();
    	for (; right < s.length(); right ++) {
    		char cur = s.charAt(right);
    		if (set.contains(cur)) {
    			if (right - left > max) max = right - left;
    			while (s.charAt(left) != cur) {
    				set.remove(s.charAt(left++));
    			}
    			left++;
    		} else {
    			set.add(cur);
    		}
    	}
    	if (right - left > max) max = right - left;
        return max;
    }
}

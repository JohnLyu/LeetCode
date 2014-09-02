package longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
    	int num = strs.length;
    	int minLen = Integer.MAX_VALUE;
    	for (int i = 0; i < num; i++) {
    		if (strs[i].length() < minLen) minLen = strs[i].length();
    	}
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < minLen) {
        	char cur = strs[0].charAt(index);
        	boolean isSame = true;
        	for (int i = 1; i < num; i++) {
        		if (strs[i].charAt(index) != cur) {
        			isSame = false;
        			break;
        		}
        	}
        	if (isSame) sb.append(cur);
        	else break;
        	index++;
        }
    	return sb.toString();
    }
}

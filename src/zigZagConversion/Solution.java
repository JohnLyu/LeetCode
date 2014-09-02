package zigZagConversion;

public class Solution {
    public String convert(String s, int nRows) {
    	StringBuilder sb = new StringBuilder();
    	int len = s.length();
    	if (len == 0 || nRows == 1) return s;
    	int cycle = nRows * 2 - 2;
    	for (int i = 0; i < nRows; i++) {
    		int index = i;
    		while (index < len) {
    			sb.append(s.charAt(index));
    			index += cycle;
    			if (i != 0 && i != nRows -1 && index - i * 2 < len) {
    				sb.append(s.charAt(index - i * 2));
    			}
    		}
    	}
    	return sb.toString();
    }
}

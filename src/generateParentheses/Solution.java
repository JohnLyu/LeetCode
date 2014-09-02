package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void helper(List<String> res, int left, int right, int n, StringBuilder sb) {
    	if (left == n && right == n) {
    		res.add(sb.toString());
    	} else {
    		if (left < n) {
    			sb.append('(');
    			helper(res, left + 1, right, n, sb);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    		if (right < left) {
    			sb.append(')');
    			helper(res, left, right + 1, n, sb);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    	}
    }
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) return res;
        helper(res, 0, 0, n, new StringBuilder());
    	return res;
    }
}

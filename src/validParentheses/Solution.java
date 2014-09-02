package validParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) return true;
        if (len % 2 == 1) return false;
    	char[] left = {'(', '[', '{'};
    	char[] right = {')', ']', '}'};
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < len; i++) {
    		char cur = s.charAt(i);
    		boolean leftC = false;
    		for (int j = 0; j < 3; j++) {
    			if (left[j] == cur) {
    				stack.push(cur);
    				leftC = true;
    				break;
    			}
    		}
    		if (!leftC) {
    			for (int j = 0; j < 3; j++) {
    				if (right[j] == cur) {
    					if (stack.size() == 0 || stack.pop() != left[j]) return false;
    				}
    			}
    		}
    		
    	}
    	return stack.isEmpty();
    }
}

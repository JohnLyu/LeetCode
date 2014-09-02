package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public void getAns(List<String> res, StringBuilder sb, int len, int index, String digits) {
		if (index == len) {
			res.add(sb.toString());
		} else {
			char cur = digits.charAt(index);
			String curNum = letters[cur - '2'];
			for (int i = 0; i < curNum.length(); i++) {
				sb.append(curNum.charAt(i));
				getAns(res, sb, len, index + 1, digits);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        int len = digits.length();
        getAns(res, new StringBuilder(), len, 0, digits);
    	return res;
    }
}

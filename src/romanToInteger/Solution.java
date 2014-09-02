package romanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	map.put('M', 1000);
    	map.put('D', 500);
    	map.put('C', 100);
    	map.put('L', 50);
    	map.put('X', 10);
    	map.put('V', 5);
    	map.put('I', 1);
    	int res = 0;
    	int last = 0;
    	for (int i = 0; i < s.length(); i++) {
    		int cur = map.get(s.charAt(i));
    		if (cur > last) res -= last;
    		else res += last;
    		last = cur;
    	}
    	return res + last;
    }
}

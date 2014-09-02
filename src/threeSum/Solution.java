package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) return res;
    	Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
        	if (i == 0 || num[i] != num[i-1]) {
        		int left = i + 1, right = num.length - 1;
        		while (left < right) {
        			if (num[left] + num[right] == -num[i]) {
        				if (res.size() > 0) {
        					List<Integer> last = res.get(res.size() - 1);
        					if (!(num[i] == last.get(0) && num[left] == last.get(1) && num[right] == last.get(2))) {
                    			List<Integer> one = new ArrayList<Integer>();
                    			one.add(num[i]);
                    			one.add(num[left]);
                    			one.add(num[right]);
                    			res.add(one);
        					}
        				} else {
                			List<Integer> one = new ArrayList<Integer>();
                			one.add(num[i]);
                			one.add(num[left]);
                			one.add(num[right]);
                			res.add(one);
        				}
            			left++;
            			right--;
            		} else if (num[left] + num[right] > -num[i]) right--;
            		else left++;
        		}
        	}
        }
    	return res;
    }
}

package threeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	int len = num.length;
        if (len == 0) return 0;
        if (len == 1) return num[0];
        if (len == 2) return num[0] + num[1];
    	Arrays.sort(num);
    	int closest = Integer.MAX_VALUE;
    	int res =  0;
        for (int i = 0; i < len - 2; i++) {
        	int left = i + 1, right = len - 1;
        	while (left < right) {
        		int sum = num[i] + num[left] + num[right];
        		if (sum == target) return target;
        		else {
        			if (Math.abs(sum - target) < closest) {
        				res = sum;
        				closest = Math.abs(sum - target);
        			}
        			if (sum > target) right--;
        			else left++;
        		}
        	}
        }
    	return res;
    }
}

package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	 List<List<Integer>> res = new ArrayList<List<Integer>>();
    	 int len = num.length;
         if (num == null || len < 4) return res;
         Arrays.sort(num);
         for (int first = 0; first < len - 3; first++) {
        	 if (first > 0 && num[first] == num[first - 1]) continue;
        	 for (int second = first + 1; second < len - 2; second++) {
        		 if (second > first + 1 && num[second] == num[second - 1]) continue;
        		 int left = second + 1, right = len - 1;
        		 while (left < right) {
        			 int sum = num[first] + num[second] + num[left] + num[right];
        			 if (sum == target) {
        				 if (res.size() == 0) {
        					 List<Integer> one = new ArrayList<Integer>();
        					 one.add(num[first]);
        					 one.add(num[second]);
        					 one.add(num[left]);
        					 one.add(num[right]);
        					 res.add(one);
        				 }
        				 else {
        					 List<Integer> last = res.get(res.size() - 1);
        					 if (!(num[first] == last.get(0) && num[second] == last.get(1) && num[left] == last.get(2) && num[right] == last.get(3))) {
        						 List<Integer> one = new ArrayList<Integer>();
            					 one.add(num[first]);
            					 one.add(num[second]);
            					 one.add(num[left]);
            					 one.add(num[right]);
            					 res.add(one);
        					 }
        				 }
        				 left++;
        				 right--;
        			 } else if (sum < target) left++;
        			 else right--;
        		 }
        	 }
         }
         return res;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {1, 2, 0, -1};
    	s.fourSum(num, 2);
    }
}

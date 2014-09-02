package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionON3 {
    class Pair {
    	int left;
    	int right;
    	public Pair(int left, int right) {
    		this.left = left;
    		this.right = right;
    	}
    }
	
	public List<List<Integer>> fourSum(int[] num, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
   	 	int len = num.length;
        if (num == null || len < 4) return res;
        Arrays.sort(num);
        
        Map<Integer, List<Pair>> sumMap = new HashMap<Integer, List<Pair>>();
        for (int left = 0; left < len - 1; left++) {
        	for (int right = left + 1; right < len; right++) {
        		int sum = num[left] + num[right];
        		if (sumMap.containsKey(sum)) {
        			sumMap.get(sum).add(new Pair(left, right));
        		} else {
        			List<Pair> temp = new ArrayList<Pair>();
        			temp.add(new Pair(left, right));
        			sumMap.put(sum, temp);
        		}
        	}
        }
        for (int first = 0; first < len - 3; first++) {
        	if (first > 0 && num[first] == num[first - 1]) continue;
        	for (int second = first + 1; second < len - 2; second++) {
        		if (second > first + 1 && num[second] == num[second - 1]) continue;
        		int sum = target - num[first] - num[second];
        		if (sumMap.containsKey(sum)) {
        			for (Pair pair : sumMap.get(sum)) {
        				if (pair.left > second) {
        					List<Integer> one = new ArrayList<Integer>();
        					one.add(num[first]);
	       					one.add(num[second]);
	       					one.add(num[pair.left]);
	       					one.add(num[pair.right]);
        					set.add(one);
        				}
        			}
        			
        		}
        	}
        }
        for (List<Integer> one : set) {
        	res.add(one);
        }
        return res;
	}
	
	public static void main(String[] args) {
		SolutionON3 s = new SolutionON3();
		int[] num = {1, 0, -1, 2, -2};
		s.fourSum(num, 0);
	}
}

package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> numberIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (numberIndex.containsKey(target - numbers[i])) {
				result[0] = numberIndex.get(target - numbers[i]);
				result[1] = i + 1;
				break;
			} else {
				numberIndex.put(numbers[i], i + 1);
			}
		}
		return result;
	}
}
package containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = Math.min(height[left], height[right]) * right;
        while (left < right) {
        	if (height[left] <= height[right]) {
        		int left2 = left + 1;
        		while (left2 < right && height[left2] <= height[left]) left2++;
        		left = left2;
        	} else {
        		int right2 = right - 1;
        		while (left < right2 && height[right2] <= height[right]) right2--;
        		right = right2;
        	}
        	int area = Math.min(height[left], height[right]) * (right - left);
        	if (area > maxArea) maxArea = area;
        }
    	return maxArea;
    }
}

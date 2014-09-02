package integerToRoman;

public class Solution {
    public String intToRoman(int num) {
    	int[] unit = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
        	for (int i = 0; i < num / unit[index]; i++) {
        		sb.append(symbol[index]);
        	}
        	num %= unit[index++];
        }
    	return sb.toString();
    }
}

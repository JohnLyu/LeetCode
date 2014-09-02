package longestPalindromicSubstring;

public class SolutionON {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		StringBuilder sb = new StringBuilder();
		sb.append("~#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) + "#");
		}
		sb.append('@');
		
		int len = sb.length(), mx = 0, id = 0, resRad = 0, resi = 0;
		int[] rad = new int[len];
		for (int i = 1; i < len - 1; i++) {
			if (mx > i) {
				rad[i] = Math.min(rad[2 * id - i], mx - i);
			} else {
				rad[i] = 1;
			}
			for (; sb.charAt(i + rad[i]) == sb.charAt(i - rad[i]); rad[i]++) {
			}
			if (rad[i] + i > mx) {
				mx = rad[i] + i;
				id = i;
			}
			if (rad[i] > resRad) {
				resRad = rad[i];
				resi = i;
			}
		}
		int left = resi/2 - resRad/2;
		return s.substring(left, left + resRad - 1);
	}
	
//	public static void main(String[] args) {
//		String s = "a";
//		System.out.println(longestPalindrome(s));
//	}
}

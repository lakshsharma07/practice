package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
		System.out.println(longestPalindromeSubseq(s));
	}

	static int[][] storage;

	public static int longestPalindromeSubseq(String s) {
		storage = new int[s.length()][s.length()];
		return helper(s, 0, s.length() - 1);

	}

	private static int helper(String s, int i, int j) {
		if (storage[i][j]>0) {
			return storage[i][j];
		}
		if (i > j)
			return 0;
		if (i == j)
			return 1;

		if (s.charAt(i) == s.charAt(j)) {
			storage[i][j] = helper(s, i + 1, j - 1) + 2;
		} else {
			storage[i][j] = Math.max(helper(s, i + 1, j), helper(s, i, j - 1));
		}
		return storage[i][j];
	}

	static int count = 0;
	static Map<String, Integer> str = new HashMap<>();

	public static int longestPalindromeSubseq1(String s) {

		helper(s, 0, s.length() - 1);
		System.out.println(str);
		if (str.containsKey(s)) {
			return str.get(s);
		}
		if (s.length() <= 1) {
			str.put(s, s.length());
			return str.get(s);
		}

		if (s.charAt(0) != s.charAt(s.length() - 1)) {
			// System.out.println("if - " + s);
			int x = longestPalindromeSubseq(s.substring(0, s.length() - 1));
			int y = longestPalindromeSubseq(s.substring(1, s.length()));
			// System.out.println("---");
			str.put(s, Integer.max(x, y));
			return str.get(s);
		} else {
			// System.out.println("else - " + s);
			int x = longestPalindromeSubseq(s.substring(1, s.length() - 1)) + 2;
			str.put(s, x);
			return str.get(s);
		}
	}

}

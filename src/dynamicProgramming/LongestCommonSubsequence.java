package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String text1 = "azopevefqpmvkvctwhgnivoxqlwrmfyrslyjqlufgxkponkbgpqtifyhgb";
		String text2 = "gdsvqvkjmritatgzspyfwpozuzwpujqfctepatuponctwpejwzmbwzarojo";
		System.out.println(longestCommonSubsequence(text1, text2));
	}
	// "azopevefqpmvkvctwhgnivoxqlwrmfyrslyjqlufgxkponkbgpqtifyhgb"
	// "gdsvqvkjmritatgzspyfwpozuzwpujqfctepatuponctwpejwzmbwzarojo"
	// "hafcdqbgncrcbihkd"

	public static int longestCommonSubsequence(String text1, String text2) {

		if (text1.contains(text2) || text2.contains(text1)) {
			return Integer.min(text1.length(), text2.length());
		}

		return (text1.length() > text2.length() ? dfs(text1, text2, 0, 0, 0) : dfs(text2, text1, 0, 0, 0));

	}

	private static int dfs(String text1, String text2, int i, int j, int count) {

		if (text1.length() <= 0 || j > text2.length() - 1) {
			return count;
		}
		System.out.println(text1 + " , " + text2.charAt(j) + " , " + count);
		if ((i = text1.indexOf(text2.charAt(j))) != -1) {
			return Integer.max(dfs(text1.substring(i + 1, text1.length()), text2, i, j + 1, count + 1),dfs(text1, text2, i, j + 1, count));
		} else {
			return dfs(text1, text2, i, j + 1, count);
		}
	}

	public static int longestCommonSubsequence1(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length(); ++i)
			for (int j = 0; j < s2.length(); ++j)
				if (s1.charAt(i) == s2.charAt(j)) {
					// System.out.println(s1.charAt(i));
					dp[i + 1][j + 1] = 1 + dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
		return dp[s1.length()][s2.length()];
	}

	public int longestCommonSubsequence2(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		if (m < n)
			return longestCommonSubsequence(s2, s1);
		int[][] dp = new int[2][n + 1];
		for (int i = 0, k = 1; i < m; ++i, k ^= 1)
			for (int j = 0; j < n; ++j)
				if (s1.charAt(i) == s2.charAt(j))
					dp[k][j + 1] = 1 + dp[k ^ 1][j];
				else
					dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
		return dp[m % 2][n];
	}

	public int longestCommonSubsequence3(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		if (m < n) {
			return longestCommonSubsequence(text2, text1);
		}
		int[] dp = new int[n + 1];
		for (int i = 0; i < text1.length(); ++i) {
			for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < text2.length(); ++j) {
				prevRowPrevCol = prevRow;
				prevRow = dp[j + 1];
				dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
			}
		}
		return dp[n];
	}

}

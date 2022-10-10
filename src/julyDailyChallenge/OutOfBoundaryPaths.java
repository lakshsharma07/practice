package julyDailyChallenge;

import java.util.Arrays;

public class OutOfBoundaryPaths {

	static int[][][] memo;
	static int M = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 8;
		int n = 7;
		int maxMove = 16;
		int startRow = 1;
		int startColumn = 5;
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
	}

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

		memo = new int[m][n][maxMove + 1];
		for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
		return dfs(m, n, maxMove, startRow, startColumn);

	}

	private static int dfs(int m, int n, int N, int i, int j) {
		// memo[startRow][startColumn] = 1;
		if (i == m || j == n || i < 0 || j < 0)
			return 1;
		if (N == 0)
			return 0;
		if (memo[i][j][N] >= 0)
			return memo[i][j][N];

		memo[i][j][N] = ((dfs(m, n, N - 1, i - 1, j) + dfs(m, n, N - 1, i + 1, j)) % M
				+ (dfs(m, n, N - 1, i, j - 1) + dfs(m, n, N - 1, i, j + 1)) % M) % M;
		return memo[i][j][N];
	}

}

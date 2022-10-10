package julyDailyChallenge;

public class OutOfBoundaryPaths2 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int m = 8;
		int n = 7;
		int maxMove = 16;
		int startRow = 1;
		int startColumn = 5;
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));

	}

	static int[][] arr = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] memo;
	static int count = 0;
	static int M = 1000000007;

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		memo = new int[m][n];
		dfs(m, n, maxMove, startRow, startColumn);
		return count;
	}

	private static int dfs(int m, int n, int maxMove, int i, int j) {
		// memo[startRow][startColumn] = 1;
		
		if (i == m || j == n || i < 0 || j < 0)
			return 1;
		
		if (maxMove == 0)
			return 0;
		
		
		/*
		 * count = ((dfs(m, n, maxMove - 1, i - 1, j) + dfs(m, n, maxMove - 1, i + 1,
		 * j)) % M + (dfs(m, n, maxMove - 1, i, j - 1) + dfs(m, n, maxMove - 1, i, j +
		 * 1)) % M) % M;
		 */

		for (int k = 0; k < arr.length; k++) {
			int x = i - arr[k][0];
			int y = j - arr[k][1];
			//System.out.println(x+" , "+y);

			count= (count%M +dfs(m, n, maxMove-1, x, y))%M;

		}
		//102984580
		//1311287902
		return count;
	}

}

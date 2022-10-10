import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TriangleMinPathSum {

	public static void main(String[] args) {

		List<List<Integer>> triangle =

				new ArrayList<>(List.of(List.of(-7), List.of(-2, 1), List.of(-5, -5, 9), List.of(-4, -5, 4, 4),
						List.of(-6, -6, 2, -1, -5), List.of(3, 7, 8, -3, 7, -9), List.of(-9, -1, -9, 6, 9, 0, 7),
						List.of(-7, 0, -6, -8, 7, 1, -4, 9), List.of(-3, 2, -6, -9, -7, -6, -9, 4, 0),
						List.of(-8, -6, -3, -9, -2, -6, 7, -5, 0, 7), List.of(-9, -1, -2, 4, -2, 4, 4, -1, 2, -5, 5),
						List.of(1, 1, -6, 1, -2, -4, 4, -2, 6, -6, 0, 6),
						List.of(-3, -3, -6, -2, -6, -2, 7, -9, -5, -7, -5, 5, 1)));

		// new ArrayList<>(List.of(List.of(2), List.of(3, 4), List.of(6, 5,7),List.of(4,
		// 1, 8, 3)));
		System.out.println(minimumTotal1(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		return +minSum(triangle, 0, 0);

	}

	// TopDown Approach
	static HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public static int minSum(List<List<Integer>> triangle, int level, int index) {
		if (cache.containsKey(level + "," + index)) {
			return cache.get(level + "," + index);
		}
		if (level == triangle.size() - 1) {
			cache.put(level + "," + index, triangle.get(level).get(index));
			return triangle.get(level).get(index);
		}

		int x = triangle.get(level).get(index) + minSum(triangle, level + 1, index);
		int y = triangle.get(level).get(index) + minSum(triangle, level + 1, index + 1);
		cache.put(level + "," + index, Integer.min(x, y));

		// System.out.println(x + " , " + y + " = " + Integer.min(x, y));
		// System.out.println(cache);
		return Integer.min(x, y);
	}

	// bottom up approach
	public static int minimumTotal1(List<List<Integer>> triangle) {
		Object[] dp = triangle.get(triangle.size() - 1).toArray();
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				dp[j] = triangle.get(i).get(j) + Integer.min((int) dp[j], (int) dp[j + 1]);
			}
		}
		return (int) dp[0];

	}

	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null)
			return 0;
		int size = triangle.size();
		int[] dp = new int[size + 1];
		dfs(dp, triangle, size - 1);
		return dp[0];

	}

	private void dfs(int[] dp, List<List<Integer>> t, int row) {
		if (row < 0)
			return;
		for (int j = 0; j <= row; j++) {
			dp[j] = t.get(row).get(j) + Math.min(dp[j], dp[j + 1]);
		}
		dfs(dp, t, row - 1);
	}

}

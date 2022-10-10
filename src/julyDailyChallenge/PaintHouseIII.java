package julyDailyChallenge;

public class PaintHouseIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = { 0, 0, 0, 0, 0 };
		int[][] cost = {{ 1, 10 },{ 10, 1 },{ 10, 1 },{ 1, 10 },{ 5, 1 }};
		int m = 5;
		int n = 2;
		int target = 3;
		System.out.println(minCost(houses, cost, m, n, target));
	}

	static final int maxCost = 1000001;
	static Integer[][][] memo = new Integer[100][100][21];

	public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {

		int minCost = dfs(houses, 0, 0, cost, target, 0);

		return minCost == maxCost ? -1 : minCost;
	}

	private static Integer dfs(int[] houses, int index, int prev, int[][] cost, int target, int count) {
		if (index == houses.length) {
			return count == target ? 0 : maxCost;
		}

		if (count > target) {
			return maxCost;
		}

		if (memo[index][count][prev] != null) {
			return memo[index][count][prev];
		}
		int minCost = maxCost;
		if (houses[index] != 0) {
			int newNeighborhoodCount = count + (houses[index] != prev ? 1 : 0);

			minCost = dfs(houses, index + 1, houses[index], cost, target, newNeighborhoodCount);

		} else {
			int totalColors = cost[0].length;
			for (int i = 1; i <= totalColors; i++) {

				int newNeighborhoodCount = count + (i != prev ? 1 : 0);

				int totalCost = cost[index][i - 1]
						+ dfs(houses, index + 1, i, cost, target, newNeighborhoodCount);

				minCost = Math.min(minCost, totalCost);
			}
		}

		return memo[index][count][prev] = minCost;

	}

}

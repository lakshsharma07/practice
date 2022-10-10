package augDailyChallenge;

import java.util.Arrays;

public class CombinationSumIV {

	static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		int target = 32;
		System.out.println(combinationSum4(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {

		
		dp = new int[target + 1];
		Arrays.fill(dp, -1);
		return dfs(nums, target, 0);

	}

	private static int dfs(int[] nums, int target, int sum) {
		if (sum == target) {
			return 1;
		}
		if (sum > target) {
			return 0;
		}
		if (dp[sum] != -1)
			return dp[sum];
		// 181997601

		int res = 0;
		for (int i : nums) {

			res += dfs(nums, target, sum + i);

		}
		return dp[sum] = res;
	}

}

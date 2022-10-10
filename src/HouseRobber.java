
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));
	}

	public static int rob2(int[] nums) {
		int prev = 0, rob = 0, nr = 0;
		for (int money : nums) {
			System.out.println("prev " + prev);
			System.out.println("rob " + rob);
			System.out.println("nr " + nr);
			prev = rob;
			rob = nr + money;
			nr = Math.max(nr, prev);
		}
		System.out.println(Math.max(rob, nr));
		return Math.max(rob, nr);

	}

	public static int rob1(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			int take = nums[i];
			if (i > 1)
				take += dp[i - 2];
			int nottake = dp[i - 1];
			dp[i] = Math.max(take, nottake);
		}
		System.out.println(dp[n - 1]);
		return dp[n - 1];
	}
	
	
	public static int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0],nums[1]);
		}
		int prev1 = nums[0];
		int prev2 = nums[1];
		int prev3 = nums[0] + nums[2];
		int max =  Math.max(nums[1],prev3);
		int curr = 0;
		for (int i = 3; i < n; i++) {
			curr = nums[i]+ Math.max(prev1,prev2);
			//
			if (max < curr) {
				System.out.println(max);
				max = curr;
			}
			prev1 = prev2;
			prev2 = prev3;
			prev3 = curr;
			
		}
		return max;
	}

}

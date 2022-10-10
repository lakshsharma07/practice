
public class HouseRobber2 {

	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		System.out.println(rob(nums));
	}
	
	public static int rob1(int[] nums) {
		 if(nums.length==1)
	            return nums[0];
		int n = nums.length;
		//Without first House
		int[] dp = new int[n-1];
		dp[0] = nums[0];
		for (int i = 1; i < n-1; i++) {
			int take = nums[i];
			if (i > 1 )
				take += dp[i - 2];
			int nottake = dp[i - 1];
			dp[i] = Math.max(take, nottake);
		}
		//Without last house
		int[] dp1 = new int[n];
		dp1[0] = 0;
		for (int i = 1; i < n; i++) {
			int take = nums[i];
			if (i > 1 )
				take += dp1[i - 2];
			int nottake = dp1[i - 1];
			dp1[i] = Math.max(take, nottake);
		}
		
		
		
		System.out.println(Math.max(dp[dp.length - 1], dp1[dp1.length - 1]));
		return Math.max(dp[dp.length - 1], dp1[dp1.length - 1]);
	}
	
	
	public static int rob(int[] nums) {
		if(nums.length==1)
            return nums[0];
		int n = nums.length;
		int prev = 0, rob = 0, nr = 0;
		for (int i = 0; i < n-1; i++) {
			prev = rob;
			rob = nr + nums[i];
			nr = Math.max(nr, prev);
		}
		int x1 = Math.max(rob, nr);
		
		
		prev = 0; 
		rob = 0;
		nr = 0;
		for (int i = 1; i < n; i++) {
			prev = rob;
			rob = nr + nums[i];
			nr = Math.max(nr, prev);
		}
		int x2 = Math.max(rob, nr);
		return Math.max(x1, x2);

	}

}

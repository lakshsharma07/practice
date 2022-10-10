package julyDailyChallenge;

import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1};
		int k = 2;
		System.out.println(subarraySum1(nums, k));
	}

	public static int subarraySum(int[] nums, int k) {
		int dp[] = new int[nums.length+1];
		int count = 0;
		dp[0] = 0;

		for (int i = 1; i <= nums.length; i++) {
			dp[i] = dp[i - 1] + nums[i-1];

		}
		
		
		for (int start = 0; start < dp.length; start++) {
            for (int end = start + 1; end < dp.length; end++) {
                if (dp[end] - dp[start] == k)
                    count++;
            }
        }
		return count;

	}
	
	
	public static int subarraySum1(int[] nums, int k) {

		HashMap<Integer,Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		map.put(0,1);
		for (int i = 0; i < nums.length; i++) {
			
			sum+=nums[i];
			if (map.containsKey(sum-k)) {
				count+=map.get(sum-k);
				
			}
			map.put(sum,map.getOrDefault(sum,0)+1);

		}
		
		return count;

	}

}

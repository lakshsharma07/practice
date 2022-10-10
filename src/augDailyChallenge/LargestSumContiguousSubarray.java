package augDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSubArraySum(a));
	}

	public static int maxSubArraySum(int[] a) {
		int n = a.length;
		//int[] dp = new int[n];

		//dp[0] = a[0];
		int prev =  a[0];
		int max = prev;
		for (int i = 1; i < n; i++) {
			if (prev + a[i] > a[i]) {
				prev = prev + a[i];
			} else {
				prev = a[i];
			}

			if (prev > max) {
				max = prev;
			}
		}

		return max;

	}
	
	
	public List<Integer> majorityElement(int[] nums) {
		
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {

			map.put(nums[i], map.getOrDefault(nums[i],0)+1);
			if (!list.contains(nums[i]) && map.get(nums[i])>nums.length/3) {
				list.add(nums[i]);
			}
			
		}
		
		return list;
        
    }

}

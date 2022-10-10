package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class EasyDPproblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// maxSubArray
		// int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		// System.out.println(maxSubArray(nums));

		// Get Maximum in Generated Array
		// System.out.println( getMaximumGenerated(7));

		// String s = "aaaaaa", t = "bbaaaa";
		// System.out.println(isSubsequence1(s,t));

		//int[] prices = { 7, 6, 4, 3, 1 };// {7,1,5,3,6,4};
		//System.out.println(maxProfit(prices));
		
		System.out.println(generate( 5));
		

	}

	public static int maxSubArray(int[] nums) {
		int n = nums.length;
		// int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
		int prev = nums[0];
		int max = nums[0];

		for (int i = 1; i < n; i++) {
			prev = nums[i] + (prev > 0 ? prev : 0);
			max = Math.max(max, prev);
			System.out.println(max);
			System.out.println(prev);
			System.out.println("------");
		}

		return max;
	}

	public static int getMaximumGenerated(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		int max = 0;
		for (int i = 2; i < n + 1; i++) {
			if (i % 2 == 0) {
				arr[i] = arr[i / 2];
			} else {
				arr[i] = arr[i / 2] + arr[i / 2 + 1];
			}
			// System.out.println(arr[i]);
			max = Math.max(max, arr[i]);
		}

		return max;

	}

	// with recursion
	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}

		int x = t.indexOf(s.charAt(0));
		if (x != -1) {
			return isSubsequence(s.substring(1, s.length()), t.substring(x + 1, t.length()));
		} else {
			return false;
		}

	}

	// without recursion
	public static boolean isSubsequence1(String s, String t) {

		if (s.length() == 0) {
			return true;
		}
		int index = -1;
		for (int i = 0; i < s.length(); i++) {
			index = t.indexOf(s.charAt(i));
			System.out.println(index);
			if (index == -1) {
				return false;
			}
			t = t.substring(index + 1, t.length());
		}
		return true;
	}

	public static int maxProfit(int[] prices) {

		int buyPrice = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buyPrice) {
				buyPrice = prices[i];
			} else {
				max = Math.max(max, prices[i] - buyPrice);
			}
		}
		return max;

	}

	public static List<List<Integer>> generate(int numRows) {
	
        List<List<Integer>> arr = new ArrayList<>();
        
		for (int i = 0; i <= numRows; i++) {
			List<Integer> arr1 = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr1.add(1);
				}else {
					arr1.add(arr.get(i-1).get(j-1) +arr.get(i-1).get(j));
				}
			}
			arr.add(arr1);
			System.out.println(arr1);
		}
		return arr;
	}
	
	
}

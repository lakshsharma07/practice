package dynamicProgramming;

import java.util.TreeSet;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		System.out.println(lengthOfLIS1(nums));
	}

	//time complexity O(n2) space complexity O(n)
	public static int lengthOfLIS(int[] nums) {

		int[] dp = new int[nums.length];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if (dp[i] > count) {
				count = dp[i];
			}
		}
		return count;

	}
	
	
	//BST time complexity O(n2) space complexity O(n)
		public static int lengthOfLIS1(int[] nums) {

			TreeSet<Integer> bst = new TreeSet<>();
			Integer ch ;
			for (Integer num : nums) {
				//System.out.println(num);
				ch = bst.ceiling(num);
				//System.out.println(ch);
				if (ch == null) {
					bst.add(num);
				}else {
					bst.remove(ch);
					bst.add(num);
				}
				
				//System.out.println(bst);
			}

			return bst.size();

		}

}

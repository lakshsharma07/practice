package julyDailyChallenge;

import java.util.HashMap;
import java.util.Map.Entry;

public class MaximumNumberOfPairsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = { 1, 3, 2, 1, 3, 2, 2 };
		//System.out.println(numberOfPairs(nums));
		
		
		int[] nums = {10,12,19,14};
		System.out.println(maximumSum(nums));
	}

	public static int[] numberOfPairs(int[] nums) {

		int[] res = new int[2];

		HashMap<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (count.containsKey(nums[i])) {
				count.put(nums[i], count.get(nums[i]) + 1);
			} else {
				count.put(nums[i], 1);
			}
		}

		for (Integer i : count.keySet()) {
			res[0] += count.get(i) / 2;
			res[1] += count.get(i) % 2;
		}

		System.out.println(res[0] + " , " + res[1]);
		return res;

	}

	public static int maximumSum(int[] nums) {

		int res = 0;

		HashMap<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int y = 0;
			while (x>0) {
				y+=x%10;
				x = x/10;
			}
			if (count.containsKey(y)) {
				res = Math.max(res,count.get(y)+nums[i]);
				count.put(y,Math.max(count.get(y),nums[i]));
			} else {
				count.put(y,nums[i] );
			}
			System.out.println(count);
		}
		return res==0?-1:res;
	}

}

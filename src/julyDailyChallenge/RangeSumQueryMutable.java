package julyDailyChallenge;

import java.util.ArrayList;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cmd = { "NumArray", "sumRange", "update", "sumRange" };
		int[][] input = { { 1, 3, 5 }, { 0, 2 }, { 1, 2 }, { 0, 2 } };

		for (int i = 0; i < input.length; i++) {
			if (cmd[i].equalsIgnoreCase("NumArray")) {
				NumArray(input[i]);
			} else if (cmd[i].equalsIgnoreCase("update")) {
				update(input[i][0], input[i][1]);
			} else if (cmd[i].equalsIgnoreCase("sumRange")) {
				System.out.println(sumRange(input[i][0], input[i][1])); 
			}
		}
	}

	 // ArrayList<Integer> num = new ArrayList<>();
	static int[] num;

	public static void NumArray(int[] nums) {
		num = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			num[i] = sum;
		}
	}

	public static void update(int index, int val) {
		int prev = num[index];
		if (index > 0) {
			prev = num[index] - num[index - 1];
		}
		for (int i = index; i < num.length; i++) {
			num[i] = num[i] - prev + val;
		}
	}

	public static int sumRange(int left, int right) {

		if (left > 0) {
			return num[right] - num[left - 1];
		}
		return num[right];

	}

}

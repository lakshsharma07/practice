package dailyChalange;

public class NonDecreasingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 4, 1, 2 };
		System.out.println(checkPossibility(nums));
	}

	public static boolean checkPossibility(int[] nums) {
		int count = 0;
		int n = nums.length - 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] > nums[i + 1]) {
				if (++count > 1) {
					return false;
				}
				if (i - 1 < 0 || nums[i + 1] >= nums[i - 1]) {
					nums[i] = nums[i + 1];
				} else {
					nums[i + 1] = nums[i];
				}

			}
		}

		return true;

	}

}

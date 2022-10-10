import java.util.HashMap;
import java.util.Map;

public class SUM2 {

	public static void main(String[] args) {
		int[] x = {-1,-2,-3,-4,-5};

		System.out.println(twoSum(x,-8));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> nums3 = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums3.containsKey(nums[i])) {
				return new int[]{nums3.get(nums[i]),i};
			}
			nums3.put(target-nums[i],i);
		}
		
		return null;
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3 {

	public static void main(String[] args) {
		int[] x = {0,2,2,3,0,1,2,3,-1,-4,2};

		System.out.println(threeSum(x));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);

	        List < List < Integer >> result = new ArrayList < > ();
	        for (int i = 0; i + 2 < nums.length; i++) {
	            // Skip all duplicates from left
	            // i>0 ensures this check is made only from 2nd element onwards
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }

	            int j = i + 1;
	            int k = nums.length - 1;
	            while (j < k) {
	                int sum = nums[j] + nums[k] + nums[i];
	                if (sum == 0) {
	                    // Add triplet to result
	                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

	                    k--;

	                    // Skip all duplicates from right
	                    while (j < k && nums[k] == nums[k + 1]) k--;
	                } else if (sum > 0) {
	                    // Decrement k to reduce sum value
	                    k--;
	                } else {
	                    // Increment j to increase sum value
	                    j++;
	                }
	            }
	        }
	        return result;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
			
			Map<Integer, Integer> nums3 = new HashMap<>();
			for (int j = i+1; j < nums.length; j++) {
				System.out.println(nums[i]+","+nums[j]+"-"+nums3.containsKey(nums[j]));
				System.out.println(nums3);
				if (nums3.containsKey(nums[j])) {
					
					List<Integer> res1 = new ArrayList<>(Arrays.asList(nums[i],nums3.get(nums[j]),nums[j]));
					System.out.println(nums[i]+","+nums3.get(nums[j])+","+nums[j]);
					res.add(res1);
					//System.out.println(nums3.remove(nums[j],nums3.get(nums[j])));
					nums3.remove(nums[j],nums3.get(nums[j]));
					System.out.println(nums3);
					System.out.println("-----------------------");
					
					/*
					 * if (!res.contains(res1)) { res.add(res1); }
					 */
				}
				else {
					nums3.put(-(nums[i]+nums[j]),nums[j]);
				}
				
			}
		}
		return res;
	}

}

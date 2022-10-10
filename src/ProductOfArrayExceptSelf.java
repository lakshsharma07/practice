import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4,4,1,2};

		productExceptSelf3(nums);
	}

	static int[] result;

	public static int[] productExceptSelf(int[] nums) {

		for (int x : nums) {
			System.out.print(x + " ");
		}
		System.out.println("--------------");
		
		int n = nums.length;
		// Base case
		if (n == 1) {
			nums[0] = 0;
			return nums;
		}
		// Initialize memory to all numsays
		int left[] = new int[n];
		int right[] = new int[n];

		int i, j;

		/*
		 * Left most element of left numsay is always 1
		 */
		left[0] = 1;

		/*
		 * Right most element of right numsay is always 1
		 */
		right[n - 1] = 1;

		/* Construct the left numsay */
		for (i = 1; i < n; i++)
			left[i] = nums[i - 1] * left[i - 1];
		
		for (int x : left) {
			System.out.print(x + " ");
		}
		System.out.println("--------------");
		
		/* Construct the right numsay */
		for (j = n - 2; j >= 0; j--)
			right[j] = nums[j + 1] * right[j + 1];

		
		for (int x : right) {
			System.out.print(x + " ");
		}
		System.out.println("--------------");

		/*
		 * Construct the product numsay using left[] and right[]
		 */
		for (i = 0; i < n; i++)
			nums[i] = left[i] * right[i];

		/* print the constructed prod numsay */
		for (i = 0; i < n; i++)
			System.out.print(nums[i] + " ");

		return nums;
	}
	
	public static int[] productExceptSelf3(int[] nums) {
        
		
		Map<Integer,Integer> numsMap = new HashMap<>();
		
		for (int int1 : nums) {
			numsMap.put(int1,0);
		}
		
		
		
		if (nums.length == 1) {
			nums[0] = 0;
			return nums;
		}
		int n = numsMap.size();
		int left[] = new int[n];
		int right[] = new int[n];

		int i, j;

		left[0] = 1;

		right[n - 1] = 1;

		for (i = 1; i < n; i++)
			left[i] = nums[i - 1] * left[i - 1];
		
		for (j = n - 2; j >= 0; j--)
			right[j] = nums[j + 1] * right[j + 1];

		for (i = 0; i < n; i++)
			nums[i] = left[i] * right[i];


		return nums;
    }

	public static int[] productExceptSelf2(int[] nums) {
		int len = nums.length;
        int[] m = new int[len];
        int total = 1;
        int zero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                total *= nums[i];
            } else {
                zero++;
            }
        }
        
        for (int i = 0; i < len; i++) { 
            if (nums[i] == 0 && zero == 1) {
                m[i]  = total;
            } else if (zero >= 1 ){
                m[i] = 0;
            } else {
                m[i] = total / nums[i];
            }
        }
        return m;
	}

}

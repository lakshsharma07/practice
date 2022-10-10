import java.util.HashMap;
import java.util.Map.Entry;

public class sortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {0,2,2,3,0,1,2,3,-1,-4,2};
		sortColors(x);
	}

	
	public static void sortColors(int[] nums) {  
		int j ;
		int temp;
		for (int i = 0; i<nums.length-1; i++) {
			 j = nums.length-1;
			while (j>i) {
				if (nums[i]>nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
				j--;
			}	
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+",");
		}
	    }

}

package dailyChalange;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(minMoves2(nums)); 
	}
	
	public static int minMoves2(int[] nums) {
		int med= 0;
		int res = 0;
		int n = nums.length;
		Arrays.sort(nums);
		med = (n%2 == 0)?nums[n/2]:nums[(n-1)/2];		
		for (int i : nums) {
			res+= Math.abs(med-i);
			
		}		
		return res;      
    }
	
	 public int minMoves21(int[] nums) {
	        Arrays.sort(nums);
	        int i = 0, j = nums.length-1;
	        int count = 0;
	        while(i < j){
	            count += nums[j]-nums[i];
	            i++;
	            j--;
	        }
	        return count;
	    }

}

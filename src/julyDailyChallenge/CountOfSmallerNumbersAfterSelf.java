package julyDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,2,6,1};
		System.out.println(countSmaller1(nums));
	}
	
	
	public static List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		int val = 0;
		int[] count = new int[n];
		count[n-1] = 0;
		List<Integer> output = new ArrayList<>();
		output.add(0);
		for (int i = n-2; i >=0; i--) {
			int x = nums[i];
			val = 0;
			for (int j = i+1; j < n; j++) {
				if (j<n-1 && nums[j]==nums[j+1]) {
					val+=1;
					continue;
				}
				if (nums[j]<nums[i]) {
					val+= count[j]+1;
					break;
				}
			}
			count[i] = val;
			output.add(0,val);
		}
		
		return output;

    }
	
	
	public static List<Integer> countSmaller1(int[] nums) {
		int n = nums.length;
		int val = 0;
		int[] numArr = new int[n];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = nums[i];
		}
		Arrays.sort(numArr);
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < nums.length-1; i++) {
			System.out.println(nums[i]);
			int count = 0;
			int j =0;
			while (numArr[j]<nums[i]) {
				System.out.println(numArr[j]+","+nums[i]);
				count+=1;
				j+=1;
			}
			output.add(count);
		}
		output.add(0);
		return output;

    }

}

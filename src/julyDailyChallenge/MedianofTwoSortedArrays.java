package julyDailyChallenge;

import java.util.Arrays;       

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		Arrays.sort(nums1);
		double x = (n1%2 ==0)?(nums1[n1/2-1]+nums1[n1/2])/2:nums1[n1/2];
		
		int n2 = nums2.length;
		Arrays.sort(nums2);
		double y = (n2%2 ==0)?(nums2[n2/2-1]+nums2[n2/2])/2:nums2[n2/2];
		
		
		return (x+y)/2;
        
    }

}

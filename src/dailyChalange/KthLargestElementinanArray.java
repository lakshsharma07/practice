package dailyChalange;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {3,2,3,1,2,4,5,5,6};
		 System.out.println(findKthLargest(nums,4)); 
	}
	
	public static int findKthLargest(int[] nums, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
			if (pq.size()>k) {
				pq.poll();
			}
		}
		return pq.peek();
        
    }
	
	
	public int findKthLarges1t(int[] nums, int k) {
        Arrays.sort(nums);
		return nums[nums.length- k];
    }

}

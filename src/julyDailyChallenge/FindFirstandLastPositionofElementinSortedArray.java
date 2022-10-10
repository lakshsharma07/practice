package julyDailyChallenge;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		int target = 1;
		searchRange(nums,  target);
	}
	
	public static int[] searchRange(int[] nums, int target) {
		int low = 0;
		int high = nums.length-1;
		int mid = 0;
		int[] res = {-1,-1};
		while (high>=low) {
			mid= (low+high)/2;
			if (nums[mid] == target) {
				low = high = mid;
				while (low>=0 && nums[low]== target) {
					low--;
				}
				res[0] = low+1;
				while (high<=nums.length-1 && nums[high]== target) {
					high++;
				}
				res[1] = high-1;
				break;
			}
			else if (nums[mid]<target) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		System.out.println(res[0] + " , "+ res[1]);
		return res;
        
    }

}

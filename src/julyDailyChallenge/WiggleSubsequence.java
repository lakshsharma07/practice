package julyDailyChallenge;

public class WiggleSubsequence {

	public static void main(String[] args) {
		int[] nums = {1,7,4,9,2,5};
		//int[] nums  = {3,3,3,2,5};
		//int[] nums = {1, 7, 4, 5, 5};
		System.out.println(wiggleMaxLength(nums)); 

	}
	
	
	public static int wiggleMaxLength(int[] nums) {
		int count = nums.length;
		if (count <=1) {
			return count;
		}
        
		int prev  = 0;
		int curr = 0;
		for (int i = 1; i < nums.length; i++) {
			curr = nums[i]- nums[i-1];
			//System.out.println(prev + " , " + curr);
			if (prev == 0 && curr!=0 ) {
				prev = curr;
				continue;
			}
			if ((prev>0 && curr<0) || (prev<0 && curr>0)  ) {
				prev =curr;
			} else {
				count-=1;
			}
		}
		return count;
  
    }
	
	
	//dynamic
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

}

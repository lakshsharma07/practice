import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		int[] x = {5};
		
		System.out.println(majorityElement(x));
	}
	
	
	public static int majorityElement(int[] nums) {
		
		Map<Integer, Integer> count = new HashMap<>();
		int num = nums[0]  ;
		for (int i : nums) {
			if (count.containsKey(i)) {
				count.put(i, count.get(i)+1) ;
				if (count.get(i)>nums.length/2) {
					num = i;
				}
			}
			else {
				count.put(i, 1);
			}
		}
	return num;
        
    }
}

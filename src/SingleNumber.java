import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {1,2,1,2,4};
		System.out.println(6^2);
		
		System.out.println(singleNumber1(x));
	}
	
	
	public static int singleNumber(int[] nums) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i : nums) {
			if (!set.add(i)) {
				set.remove(i);
			}
		}	
	return set.iterator().next();
        
    }
	
	public static int singleNumber1(int[] nums) {
        int ans = 0;
        for(int ele : nums) ans ^= ele;
        return ans;
    }

}

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,2,3,3,3,4};
		System.out.println(deleteAndEarn(nums));
	}
	
	public static int deleteAndEarn(int[] nums) {
		int maxEarn = 0;
		int earn ;
		List<Integer> list;
		//Arrays.sort(nums);
		for (int i=0 ; i< nums.length;i++) {
			earn = 0;
			if (nums[i] != nums[i+1]) {
				earn+=nums[i];
				list = Arrays.stream(nums).boxed().collect(Collectors.toList());
				earn = earn(earn,list);
				
				if (maxEarn<earn) {
					maxEarn = earn;
				}
			
			}
			else {
				earn+=nums[i];
			}
		}
		return maxEarn;
        
    }
	
	static int sum = 0;
	private static int  earn(int earn, List<Integer> list) {
		sum+=earn;
		for (int i=1 ; i< list.size();i++) {
			if (list.get(i-1)!=list.get(i)) {
				int num = list.get(i);
				list.remove(i);
				list.remove(num+1);
				list.remove(num-1);
				earn(list.get(i-1), list);
			}
			
			int num = list.get(i);
			sum+=earn;
			
			sum += earn(i, list);
		}
		
		
		
		return sum;		
	}

}

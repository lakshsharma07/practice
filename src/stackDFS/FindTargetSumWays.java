package stackDFS;

import java.util.HashMap;

public class FindTargetSumWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,0};
		int target = 1;
		System.out.println(findTargetSumWays(nums, target));
		
	}
	
	static HashMap<String,Long> mem = new HashMap<String,Long>();
	
    public static long ways(int[] nums,int n,int sum,int S,int pos)
    {
    	System.out.println(pos + " - "+sum);
        if(n==pos)
            return sum==S?1:0;
        String key = Integer.toString(pos) + "*" + Integer.toString(sum);
        if(mem.containsKey(key))
            return mem.get(key);
            
        long val = ways(nums,n,sum+nums[pos],S,pos+1) + ways(nums,n,sum-nums[pos],S,pos+1);
        mem.put(key,val);
        System.out.println(mem);
        return val;
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if(n==0)
            return 0;
        
        return (int)(ways(nums,n,nums[0],S,1) + ways(nums,n,-nums[0],S,1));
    }

	/*
	 * static ArrayList<String> visited = new ArrayList<>(); static Queue<int[]> que
	 * = new LinkedList<>();
	 * 
	 * public static int findTargetSumWays(int[] nums, int target) { int count = 0;
	 * que.add(nums); int[] numsCopy = nums.clone(); while (!que.isEmpty()) { for
	 * (int i = 0; i < nums.length; i++) { numsCopy = que.peek().clone();
	 * numsCopy[i] = +numsCopy[i]; if (!visited.contains(checkString(numsCopy))) {
	 * count += checkSum(numsCopy, target); System.out.println(count); } numsCopy[i]
	 * = -numsCopy[i]; if (!visited.contains(checkString(numsCopy))) { count +=
	 * checkSum(numsCopy, target); System.out.println(count); }
	 * 
	 * } que.poll(); }
	 * 
	 * System.out.println(count); return count;
	 * 
	 * }
	 * 
	 * private static String checkString(int[] nums) { String st = ""; for (int i =
	 * 0; i < nums.length; i++) { st += nums[i]; } System.out.println("checkString "
	 * + st); return st; }
	 * 
	 * private static int checkSum(int[] nums, int target) { int sum = 0; int count
	 * = 0; String st = ""; for (int i = 0; i < nums.length; i++) { if (nums[i] ==
	 * 0) { count += 1; } st += nums[i]; sum += nums[i]; } visited.add(st);
	 * que.add(nums); System.out.println(st + " -> " + sum);
	 * 
	 * if (sum == target && count>0) { return (1 * (int)Math.pow(2, count)); } if
	 * (sum == target) { return 1 ; } return 0; }
	 */

}

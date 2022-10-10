
public class ClimbingStairsMinCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] cost = {10,15,20};
		
		minCostClimbingStairs(cost);

	}
	
public static int minCostClimbingStairs(int[] cost) {
	
	int curr = 0;
	int n = cost.length;
	
    int f = cost[0];
    int s = cost[1];
    
    if(n <= 2) return Math.min(f, s);
    
    for (int i = 2; i < n; i++) {
    	
    	// toatl_cost(stair n) = cost(stair n) + min(total_cost(stair n - 1), total_cost(stair n - 2))
    	curr = cost[i] + Math.min(f, s);
        
        // now for next iteration update the n-2 pointer with n - 1 cost
        f = s;
        // n - 1 with n
        s = curr;
	}
	System.out.println(Math.min(f, s));
	return Math.min(f, s);
        
    }


public int minCostClimbingStairs1(int[] cost) {
    for (int i = 2; i < cost.length; i++) {
        if (cost[i-1] < cost[i-2]) {
            cost[i] = cost[i] + cost[i-1];
        } else {
            cost[i] = cost[i] + cost[i-2];
        }
    }
    
    if(cost[cost.length-1] < cost[cost.length-2]) return cost[cost.length-1];
    return cost[cost.length-2];
}



}

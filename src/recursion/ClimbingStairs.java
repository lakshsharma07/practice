package recursion;

public class ClimbingStairs {

	public static void main(String[] args) {
		int s = 5;
		System.out.println("Number of ways = " + climbStairs(s));
		System.out.println("Number of ways = " + climbStairs2(s));
	}

	public static int climbStairs(int n) {

		int num1 = 1;
		int num2 = 1;
		int temp = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			for (int i = 2; i <= n; i++) {
				temp = num1 + num2;
				num1 = num2;
				num2 = temp;
			}
		}
		return num2;

	}
	
	static int[] arr = new int[45];
	static int res ;
	public static int climbStairs2(int n) {
		
		if (arr[n] != 0) {
			return arr[n];
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n>2) {
		 res = climbStairs(n-1) + climbStairs(n-2);
		}
		arr[n] = res;
		
		return res;

	}
}

class Stairs {

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int s = 5;
        System.out.println("Number of ways = " + climbStairs(s));
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
 
}
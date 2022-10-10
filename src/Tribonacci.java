
public class Tribonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tribonacci(25));
	}
	public static int tribonacci(int n) {
		int[] arr = new int[38];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
			if (i==n) {
				return arr[n];
			}
		}
		return arr[n];
		   
    }
	
	public static int tribonacci1(int n) {
		int num1 = 0;
		int num2 = 1;
		int num3 = 1;
		int temp = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 1;
		}else {
			for (int i = 3; i <= n; i++) {
				temp = num1 + num2 + num3;
				num1 = num2;
				num2 = num3;
				num3 = temp;
			}
		}
		return num3;
		   
    }
	
	
	

}

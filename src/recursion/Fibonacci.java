package recursion;

import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fib2(6));

	}
	//recursion without memorization
	public static int fib(int n) {
		int res = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (n > 1) {
			res = fib(n - 1) + fib(n - 2);
		}
		return res;
	}
	
	//recursion with memorization
	static HashMap<Integer, Integer> cache = new HashMap<>();
	static int res;
	public static int fib3(int n) {
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		if (n > 1) {
			res = fib(n - 1) + fib(n - 2);
			
		}
		cache.put(n, res);
		return res;
	}


	// more efficient solution for this
	public static int fib2(int n) {

		int num1 = 0;
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

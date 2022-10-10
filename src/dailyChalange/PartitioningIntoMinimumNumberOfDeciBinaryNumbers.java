package dailyChalange;

import java.util.Arrays;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n = "32";
		System.out.println(minPartitions1(n));
	}

	public static int minPartitions(String n) {
		int max = 0;
		for (int i = 0; i < n.length(); i++) {
			System.out.println(n.charAt(i) - '0');
			if (n.charAt(i) - '0' == 9)
				return 9;
			max = Math.max(max, (n.charAt(i) - '0'));
		}
		return max;
	}
	
	public static int minPartitions1(String n) {
		int max = 0;
		int x = 0;
		for (int i = 0; i < n.length(); i++) {
			 x = (n.charAt(i) - '0');
			 if (x == 9)
					return 9;
				max = Math.max(max,x);
		}
		return max;
	}

}

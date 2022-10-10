package dailyChalange;

public class MyAtoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = 
				"-91283472332";

		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {
		if (s.length()>0) {
			s = s.strip();
		}
		if (s.length() == 0) return 0;
		
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		
		int sign = 1;
		int i = 0;
		if (s.charAt(0) == 45 || s.charAt(0) == 43) {
			sign = s.charAt(0) == 45 ? -1 : 1;
			i += 1;
		}
		
		double res = 0;
		int n = s.length();

		while (i < n) {
			int ch = s.charAt(i);
			System.out.println(ch-48);
			if (ch > 47 && ch < 58) {
				res = (res * Math.pow(10, 1) + (ch - 48));
				System.out.println(sign*res);
				if (sign*res > max) {
					return  max;
				}
				if (sign*res < min) {
					//return min;
				}
			}
			else {
				return (int) (res*sign);
			}
			i++;
		}
		return (int) (res * sign);
	}

}

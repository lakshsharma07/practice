package dynamicProgramming;

public class NumberofWaystoSelectBuildings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "001101";
		System.out.println(numberOfWays1(s));
	}

	public static long numberOfWays(String s) {
		long count1 = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			//System.out.println(validateString(String.valueOf(s.charAt(i)), s, i+1));
			count1 += validateString(String.valueOf(s.charAt(i)), s, i+1);
			System.out.println("-------");
		}
		return count1;

	}

	static long count = 0;

	public static long validateString(String sub, String s, int index) {
		System.out.println(sub+" , "+ index);
		if (sub.length() >= 3 || index >= s.length()) {
			if (sub.equals("010") || sub.endsWith("101")) {
				return 1;
			} else {
				return 0;
			}
		}

		if (sub.charAt(sub.length() - 1) == s.charAt(index)) {
			return validateString(sub, s, index + 1);
		} else {

			return validateString(sub + String.valueOf(s.charAt(index)), s, index + 1) +validateString(sub, s, index + 1);
		}
	//	return count;
	}
	
	
	public static long numberOfWays1(String s) {
		int x = s.length();
		long count = 0;
		int[] arr0 = new int[x];
		int[] arr1 = new int[x];
		for (int i = 0; i < x; i++) {
			if (i == 0) {
				arr0[i] = s.charAt(i) == '0'? 1:0; 
				arr1[i] = s.charAt(i) == '1'? 1:0; 
					 
			}
			else {
				arr0[i] = s.charAt(i) == '0'?(arr0[i-1]+1):arr0[i-1]; 
				arr1[i] = s.charAt(i) == '1'? (arr1[i-1]+1):arr1[i-1];
			}

		}
		for (int i = 1; i < x-1; i++) {
			
			if (s.charAt(i) == '0') {
				count += arr1[i-1] * (arr1[x-1] -arr1[i]) ;
			}
			else{
				count += arr0[i-1] * (arr0[x-1] -arr0[i]) ;
			}	
		}
		return count;
	}
}

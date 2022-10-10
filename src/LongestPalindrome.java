import java.util.HashMap;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abccccdd";
		/*
		 * for (int i = 0; i < 128; i++) { System.out.println(i +" : "+(char)i); }
		 */
		System.out.println(longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
				if (map.get(s.charAt(i)) == 2) {
					count = count + 2;
					map.remove(s.charAt(i));
				}
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		if (map.size() > 0) {
			count++;
		}

		return count;

	}

	public int longestPalindrome1(String s) {
		int[] map = new int[128];
		for (char c : s.toCharArray()) {
			map[c]++;
		}
		int total = 0;
		boolean hasOdd = false;
		for (int i = 'A'; i <= 'z'; i++) {
			if (map[i] % 2 == 0) {
				total += map[i];
			} else {
				total += map[i] - 1;
				hasOdd = true;
			}
		}
		return hasOdd ? total + 1 : total;
	}

}

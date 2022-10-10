package julyDailyChallenge;

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram1(s, t));

	}

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		Arrays.sort(sChar);
		Arrays.sort(tChar);

		for (int i = 0; i < tChar.length; i++) {
			if (sChar[i] != tChar[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] arr = new int[26];
		int val;
		for (int i : s.toCharArray()) {
			val = i - 'a';
			arr[val] = arr[val] < 1 ? 1 : arr[val] + 1;
		}
		for (int i : t.toCharArray()) {
			val = i - 'a';
			if (arr[val]<1) {
				return false;
			}
			arr[val] = arr[val]-1;
		}
		return true;
	}

}

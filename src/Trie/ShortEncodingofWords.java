package Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingofWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "me","meta", "bell", };
		minimumLengthEncoding(words);
	}

	public static int minimumLengthEncoding(String[] words) {
		Set<String> good = new HashSet(Arrays.asList(words));
		System.out.println(good);
		for (String word : words) {
			for (int k = 1; k < word.length(); ++k) {
				System.out.println(word.substring(k));
				good.remove(word.substring(k));
			}
		}
		System.out.println(good);
		int ans = 0;
		for (String word : good)
			ans += word.length() + 1;
		return ans;

	}

}

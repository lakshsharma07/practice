package julyDailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "ec", "oc", "ceo" };

		System.out.println(wordSubsets(words1, words2));
	}

	public static List<String> wordSubsets(String[] A, String[] B) {
		int[] bmax = count("");
		for (String b : B) {
			int[] bCount = count(b);
			for (int i = 0; i < 26; ++i)
				bmax[i] = Math.max(bmax[i], bCount[i]);
		}

		List<String> ans = new ArrayList();
		search: for (String a : A) {
			int[] aCount = count(a);
			for (int i = 0; i < 26; ++i)
				if (aCount[i] < bmax[i])
					continue search;
			ans.add(a);
		}

		return ans;
	}

	public static int[] count(String S) {
		int[] ans = new int[26];
		for (char c : S.toCharArray())
			ans[c - 'a']++;
		return ans;
	}

}

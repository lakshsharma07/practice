package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = { "a","b", "ab", "ac", "bd", "abc", "abd", "abdd" };

		System.out.println(longestStrChain(words));

	}

	public static int longestStrChain(String[] words) {

        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                System.out.println(prev);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            
            dp.put(word, best);
            res = Math.max(res, best);
            System.out.println(dp);
        }
        return res;

	}
	
	
	 public int longestStrChain1(String[] words) {
	        
	        //sort words by length
		 Arrays.sort(words, (a, b)->a.length() - b.length());

	        //map is required to store the best sequence length for each word
	        Map<String, Integer> map = new HashMap();
	        //final result
	        int res = 0;
	        //iterate over words, because they are sorted we may assume that at each next word
	        //can only increase the sequence
	        for (String word : words) {
	            int cur = 1;
	            //try to remove every char in word one by one, check in the map for every removed char
	            StringBuilder sb = new StringBuilder(word);
	            int N = word.length();
	            for (int i = 0; i < N; i++) {
	                char ch = sb.charAt(i);
	                sb.deleteCharAt(i);
	                //this is our word without char at position i-th
	                String possible = sb.toString();
	                //if we met this word before - get it's sequence count from map, otherwise it's 1
	                if (map.containsKey(possible)) {
	                    cur = Math.max(cur, map.get(possible) + 1);
	                }
	                //this is to restore deleted char for next iteration
	                if (i < N - 1)
	                    sb.insert(i, ch);
	            }
	            //store the best sequence score for this word
	            map.put(word, cur);
	            //update overall result if needed
	            res = Math.max(res, cur);
	        }
	        return res;
	    }


}

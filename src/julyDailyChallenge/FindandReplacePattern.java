package julyDailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class FindandReplacePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		System.out.println(findAndReplacePattern(words, pattern)); 
	}
	
	
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		
		String pat = "";
		for (char ch : pattern.toCharArray()) {
			pat+= ch - 'a';
		}
		System.out.println(pat);
		ArrayList<String> res = new ArrayList<>();
		for (String str : words) {
			if (str.length()!=pattern.length()) {
				continue;
			}
			String pat1 = "";
			for (char ch : str.toCharArray()) {
				pat+= ch - 'a';
			}
			
		}
		
		
		
		return null;
        
    }

}

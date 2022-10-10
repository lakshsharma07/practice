package dailyChalange;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabbbcc";
		//System.out.println((int)'}');
		System.out.println(minDeletions2(s)); 
	}

	public static int minDeletions(String s) {
		s+="}";
		char[] arr = s.toCharArray();
		int[] count = new int[arr.length + 1];
		Arrays.sort(arr);
		int cnt = 1;
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				System.out.println("1 - "+arr[i]);
				cnt += 1;
			} else {
				if (count[cnt] > 0) {
					System.out.println("2 - "+arr[i]);
					while (cnt>0 && count[cnt] > 0) {
						cnt -= 1;
						res += 1;
					}

				}
				System.out.println("3 - "+arr[i]);
				count[cnt] = 1;
				cnt = 1;
			}
		}

		return res;

	}
	
	public static int minDeletions1(String s) {
		//"bbcebab"
		s+="}";
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		HashSet<Integer> seenFrequencies = new HashSet<>();
		int cnt = 1;
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (arr[i - 1] == arr[i]) {
				cnt += 1;
			}
			else {
				while (!seenFrequencies.add(cnt) && cnt>0) {
					cnt-=1;
					res+=1;
				}
				cnt = 1;
			}
			System.out.println(seenFrequencies);
		}
		
		return res;
		
	}
	
	
	
	
	public static int minDeletions2(String s) {
        // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        Arrays.sort(frequency);
        
        int deleteCount = 0;
        // Maximum frequency the current character can have
        int maxFreqAllowed = s.length();
        
        // Iterate over the frequencies in descending order
        for (int i = 25; i >= 0 && frequency[i] > 0; i--) {
        	System.out.println(frequency[i] + " , " +maxFreqAllowed);
            // Delete characters to make the frequency equal the maximum frequency allowed
            if (frequency[i] > maxFreqAllowed) {
                deleteCount += frequency[i] - maxFreqAllowed;
                frequency[i] = maxFreqAllowed;
            }
            // Update the maximum allowed frequency
            maxFreqAllowed = Math.max(0, frequency[i] - 1);
            
        }
		return deleteCount;
	}

}

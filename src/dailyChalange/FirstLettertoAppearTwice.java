package dailyChalange;

public class FirstLettertoAppearTwice {

	public static void main(String[] args) {
		String s ="abccbaacz";
		System.out.println(repeatedCharacter(s)); 
	}
	
	 public static char repeatedCharacter(String s) {
		 int n = s.length();
		 int[] char1 = new int[26];
		 
		 for (int i = 0; i < n; i++) {
			 int ch = s.charAt(i)-'a';
			if (char1[ch] >0) {
				return s.charAt(i);
			}
			char1[ch] = 1;
		}
		 
		 
		return 0;
	        
	    }

}

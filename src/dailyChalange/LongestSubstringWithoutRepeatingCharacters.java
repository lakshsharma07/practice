package dailyChalange;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwwkewt";
		System.out.println(lengthOfLongestSubstring( s)); 
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int count =0 ;
		String sub;
		int a = 0;
		int b = 0;
		for (int i = 0 ; i<s.length();i++) {

			sub = s.substring(a,b);
			System.out.println(sub + " , "+ a + " ," + b);
			if (sub.contains(String.valueOf(s.charAt(i)))) {
				if (count<sub.length()) {
					count = sub.length();
					System.out.println(count);
				}
				a+= sub.indexOf(s.charAt(i))+1;
				b++;
			}
			else {
				b++;
			}
			
		}
		return Integer.max(count,s.substring(a,b).length());
        
    }
	
	 public int lengthOfLongestSubstring2(String s) {
		    
			int count =0 ;
			String sub = "";
			for (int i = 0 ; i<s.length();i++) {
				//System.out.println(sub );
				if (sub.contains(String.valueOf(s.charAt(i)))) {
					if (count<sub.length()) {
						count = sub.length();
					}
					sub = sub.substring(sub.indexOf(s.charAt(i))+1, sub.length())+s.charAt(i);
				}
				else {
					sub+=s.charAt(i);
				}	
			}
			return Integer.max(count,sub.length());
	    }

}

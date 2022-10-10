
public class palindrome {

	public static void main(String[] args) {
		
		int x= 121;

		boolean result = isPalindrome(x);
		System.out.println(result);
		
	}
	
	 public static boolean isPalindrome(int x) {
	       if (x<0 || (x%10 == 0 && x !=0)) {
	    	   return false;
	       }
	       int rev = 0;
	       while (x>rev) {
			rev = rev *10 + (x%10) ;
			x /=10;
			
		}
	       
	       System.out.println(rev+","+x);
	        return x == rev || x == rev/10 ;
	    }
	
}
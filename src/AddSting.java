
public class AddSting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "3876620623801494171";
		String str2 = "6529364523802684779";
		System.out.println(addStrings(str1,str2));

	}
	
	
	 public static String addStrings(String num1, String num2) {
		 if (num1.length()>num2.length()) {
			num2 = String.format("%0"+ (num1.length()-num2.length())+"d%s",0 ,num2); 
			 System.out.println("num2 "+num2);
		} 
		 else if (num1.length()<num2.length()) {
			num1 = String.format("%0"+ (num2.length()-num1.length())+"d%s",0 ,num1); 
			System.out.println("num1 "+num1);
		}
		 
		 char c ='0';
		 long sum = 0;
		 long carry = 0 ;
		 String result = "";
		for (int i = num1.length()-1; i >=0; i--) {
			 long n1 = num1.charAt(i)- c;
			 long n2 = num2.charAt(i)-c;
			
			sum=(n1+n2)+carry;
			carry = sum/10;
			result = (sum%10)+ result;
			
		}
		if (carry!=0) {
			result = carry + result;
		}
		return result;
	        
	    }

	 public String addStrings1(String num1, String num2) {
	        if(num1 == null) return num2;
	        if(num2 == null) return num1;
	        
	        StringBuilder res = new StringBuilder();
	        int carry =0;
	        int p1 = num1.length()-1;
	        int p2 = num2.length()-1;
	        
	        while(p1>= 0 || p2>=0){
	            int digit1 = p1>=0? num1.charAt(p1)-'0': 0;
	            int digit2 = p2>=0? num2.charAt(p2)-'0': 0;
	            int curr = (digit1+digit2+carry)%10;
	            carry = (digit1+digit2+carry)/10;
	            res.append(curr);
	            p1--;
	            p2--;
	        }
	        //done with num1 and num2, just checking if carry is a non-zero value
	        if(carry != 0) res.append(carry);
	        return res.reverse().toString();
	    }
}

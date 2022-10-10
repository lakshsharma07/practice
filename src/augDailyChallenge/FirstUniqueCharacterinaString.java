package augDailyChallenge;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		System.out.println(firstUniqChar( s));
	}
	

    public static int firstUniqChar(String s) {
       int[] arr = new int[26];
       int res = -1; 
        for(int i =0;i<s.length();i++){
            int ch = s.charAt(i)-'a';      
            arr[ch] = arr[ch]+1;
            System.out.println(arr[ch]);
            if(arr[ch]>1){
                return i;
            }  
        }
        return -1;
    }

}

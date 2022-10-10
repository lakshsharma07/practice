package recursion;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(s);
	}

	static int index = 0;

	public static void reverseString(char[] s) {

		while(index < s.length / 2) {
			char temp = s[index];
			s[index] = s[s.length - 1 - index];
			s[s.length - 1 - index] = temp;
			System.out.println(String.valueOf(s));
			index += 1;
		}
	}

}



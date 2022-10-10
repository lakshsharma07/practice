package dynamicProgramming;

public class CountNumberofTexts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "222222222222222222222222222222222222";
		System.out.println(countTexts(s)); 
	}

	static int count = 0;

	public static int countTexts(String pressedKeys) {
		
		if (pressedKeys.length() == 0) {
			count++;
		}
		if (pressedKeys.length()>0) {
			//System.out.println("0 - " +pressedKeys);
			countTexts(pressedKeys.substring(1, pressedKeys.length()));
		}
		if (pressedKeys.length()>1 && pressedKeys.charAt(0) == pressedKeys.charAt(1)) {
			//System.out.println("1 - " +pressedKeys);
			 countTexts(pressedKeys.substring(2, pressedKeys.length()));
		}
		if (pressedKeys.length()>2 && pressedKeys.charAt(0) == pressedKeys.charAt(1) && pressedKeys.charAt(0) == pressedKeys.charAt(2)) {
			//System.out.println("2 - " +pressedKeys);
			countTexts(pressedKeys.substring(3, pressedKeys.length()));
		}
		if ( pressedKeys.length()>3 && (pressedKeys.charAt(0) == '7' || pressedKeys.charAt(0) == '9')) {
			if ( pressedKeys.charAt(0) == pressedKeys.charAt(1) && pressedKeys.charAt(0) == pressedKeys.charAt(2) && pressedKeys.charAt(0) == pressedKeys.charAt(3)) {
				//System.out.println("2 - " +pressedKeys);
				countTexts(pressedKeys.substring(4, pressedKeys.length()));
			}	
		}

		
		
		
		
		return (int) (count%(Math.pow(10,9) + 7));

	}

}

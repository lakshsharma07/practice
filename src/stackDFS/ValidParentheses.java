package stackDFS;
import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {

		String haystack = "(({}[]))";
		boolean result = isValid2(haystack);
		System.out.println(result);

	}
	 public static boolean isValid2(String s) {
	        
		 Stack<Character> stack = new Stack<Character>();
		 	for (char c : s.toCharArray()) {
		 		System.out.println(stack);
		 		if (c == '(')
		 			stack.push(')');
		 		else if (c == '{')
		 			stack.push('}');
		 		else if (c == '[')
		 			stack.push(']');
		 		else if (stack.isEmpty() || stack.pop() != c)
		 			return false;
		 		
		 		
		 	}
		 	return stack.isEmpty();    
		     
		         
		     }

public static boolean isValid(String s) {
	ArrayList<String> par = new ArrayList<>();
	for (String character : s.split("")) {
		if ("({[".contains(character)) {
			par.add(character);
		}else {
			if (par.size()>0) {
				if ((character.charAt(0) == ')' && par.get(par.size()-1).equals("(")) 
						|| (character.charAt(0) == '}' && par.get(par.size()-1).equals("{")) 
						|| (character.charAt(0) == ']' && par.get(par.size()-1).equals("["))) {
					par.remove(par.size()-1);
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}	
	return par.size() == 0;        
    }
}
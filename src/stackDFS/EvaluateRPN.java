package stackDFS;
import java.util.Stack;

public class EvaluateRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		evalRPN(tokens);
	}

	public static int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack();
		int x1 ;
		int x2 ;
		for (String st : tokens) {
			
			switch (st) {
			case ("/"): {
				 x1 = stack.pop();
				 x2 = stack.pop();
				stack.add(x2/x1);
				break;
			}
			case ("*"): {
				stack.add(stack.pop()*stack.pop());
				break;
			}
			case ("+"): {
				stack.add(stack.pop()+stack.pop());
				break;
			}
			case ("-"): {
				x1 = stack.pop();
				x2 = stack.pop();
				stack.add(x2-x1);
				break;
			}
			default:
				stack.add(Integer.parseInt(st));
			}

		}
		System.out.println(stack.peek());

		return stack.peek();

	}

}

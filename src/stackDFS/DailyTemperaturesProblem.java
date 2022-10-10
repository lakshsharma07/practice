package stackDFS;
import java.util.Arrays;
import java.util.Stack;
public class DailyTemperaturesProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {89,62,70,58,47,47,46,76,100,70};
		dailyTemperatures1(arr);
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		
		int[] answer = new int[temperatures.length]  ;
		Arrays.fill(answer,0);
	
		//HashMap<Integer, Integer> ans = new HashMap<>();
	for (int i = 0; i < temperatures.length-1; i++) {
		for (int j = i; j < temperatures.length; j++) {
			if (temperatures[j]>temperatures[i]) {
				answer[i] = j-i;
				break;
			}
		}
	}
	for (int i : answer) {
		System.out.println(i); 
	}
	
	return answer;
        
    }
	
public static int[] dailyTemperatures1(int[] temperatures) {
		
	int[] answer = new int[temperatures.length];
	
	Stack<int[]> st = new Stack();
	int count = 0;
	for (int i = temperatures.length-1; i >=0; i--) {
		count = 0;
		if (st.isEmpty()) {
			st.add(new int[] {i,temperatures[i]});
		}
		else if (st.peek()[1]<= temperatures[i]) {
			while (!st.isEmpty() ) {
				if (st.peek()[1]>temperatures[i]) {
					count = st.peek()[0] - i;
					break;
				}
				st.pop();
			}
			if (st.isEmpty()) {
				count = 0;
			}
			st.add(new int[] {i,temperatures[i]});
			
		} else {
			count = 1;
			st.add(new int[] {i,temperatures[i]});
		}
		answer[i] = count;
			
	}
	for (int i : answer) {
		System.out.println(i); 
	}
	
	return answer;
        
    }


}

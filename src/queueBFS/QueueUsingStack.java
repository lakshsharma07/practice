package queueBFS;

import java.util.ArrayList;

public class QueueUsingStack {

	ArrayList<Integer> data;
	int min;

	public void MinStack() {
		min = Integer.MAX_VALUE;
		data = new ArrayList<>();
	}

	public void push(int val) {
		min = Math.min(min, val);
		data.add(val);
	}

	public void pop() {
		data.remove(data.size() - 1);
		min = Integer.MAX_VALUE;
		for (int n : data)
			min = Math.min(min, n);
	}

	public int top() {
		return data.get(data.size() - 1);

	}

	public int getMin() {
		return min;

	}

	public static void main(String[] args) {
		QueueUsingStack st = new QueueUsingStack();

		String[] cmd = { "MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin" };
		int[][] input = { {}, { -2 }, { 0 }, { -3 }, {}, {}, {}, {} };
		String[] res = new String[cmd.length];

		for (int i = 0; i < cmd.length; i++) {
			if (cmd[i].equals("MinStack")) {
				st.MinStack();
				res[i] = null;
			} else if (cmd[i].equals("push")) {
				st.push(input[i][0]);
				res[i] = null;
			} else if (cmd[i].equals("getMin")) {
				res[i] = String.valueOf(st.getMin());
			} else if (cmd[i].equals("pop")) {
				st.pop();
				res[i] = null;
			} else if (cmd[i].equals("top")) {
				res[i] = String.valueOf(st.top());
			}
			System.out.println(res[i]);

		}
	}

}

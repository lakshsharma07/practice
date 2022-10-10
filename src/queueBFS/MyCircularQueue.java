package queueBFS;
public class MyCircularQueue {

	// store elements
	private static int[] data;
	// a pointer to indicate the start position
	private static int p_start;
	private static int p_end;
	private static int size;

	public static void MyCircularQueue(int k) {
		data = new int[k];
		p_start = -1;
		p_end = -1;
		size = k;
	}

	/**
	 * Insert an element into the queue. Return true if the operation is successful.
	 */
	public static boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}
		if (isEmpty() == true) {
            p_start = 0;
        }
		p_end = (p_end + 1) % size;
        data[p_end] = value;
		return true;
	};

	/**
	 * Delete an element from the queue. Return true if the operation is successful.
	 */
	public static boolean deQueue() {
		if (isEmpty() == true) {
			return false;
		}
		if (p_start == p_end) {
			p_start = p_end = -1; 
			return true;
		}
		p_start = (p_start + 1) % size;
		
		return true;
	}

	/** Get the front item from the queue. */
	public static int Front() {
		if (isEmpty() == true) {
            return -1;
        }
		else{
			return data[p_start];
		}
	}
	
	public static int Rear() {
		
		if (isEmpty() == true) {
            return -1;
        }
		else {
			return data[p_end];
		}
		
	}

	/** Checks whether the queue is empty or not. */
	public static boolean isEmpty() {
		return p_start==-1;
	}
	
	public static boolean isFull() {

		return ((p_end + 1) % size) == p_start;
	}

	public static void main(String[] args) {

		String[] cmd = {"MyCircularQueue","enQueue","enQueue","enQueue","isFull","deQueue","deQueue","enQueue","enQueue","deQueue","deQueue","deQueue","Rear","Front","deQueue"};
		int[][] input = {{3},{1},{2},{3},{},{},{},{3},{5},{},{},{},{},{},{}};
		
		String[] output = new String[cmd.length];
		for (int i = 0; i < cmd.length; i++) {
			System.out.println(i +" "+ cmd[i]);
			if (cmd[i].equalsIgnoreCase("MyCircularQueue")) {
				MyCircularQueue(input[i][0]);
				output[i] = null;
			}else if (cmd[i].equalsIgnoreCase("enQueue")) {
				output[i] = String.valueOf(enQueue(input[i][0]));
			}else if (cmd[i].equalsIgnoreCase("deQueue")) {
				output[i] = String.valueOf(deQueue());
			}
			else if (cmd[i].equalsIgnoreCase("Rear")) {
				output[i] = String.valueOf(Rear());
			}
			else if (cmd[i].equalsIgnoreCase("isFull")) {
				output[i] = String.valueOf(isFull());
			}
			else if (cmd[i].equalsIgnoreCase("Front")) {
				output[i] = String.valueOf(Front());
			}
			System.out.println(output[i]);
			
			System.out.println("p_start " +p_start);
			System.out.println("p_end "+p_end);
			System.out.println("------------");
		}

	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashMap1 {
	private static final int ARR_SIZE = 1000000;
	private static ArrayList[] buckets;

	public MyHashMap1() {
		this.buckets = new ArrayList[ARR_SIZE];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] command = { "MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get" };
		int[][] val = { {}, { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } };

		initiate(command, val);
	}

	public static void initiate(String[] com, int[][] val) {

		MyHashMap1 obj = new MyHashMap1();
		String[] result = new String[com.length];

		for (int i = 0; i < com.length; i++) {
			if (com[i].equals("MyHashMap")) {
				result[i] = null;
			} else if (com[i].equals("put")) {
				obj.put(val[i][0], val[i][1]);
				result[i] = null;
			} else if (com[i].equals("get")) {
				result[i] = String.valueOf(obj.get(val[i][0]));
			} else if (com[i].equals("remove")) {
				obj.remove(val[i][0]);
				result[i] = null;
			}
			System.out.println(result[i]);
			//System.out.println(buckets);
		}
	}

	public void put(int key, int val) {
		Integer _key = Integer.valueOf(key);

		// calc the hashcode
		int hash = _key.hashCode();

		// calc the index
		int index = hash % ARR_SIZE;

		// create a collection to store the item and place the address in the array
		if (this.buckets[index] != null) {
			int flag = 1;
			ArrayList list_ref = this.buckets[index];
			for (int i = 0; i < list_ref.size(); i++) {
				if (((List) list_ref.get(i)).get(0).equals(key)) {
					flag = 0;
					((List) list_ref.get(i)).set(1, val);
				}
			}
			// means key is no there in the list
			if (flag == 1)
				list_ref.add(Arrays.asList(key, val));
		} else {
			ArrayList list_ref = new ArrayList();
			list_ref.add(Arrays.asList(key, val));
			this.buckets[index] = list_ref;
		}

	}

	public int get(int key) {
		Integer _key = Integer.valueOf(key);

		// calc the hashcode
		int hash = _key.hashCode();

		// calc the index
		int index = hash % ARR_SIZE;

		if (this.buckets[index] == null) {
			return -1;
		} else {
			ArrayList list_ref = this.buckets[index];
			// iterate through the list to get the key
			for (int i = 0; i < list_ref.size(); i++) {
				if (((List) list_ref.get(i)).get(0).equals(key)) {
					return (Integer) ((List) list_ref.get(i)).get(1);
				}
			}
		}
		return -1;
	}

	public void remove(int key) {
		Integer _key = Integer.valueOf(key);

		// calc the hashcode
		int hash = _key.hashCode();

		// calc the index
		int index = hash % ARR_SIZE;

		if (this.buckets[index] == null) {
			return;
		} else {
			ArrayList list_ref = this.buckets[index];
			// iterate through the list to get the key
			for (int i = 0; i < list_ref.size(); i++) {
				if (((List) list_ref.get(i)).get(0).equals(key)) {
					list_ref.remove(i);
				}
			}
		}

	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashMap {

	private static ArrayList<Integer> buckets;
	private static ArrayList<Integer> bucketValue;

	public MyHashMap() {
		super();
		this.buckets = new ArrayList<>();
		this.bucketValue = new ArrayList<>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] command = { "MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get" };
		int[][] val = { {}, { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2, 1 }, { 2 }, { 2 }, { 2 } };

		initiate(command, val);
	}

	public static void initiate(String[] com, int[][] val) {

		MyHashMap obj = new MyHashMap();
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
			//System.out.println(bucketValue);
		}
	}

	public void put(int key, int value) {
		if (buckets.contains(key)) {
			bucketValue.set(buckets.indexOf(key), value);
		}else {
			buckets.add(key);
			bucketValue.add(value);
		}
		
	}

	public int get(int key) {
		int value = -1;
			if (buckets.contains(key)) {
				value = bucketValue.get(buckets.indexOf(key));
			}
		return value;
	}

	public void remove(int key) {
		if (buckets.contains(key)) {
			bucketValue.remove(buckets.indexOf(key));
			buckets.remove(buckets.indexOf(key));
		}
		
	}
}


/*
 * private static ArrayList<ArrayList<Integer>> buckets;
 * 
 * public MyHashMap1() { super(); this.buckets = new ArrayList<>(); }
 * 
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * String[] command = { "MyHashMap", "put", "put", "get", "get", "put", "get",
 * "remove", "get" }; int[][] val = { {}, { 1, 1 }, { 2, 2 }, { 1 }, { 3 }, { 2,
 * 1 }, { 2 }, { 2 }, { 2 } };
 * 
 * initiate(command, val); }
 * 
 * public static void initiate(String[] com, int[][] val) {
 * 
 * MyHashMap obj = new MyHashMap(); String[] result = new String[com.length];
 * 
 * for (int i = 0; i < com.length; i++) { if (com[i].equals("MyHashMap")) {
 * result[i] = null; } else if (com[i].equals("put")) { obj.put(val[i][0],
 * val[i][1]); result[i] = null; } else if (com[i].equals("get")) { result[i] =
 * String.valueOf(obj.get(val[i][0])); } else if (com[i].equals("remove")) {
 * obj.remove(0); result[i] = null; } System.out.println(result[i]);
 * System.out.println(buckets); } }
 * 
 * public void put(int key, int value) { Boolean flag = true; for (int i = 0; i
 * < buckets.size(); i++) { if (buckets.get(i).get(0) == key) {
 * buckets.get(i).set(1, value); flag = false; } } if (flag == true) {
 * buckets.add(new ArrayList<>(Arrays.asList(key, value))); }
 * 
 * 
 * }
 * 
 * public int get(int key) { int value = -1;
 * 
 * for (ArrayList<Integer> x : buckets) { if (x.get(0) == key) { value =
 * x.get(1).intValue(); } } return value; }
 * 
 * public void remove(int key) { for (int i = 0; i < buckets.size(); i++) { if
 * (buckets.get(i).get(0) == key) { buckets.remove(i); } } }
 */

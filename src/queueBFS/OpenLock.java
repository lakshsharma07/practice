package queueBFS;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub long start1 = System.nanoTime();
		long start1 = System.currentTimeMillis();
	      
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";

		System.out.println(openLock(deadends, target));
		long end1 = System.currentTimeMillis();     
	      System.out.println("Elapsed Time in milli seconds: "+ (end1-start1)); 
	      
		
	}

	public static int openLock(String[] deadends, String target) {

		Set<String> visited = new HashSet<>();
		Set<String> addedSet = new HashSet<>();

		if (target == null || target.length() == 0)
			return -1;

		Queue<HashMap<String, Integer>> queue = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("0000", 0);
		queue.add(map);
		
		while (!queue.isEmpty()) {
			HashMap<String, Integer> front = queue.poll();
			String x = front.entrySet().iterator().next().getKey();
			Integer y = front.entrySet().iterator().next().getValue();
			if (Arrays.asList(deadends).contains(x))
				continue;
			if (x.equals(target))
				return y;
			if (!visited.contains(x)) {
				for (int i = 0; i < 4; i++) {
					StringBuilder str = new StringBuilder(x);
					str.setCharAt(i,  (char) ((str.charAt(i)-'0' + 1)>9?str.charAt(i)-9 :str.charAt(i) + 1));
					if (!addedSet.contains(str.toString()) && !visited.contains(str.toString())) {
						map = new HashMap<String, Integer>();
						map.put(str.toString(), y + 1);
						queue.add(map);
						addedSet.add(str.toString());
					}

					str = new StringBuilder(x);
					str.setCharAt(i, (char) ((str.charAt(i)-'0' - 1)<0?str.charAt(i) +9 :str.charAt(i) - 1));
					if (!addedSet.contains(str.toString()) && !visited.contains(str.toString())) {
						map = new HashMap<String, Integer>();
						map.put(str.toString(), y + 1);
						queue.add(map);
						addedSet.add(str.toString());
					}
				}
				visited.add(x);
				//System.out.println(visited);
			//	System.out.println(queue);
				//System.out.println("------------------");
			}
		}

		return -1;

	}

}

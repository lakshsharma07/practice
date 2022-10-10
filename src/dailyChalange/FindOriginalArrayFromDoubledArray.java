package dailyChalange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindOriginalArrayFromDoubledArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] changed = {1};
		int[] x = findOriginalArray(changed);
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
	
	 public static int[] findOriginalArray(int[] changed) {
		 int[] res = null;
		 int n = changed.length;
		 if (n %2 != 0) {
			return new int[0];
		}
		 res = new int[n/2];
		 Arrays.sort(changed);
		 ArrayList<Integer> list = new ArrayList<>();
		 HashMap<Integer, Integer> map = new HashMap<>();
		 
		 for (int i = 0; i <n; i++) {
				list.add(changed[i]);
				map.put(changed[i], map.getOrDefault(changed[i],0)+1);
			}
		
		 int x =0;
		 
		 while (!list.isEmpty() || x<n/2) {
			 int val = list.get(0);
			 int dubVal = val*2;
				list.remove(list.indexOf(val));
				System.out.println(val + " - " +list);
			if (!list.contains(dubVal)) {
				return new int[0];
			}
			if (!map.containsKey(dubVal) && map.get(val) != map.get(dubVal)) {
				return new int[0];
			}
			map.remove(dubVal);
			list.remove(list.indexOf(dubVal));
			System.out.println(val + " - " +list);

			res[x] = val;
			x+=1;
			 
		}
		 
		return res;
	        
	    }

}

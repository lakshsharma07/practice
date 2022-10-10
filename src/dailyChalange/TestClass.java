package dailyChalange;

import java.util.HashMap;
import java.util.PriorityQueue;


public class TestClass {
    public static void main(String[] args) {
        
            int N = 9;
            long[] C = {16,14,8,8,12,7,10,15,5};      
            int[] H = {7,14,15,15,7,15,12,11,11};     
            int K = 6;

            long out = maximumSum(N, C, H, K);
            System.out.println(out);
            
  
    }
    static long maximumSum(int N, long[] C, int[] H, int K){
       // Write your code here
        long result = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
        	if (map.containsKey(H[i])) {
				if (map.get(H[i])<C[i]) {
					map.put(H[i],C[i]);
				}
			}
        	else {
        		map.put(H[i],C[i]);
			}
			
		}
        
        if (map.size()<K) {
			return -1;
		}
        
        PriorityQueue<Long> queue = new PriorityQueue<>(K);
        
        for (Integer val : map.keySet()) {
        	queue.add(map.get(val));
        	if (queue.size()>K) {
				queue.poll();
			}
			
		}
        
        System.out.println(queue);
        
        while (queue.size()>0) {
			result+=queue.poll();
		}
        
        return result;
    
    }
}
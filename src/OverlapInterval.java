import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class OverlapInterval {

	public static void main(String[] args) {
		
		int[][] x1 = {{1,4},{0,4}};
		int[][] x2 = {{1,4},{0,1}};
		int[][] x3 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] x4 = {{1,4},{1,4}};
		int[][] x5 = {{1,4},{0,5}};
		int[][] x6 = {{1,3},{2,6},{8,10},{15,18}};
		int[][] x7 = {{1,4},{4,5}};
		int[][] x8 = {{1,2},{1,2},{1,2}};
		int[][] x9 = {{1,2},{2,3},{3,4},{1,3}};
	
//		System.out.println(eraseOverlapIntervals(x1));
//		System.out.println(eraseOverlapIntervals(x2));
//		System.out.println(eraseOverlapIntervals(x3));
//		System.out.println(eraseOverlapIntervals(x4));
//		System.out.println(eraseOverlapIntervals(x5));
//		System.out.println(eraseOverlapIntervals(x6));
//		System.out.println(eraseOverlapIntervals(x7));
//		System.out.println(eraseOverlapIntervals(x8));
		System.out.println(eraseOverlapIntervals(x9));

	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {
		int count = 0;
		int[] currInterval = intervals[0];
		Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
		
		for (int i = 1; i<intervals.length;i++) {
			System.out.println(intervals[i][0]+","+intervals[i][1]);
			if (currInterval[1]<=intervals[i][0]) {
				currInterval = intervals[i];
			} else {
				currInterval[1] = Math.min(currInterval[1], intervals[i][1]);
				count++;
			}
		}

		return count;
        
    }

	
	public static void display(List<int[]> inList) {
		System.out.println("---------");
		for (int[] is : inList) {
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i]+",");
			}
			System.out.println();
		}
	}
	
	 public int eraseOverlapIntervals1(int[][] intervals) {
	        if (intervals.length == 1) return 0;
	        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0],b[0]));
	        int[] currInterval = intervals[0];
	        int res = 0;
	        for (int i = 1; i < intervals.length; i++) {
	            int nextStart = intervals[i][0], nextEnd = intervals[i][1];
	            if (currInterval[1] > nextStart) {
	                currInterval[1] = Math.min(currInterval[1], nextEnd);
	                res++;
	            } else currInterval = intervals[i]; // currEnd <= nextStart
	        }
	        return res;
	    }

}

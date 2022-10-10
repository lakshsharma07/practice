import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class mergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x1 = {{1,4},{0,4}};
		int[][] x2 = {{1,4},{0,1}};
		int[][] x3 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] x4 = {{1,4},{1,4}};
		int[][] x5 = {{1,4},{0,5}};
		int[][] x6 = {{1,3},{2,6},{8,10},{15,18}};
		int[][] x7 = {{1,4},{4,5}};
		int[][] x8 = {{1,2},{1,2},{1,2}};
		int[][] x9 = {{1,2},{2,3},{3,4},{1,3}};
	
		System.out.println(merge(x1));
		System.out.println(merge(x2));
		System.out.println(merge(x3));
		System.out.println(merge(x4));
		System.out.println(merge(x5));
		System.out.println(merge(x6));
		System.out.println(merge(x7));
		System.out.println(merge(x8));
		System.out.println(merge(x9));
	}

	public static int[][] merge(int[][] intervals) {
		LinkedList<int[]> inList = new LinkedList();

		Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
		
		for (int[] interval : intervals) {
			if (inList.isEmpty() || inList.getLast()[1]<interval[0]) {
				inList.add(interval);
			} else {
				inList.getLast()[1] = Math.max(inList.getLast()[1], interval[1]);
			}
		}
		display(inList);

	return inList.toArray(new int[inList.size()][]);
        
    }
	
	public static void display(List<int[]> inList) {
		for (int[] is : inList) {
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i]+",");
			}
			System.out.println();
		}
	}
	
	
	
	public int[][] merge1(int[][] intervals) {
        List<int[]> inList = new ArrayList<>();
		int[] res = null;
		for (int i = 0; i < intervals.length; i++) {
			res = intervals[i];
			for (int j = 0; j <inList.size(); j++) {
				if ((res[0]>= inList.get(j)[0]&& res[0]<=inList.get(j)[1]) || (res[1]>=inList.get(j)[0]&& res[1]<=inList.get(j)[1] ) || (res[0]<inList.get(j)[0] && res[1]>inList.get(j)[1] )) {
					inList.get(j)[0]= (res[0]>= inList.get(j)[0])?inList.get(j)[0]:res[0];
					inList.get(j)[1] = (res[1]>= inList.get(j)[1])?res[1]:inList.get(j)[1];
					res = null;
				}
			}
			if (res != null) {
				inList.add(res);
			}	
		}
		int[][] result = (int[][]) inList.toArray(new int[inList.size()][]);

	return result;
    }
}


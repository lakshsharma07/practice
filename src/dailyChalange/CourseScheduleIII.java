package dailyChalange;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] courses = {{5,5},{4,6},{2,6},{4,7}};
		System.out.println(scheduleCourse1(courses));
	}

	public static int scheduleCourse(int[][] courses) {
		if (courses.length<2) {
			return courses.length;
		}
		
		Arrays.sort(courses, (a, b) -> a[1] - b[1]);
		int days = 0;
		int count = 0;
		for (int i = 0; i < courses.length; i++) {
			System.out.println(courses[i][0] + " , " + courses[i][1]);
			if (courses[i][0]+days<=courses[i][1]) {
				days+=courses[i][0];
				courses[count++] = courses[i];
			}
			else {
				int max_i = i;
				for (int j = 0; j < count; j++) {
					if (courses[j][0]>courses[max_i][0]) {
						max_i = j;
					}
				}
					if (courses[max_i][0] > courses[i][0]) {
	                    days += courses[i][0] - courses[max_i][0];
	                    courses[max_i] = courses[i];
	                }
			}
		}
		return count;

	}
	
	
    public static int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > pq = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
            	pq.offer(c[0]);
                time += c[0];
                System.out.println(pq);
            } else if (!pq.isEmpty() && pq.peek() > c[0]) {
                time += c[0] - pq.poll();
                pq.offer(c[0]);
            }
        }
        return pq.size();
    }
}

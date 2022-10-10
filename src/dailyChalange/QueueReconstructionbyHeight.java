package dailyChalange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] people ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] people = { { 8, 2 }, { 4, 2 }, { 4, 5 }, { 2, 0 }, { 7, 2 }, { 1, 4 }, { 9, 1 }, { 3, 1 }, { 9, 0 },
				{ 1, 0 } };
		int[][] res = reconstructQueue1(people);
		for (int[] x : res) {
			System.out.print(" (" + x[0] + " , " + x[1] + ") ,");
		}
	}

	public static int[][] reconstructQueue1(int[][] people) {

		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> ordered = new LinkedList<>();
		for (int[] p : people)
			ordered.add(p[1], p);

		return ordered.toArray(new int[people.length][2]);
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[1] - b[1]);
		for (int[] i : people) {
			System.out.println(i[0] + " , " + i[1]);
		}

		System.out.println("----");
		int[] temp;
		for (int i = 0; i < people.length; i++) {
			// System.out.println(i);
			int count = 0;
			for (int j = 0; j < people.length; j++) {
				if (people[j][0] >= people[i][0]) {
					count += 1;
				}
				if (count > people[i][1]) {
					temp = people[i];
					people[i] = people[j];
					people[j] = temp;
					i = j;
					break;
				}
			}
			// System.out.println(curr[0] +" , " + curr[1]);
			/*
			 * if (count != curr[1]) { for (int j = i+1; j < people.length; j++) { if
			 * (people[j][0]>=people[i][0] && people[j][1]<people[i][1]) { count+=1; } if
			 * (count == people[i][1]) { temp = people[j]; people[j] = people[i]; people[i]
			 * = temp; count = people[i][1]; i-=1; break; }
			 * 
			 * } }
			 */
			for (int[] x : people) {
				System.out.print(" (" + x[0] + " , " + x[1] + ") ,");
			}
			System.out.println();
		}

		return people;

	}

}

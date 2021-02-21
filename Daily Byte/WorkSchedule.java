/*
You are given an array of interval objects, which each consist of a start time and an end time. Each interval object represents when a particular meeting starts and ends. Return whether or not someone could attend every meeting.

Ex: Given the following intervals...

intervals = [[1, 3], [5, 10]], return true.
Ex: Given the following intervals...

intervals = [[1, 8], [5, 9]], return false.
*/

import java.util.*;

public class WorkSchedule {

	public static boolean isPossible(int [][] interval) {
		int n = interval.length;
		Arrays.sort(interval, (a, b) -> a[0] - b[0]);
		// int [] current = interval[0];
		for (int i=1; i<n; i++) {
			int currentStart = interval[i - 1][0];
			int currentEnd = interval[i - 1][1];
			int nextStart = interval[i][0];
			int nextEnd = interval[i][1];
			if (currentEnd > nextStart)
				return false;
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] interval = new int [n][2];
		for (int [] value : interval) {
			value[0] = sc.nextInt();
			value[1] = sc.nextInt();
		}	
		System.out.println(isPossible(interval));
	}
}
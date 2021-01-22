import java.util.*;

public class MergeIntervals {

	public static int [][] mergeIntervals(int [][] intervals) {
		if (intervals.length <= 1)
			return intervals;
		// sort based on the first number
		Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
		List<int[]> result = new ArrayList<>();
		int [] current = intervals[0];
		result.add(current);
		for (int [] interval : intervals) {
			int currentBeg = current[0];
			int currentEnd = current[1];
			int nextBeg = interval[0];
			int nextEnd = interval[1];
			if (nextBeg <= currentEnd) {
				current[1] = Math.max(currentEnd, nextEnd);
			}
			else {
				current = interval;
				result.add(current);
			}
		}
		return result.toArray(new int [result.size()][]);
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] intervals = new int [n][2];
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				intervals[i][j] = sc.nextInt();
			}
		}
		int [][] result = mergeIntervals(intervals);
		for (int [] res : result) {
			System.out.print(res[0] + " " + res[1] + "\n");
		}
	}
}
import java.util.*;

public class ParentingPartneringReturns {

	public static String possibleSchedule(int [][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int x = 0;
		int y = 0;
		char [] result = new char[intervals.length];
		StringBuilder sb = new StringBuilder();
		for (int [] interval: intervals) {
			if (x <= interval[0]) {
				x = interval[1];
				result[interval[2]] = 'C';
			}
			else if (y <= interval[0]) {
				y = interval[1];
				result[interval[2]] = 'J';
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		for (char ch : result) {
			sb.append(ch);
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int [][] interval = new int [n][3];
			for (int i=0; i<n; i++) {
				interval[i][0] = sc.nextInt();
				interval[i][1] = sc.nextInt();
				interval[i][2] = i;
			}
			System.out.println("Case #" + t + ": " + possibleSchedule(interval));
		}
	}
}
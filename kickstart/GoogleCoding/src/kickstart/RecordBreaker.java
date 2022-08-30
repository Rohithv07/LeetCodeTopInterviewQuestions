/**
 * 
 */
package kickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class RecordBreaker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int[] day = new int[n];
			for (int i = 0; i < n; i++) {
				day[i] = sc.nextInt();
			}
			System.out.println("Case #" + t + ": " + findRecordBreaker(n, day));
		}
	}

	private static int findRecordBreaker(int n, int[] day) {
		if (n == 1) {
			return 1;
		}
		int[] prefix = new int[n + 1];
		prefix[0] = 0;
		for (int i = 1; i <= n; i++) {
			prefix[i] = Math.max(prefix[i - 1], day[i - 1]);
			//System.out.println(prefix[i] + " " + suffix[i]);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			int currentDay = day[i];
			if (i == 0) {
				int nextDay = day[i + 1];
				if (currentDay > nextDay) {
					count++;
				}
			}
			else if (i == n - 1) {
				int previousDay = prefix[i];
				if (currentDay > previousDay) {
					count++;
				}
			}
			else {
				int nextDay = day[i + 1];
				int max = prefix[i];
				if (currentDay > nextDay && currentDay > max) {
					count++;
				}
			}
		}
		return count;
	}
}

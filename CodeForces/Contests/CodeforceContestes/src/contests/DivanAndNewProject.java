package contests;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Jul-2025
 */
public class DivanAndNewProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[][] projects = new int[n][2];
			for (int i = 0; i < n; i++) {
				projects[i][0] = sc.nextInt();
				projects[i][1] = i + 1;
			}
			Arrays.sort(projects, (a, b) -> Integer.compare(b[0], a[0]));

			int[] pos = new int[n + 1];
			long totalTime = 0;

			for (int i = 0; i < n; i++) {
				int dist = i / 2 + 1;
				int p = (i % 2 == 0) ? -dist : dist;
				pos[projects[i][1]] = p;
				totalTime += 2L * Math.abs(p) * projects[i][0];
			}

			System.out.println(totalTime);
			System.out.print("0 ");
			for (int i = 1; i <= n; i++) {
				System.out.print(pos[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
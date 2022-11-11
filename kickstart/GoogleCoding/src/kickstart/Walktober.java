/**
 * 
 */
package kickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class Walktober {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[][] nums = new int[m][n];
			int[] john = new int[n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					nums[i][j] = sc.nextInt();
					if (i == p - 1) {
						john[j] = nums[i][j];
						//System.out.print(john[j] + " ");
					}
				}
			}
			int steps = 0;
			for (int j = 0; j < n; j++) {
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < m; i++) {
					if (i != p - 1) {
						max = Math.max(max, nums[i][j]);
						//System.out.print(max + " ");
					}
				}
				if (max > john[j]) {
					steps += Math.abs(max - john[j]);
				}
			}
			System.out.println("Case #" + t + ": " + steps);
		}
	}
}

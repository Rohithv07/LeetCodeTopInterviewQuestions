/**
 * 
 */
package GoogleKickstart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 * https://stackoverflow.com/questions/10402087/algorithm-for-minimum-manhattan-distance
 *
 */
public class StayingHydrated {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int k = sc.nextInt();
			long [][] grid = new long [k][4];
			for (int i=0; i<k; i++) {
				grid[i][0] = sc.nextLong();
				grid[i][1] = sc.nextLong();
				grid[i][2] = sc.nextLong();
				grid[i][3] = sc.nextLong();
			}
			long [] result = findTheShortest(k, grid);
			System.out.println("Case #" + t + ": " + result[0] + " " + result[1]);
		}
	}

	private static long[] findTheShortest(int k, long[][] grid) {
		if (k == 1) {
			long x = Math.min(grid[0][0], grid[0][2]);
			long y = Math.min(grid[0][1], grid[0][3]);
			return new long[] {x, y};
		}
		long [][] check = new long [2 * k][2];
		int index = 0;
		for (long [] g : grid) {
			check[index][0] = g[0];
			check[index][1] = g[1];
			check[index + 1][0] = g[2];
			check[index + 1][1] = g[3];
			index += 2;
		}
		long [] x = new long [2 * k];
		long [] y = new long [2 * k];
		long x1 = 0;
		long y1 = 0;
		index = 0;
		for (long [] c : check) {
			x[index] = c[0];
			y[index] = c[1];
//			System.out.print(x[index] + " ");
//			System.out.println();
//			System.out.print(y[index] + " ");
			index++;
		}
		Arrays.sort(x);
		Arrays.sort(y);
//		for (int i=0; i<2*k; i++) {
//			System.out.print(x[i] + " " + y[i]);
//			System.out.println();
//		}
		//System.out.println(x[k] + " " + x[k - 1] + " " + y[k] + " " + y[k - 1]);
		x1 = Math.min(x[k], x[k - 1]);
		y1 = Math.min(y[k], y[k - 1]);
		return new long[] {x1, y1};
	}

}

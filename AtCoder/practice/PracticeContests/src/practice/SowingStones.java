/**
 * 
 */
package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class SowingStones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long row = sc.nextLong();
		int cell = sc.nextInt();
		long[][] stone = new long[cell][2];
		for (int i = 0; i < cell; i++) {
			stone[i][0] = sc.nextLong();
		}
		for (int i = 0; i < cell; i++) {
			stone[i][1] = sc.nextLong();
		}
		Arrays.sort(stone, (a, b) -> Long.compare(a[0], b[0]));
		long sum = 0;
		long index = 0;
		for (int i = 0; i < cell; i++) {
			if (sum < stone[i][0] - 1) {
				System.out.println("-1");
				System.exit(0);
			}
			sum += stone[i][1];
			index += stone[i][1] * stone[i][0];
		}
		if (sum != row) {
			System.out.println("-1");
		} else {
			long total = (row * (row + 1) / 2) - index;
			System.out.println(total);
		}

		sc.close();
	}

}

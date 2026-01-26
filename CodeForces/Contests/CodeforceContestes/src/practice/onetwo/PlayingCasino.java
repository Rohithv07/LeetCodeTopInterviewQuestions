/**
 * @author rohithvazhathody
 * @date 8 Jan 2026
 * Project: CodeforceContestes
 * File: PlayingCasino.java
 */

package practice.onetwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class PlayingCasino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			long[][] mat = new long[n][m];
			for (int index1 = 0; index1 < m; index1++) {
				for (int index2 = 0; index2 < n; index2++) {
					mat[index2][index1] = sc.nextLong();
				}
			}
			long totalPoint = findTotalPoint(mat);
			System.out.println(totalPoint);
		}
		sc.close();
	}

	private static long findTotalPoint(long[][] mat) {
		long totalPoint = 0;
		for (long[] m : mat) {
			Arrays.sort(m);
			int length = m.length;
			for (int index = 0; index < length; index++) {
				long currentNum = m[index];
				totalPoint += (-1 * (length - index - 1) * currentNum) + (1 * currentNum * (index));
			}
		}
		return totalPoint;
	}

}

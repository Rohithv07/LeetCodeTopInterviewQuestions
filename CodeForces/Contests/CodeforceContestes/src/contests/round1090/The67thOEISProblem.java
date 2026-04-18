/**
 * @author rohithvazhathody
 * @date 4 Apr 2026
 * Project: CodeforceContestes
 * File: The67thOEISProblem.java
 */

package contests.round1090;

import java.util.Scanner;

/**
 * 
 */
public class The67thOEISProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long [] result = findDistinctGCD(n);
			for (long num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static long[] findDistinctGCD(int n) {
		// TODO Auto-generated method stub
		if (n == 2) {
			return new long [] {1, 2};
		}
		long [] result = new long [n];
		for (int index = 0; index < n; index++) {
			long odd1 = 2L * index + 1L;
			long odd2 = 2L * index + 3L;
			result[index] = odd1 * odd2;
		}
		return result;
	}

}

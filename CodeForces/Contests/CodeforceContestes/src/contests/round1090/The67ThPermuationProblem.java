/**
 * @author rohithvazhathody
 * @date 4 Apr 2026
 * Project: CodeforceContestes
 * File: The67ThPermuationProblem.java
 */

package contests.round1090;

import java.util.Scanner;

/**
 * 
 */
public class The67ThPermuationProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] result = findPermuation(n);
			for (int num : result) {
				System.out.print(num + " ");
			}
		}
		sc.close();
	}

	private static int[] findPermuation(int n) {
		int [] result = new int [3 * n];
		int leftMost = 1;
		int rightMost = 3 * n;
		for (int index = 0; index < n; index++) {
			result[index * 3] = leftMost++;
			result[index * 3 + 1] = rightMost - 1;
			result[index * 3 + 2] = rightMost;
			rightMost -= 2;
		}
		return result;
	}

}

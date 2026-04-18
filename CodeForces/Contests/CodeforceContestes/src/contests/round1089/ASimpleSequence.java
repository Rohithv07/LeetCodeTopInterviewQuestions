/**
 * @author rohithvazhathody
 * @date 29 Mar 2026
 * Project: CodeforceContestes
 * File: ASimpleSequence.java
 */

package contests.round1089;

import java.util.Scanner;

/**
 * 
 */
public class ASimpleSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] result = findResult(n);
			for (int val : result) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findResult(int n) {
		int [] result = new int [n];
		int index = 0;
		while (n > 0) {
			result[index++] = n;
			n--;
		}
		return result;
	}

}

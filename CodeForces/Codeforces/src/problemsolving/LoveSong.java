/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class LoveSong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		String s = sc.next();
		int[] prefixSum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + s.charAt(i - 1) - 'a' + 1;
		}
		while (q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int finalLength = prefixSum[r] - prefixSum[l - 1];
			System.out.println(finalLength);
		}
	}
}

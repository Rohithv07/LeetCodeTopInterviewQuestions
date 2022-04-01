/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class TwoArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			System.out.println(isPossibleTransformation(a, b, n) ? "YES" : "NO");
		}
	}

	private static boolean isPossibleTransformation(int[] a, int[] b, int n) {
		if (n == 1) {
			return b[0] - a[0] == 1 || b[0] - a[0] == 0;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (b[i] - a[i] == 1 || b[i] - a[i] == 0) {
				count++;
			} else {
				return false;
			}
		}
		return count <= n;
	}
}

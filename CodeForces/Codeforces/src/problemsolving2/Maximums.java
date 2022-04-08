/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Maximums {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int[] a = findTheArray(b, n);
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private static int[] findTheArray(int[] b, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			b[i] += max;
			max = Math.max(max, b[i]);
		}
		return b;
	}
}

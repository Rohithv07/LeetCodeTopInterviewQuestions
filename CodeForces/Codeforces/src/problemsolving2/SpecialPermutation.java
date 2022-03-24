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
public class SpecialPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] result = findResult(n, a, b);
			if (result.length == 0) {
				System.out.println(-1);
			} else {
				for (int num : result) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[] findResult(int n, int a, int b) {
		int[] result = new int[n];
		result[0] = a;
		result[n - 1] = b;
		int sequenceStart = n;
		for (int i = 1; i < result.length - 1; i++) {
			while (sequenceStart == a || sequenceStart == b) {
				sequenceStart--;
			}
			result[i] = sequenceStart;
			sequenceStart--;
			//System.out.println(result[i]);
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n / 2; i++) {
			//System.out.println(result[i]);
			min = Math.min(min, result[i]);
		}
		for (int i = n / 2; i < n; i++) {
			//System.out.println(result[i]);
			max = Math.max(max, result[i]);
		}
		if (min == a && max == b) {
			return result;
		}
		return new int[] {};
	}
}

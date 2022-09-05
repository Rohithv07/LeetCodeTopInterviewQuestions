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
public class MaximalContinuousRest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seq = new int[n + n];
		for (int i = 0; i < n; i++) {
			seq[i] = sc.nextInt();
			seq[n + i] = seq[i];
		}

		int continuousRest = 0;
		for (int i = 0; i < seq.length;) {
			int currentCount = 0;
			if (seq[i] == 0) {
				i++;
			} else {
				while (i < seq.length && seq[i] == 1) {
					currentCount++;
					i++;
				}
			}
			continuousRest = Math.max(continuousRest, currentCount);
		}
		System.out.println(continuousRest);
	}
}

/**
 * 
 */
package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class PhoenixAndGold {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int [] w = new int [n];
			int totalSum = 0;
			for (int i = 0; i < n; i++) {
				w[i] = sc.nextInt();
				totalSum += w[i];
			}
			if (totalSum == x) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
				Arrays.sort(w);
				int [] result = new int [n];
				int runningSum = 0;
				int i = 0;
				int index = 0;
				while (i < n) {
					runningSum += w[i];
					if (runningSum == x) {
						runningSum -= w[i];
						runningSum += w[i + 1];
						result[index++] = w[i + 1];
						result[index++] = w[i];
						i += 2;
					}
					else {
						result[index++] = w[i];
						i += 1;
					}
				}
				for (int number : result) {
					System.out.print(number + " ");
				}
				System.out.println();
			}
		}
	}
}

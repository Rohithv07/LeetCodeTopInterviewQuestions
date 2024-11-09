/**
 * 
 */
package practice;

/**
 * 
 */
import java.util.Scanner;

public class GarbageCollection {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		
		int[] r = new int[N + 1];
		int[] q = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			q[i] = scanner.nextInt();
			r[i] = scanner.nextInt();
		}
		int Q = scanner.nextInt();
		for (int j = 0; j < Q; j++) {
			int t = scanner.nextInt();
			int d = scanner.nextInt();

			int q_t = q[t];
			int r_t = r[t];

			if (d % q_t == r_t) {
				System.out.println(d);
			} else {
				int k = (r_t - (d % q_t) + q_t) % q_t;
				int nextCollectionDay = d + k;
				System.out.println(nextCollectionDay);
			}
		}

		scanner.close();
	}
}

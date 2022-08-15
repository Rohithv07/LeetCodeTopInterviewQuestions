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
public class Party {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		while (test-- > 0) {
		int n = sc.nextInt();
		int[] people = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			people[i] = sc.nextInt();
		}
		System.out.println(findMaxDepth(n, people));
		// }
	}

	private static int findMaxDepth(int n, int[] people) {
		int maxDepth = 0;
		for (int i = 1; i <= n; i++) {
			int currentDepth = 0;
			int manager = people[i];
			while (manager != -1) {
				manager = people[manager];
				currentDepth++;
			}
			maxDepth = Math.max(maxDepth, currentDepth);
		}
		return maxDepth + 1;
	}

}

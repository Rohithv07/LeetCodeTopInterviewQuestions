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
public class ContestForRobots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			if (nums[i] == 1 && next == 0) {
				count1++;
			} else if (nums[i] == 0 && next == 1) {
				count2++;
			}
		}
		if (count1 == 0) {
			System.out.println(-1);
		} else {
			System.out.println((count1 + count2) / count1);
		}
	}
}

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
public class ChipsMoving {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] % 2 != 0) {
				count++;
			}
		}
		System.out.println(Math.min(n - count, count));
	}
}

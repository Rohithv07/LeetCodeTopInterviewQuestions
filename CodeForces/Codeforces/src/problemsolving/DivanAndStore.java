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
public class DivanAndStore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int count = 0;
			for (int number : nums) {
				if (number >= l && number <= r && number <= k) {
					k -= number;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}

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
public class SubsetMex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(getMaxMex(nums, n));
		}
	}

	private static int getMaxMex(int[] nums, int n) {
		int [] count = new int [101];
		for (int i = 0; i < n; i++) {
			count[nums[i]]++;
		}
		int i = 0;
		int j = 0;
		while (count[i] > 0) {
			count[i++]--;
		}
		while (count[j] > 0) {
			count[j++]--;
		}
		return i + j;
	}
}

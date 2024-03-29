/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class DominantPiranha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findDominant(nums, n));
		}
	}

	private static int findDominant(int[] nums, int n) {
		int max = Arrays.stream(nums).max().getAsInt();
		int dominant = -1;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == max && nums[i - 1] < max) {
				dominant = i + 1;
				break;
			}
			if (i < n - 1 && nums[i] == max && nums[i + 1] < max) {
				dominant = i + 1;
				break;
			}
		}
		return dominant;
	}
}

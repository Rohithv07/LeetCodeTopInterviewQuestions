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
public class GrowTheTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		long firstHalf = 0;
		long secondHalf = 0;
		int length = n / 2;
		for (int i = 0; i < length; i++) {
			firstHalf += nums[i];
		}
		for (int i = length; i < n; i++) {
			secondHalf += nums[i];
		}
		long result = (firstHalf * firstHalf) + (secondHalf * secondHalf);
		System.out.println(result);
	}
}

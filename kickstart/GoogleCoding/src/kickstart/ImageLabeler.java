/**
 * 
 */
package kickstart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class ImageLabeler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int region = sc.nextInt();
			int group = sc.nextInt();
			double[] nums = new double[region];
			for (int i = 0; i < region; i++) {
				nums[i] = sc.nextDouble();
			}
			Arrays.sort(nums);
			System.out.println("Case #" + t + ": " + findMaxSum(nums, region, group));
		}
	}

	private static double findMaxSum(double[] nums, int region, int group) {
		double result = 0.0;
		int index = region - 1;
		while (group > 1) {
			result += (nums[index--]);
			group--;
		}
		if (index % 2 == 1) {
			double test = (nums[index / 2] + nums[index / 2 + 1]) / 2.0;
			result += test;
		} else {
			result += nums[index / 2];
		}
		return result;
	}
}

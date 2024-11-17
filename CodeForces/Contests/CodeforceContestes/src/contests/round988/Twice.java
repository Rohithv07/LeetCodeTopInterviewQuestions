package contests.round988;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 17-Nov-2024
 */
public class Twice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			int count = 0;
			for (int i = 0; i + 1 < n;) {
				if (nums[i] == nums[i + 1]) {
					count++;
					i += 2;
				} else {
					i++;
				}
			}
			System.out.println(count);
		}
	}

}

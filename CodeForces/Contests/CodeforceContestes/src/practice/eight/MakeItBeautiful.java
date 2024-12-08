package practice.eight;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Dec-2024
 */
public class MakeItBeautiful {

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
			Arrays.sort(nums); // this is not required
			if (nums[0] == nums[n - 1]) {
				System.out.println("NO");
			} else {
				int[] result = new int[n];
				int left = 0;
				int right = n - 1;
				for (int i = 0; i < n; i++) {
					if (i % 2 == 0) {
						result[i] = nums[left++];
					} else {
						result[i] = nums[right--];
					}
				}
				System.out.println("YES");
				for (int num : result) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}

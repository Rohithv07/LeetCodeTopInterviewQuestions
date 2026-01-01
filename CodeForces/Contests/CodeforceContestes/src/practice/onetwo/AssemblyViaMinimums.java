package practice.onetwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Jan-2026
 */
public class AssemblyViaMinimums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int bSize = (n * (n - 1)) / 2;
			int[] nums = new int[bSize];
			for (int index = 0; index < bSize; index++) {
				nums[index] = sc.nextInt();
			}
			int[] result = findInitial(nums, n);
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findInitial(int[] nums, int n) {
		int [] result = new int [n];
		Arrays.sort(nums);
		int x = n - 1;
		int index = 0;
		int resultIndex = 0;
		while (x > 0) {
			result[resultIndex++] = nums[index];
			index += x;
			x--;
		}
		result[resultIndex] = (int)(1e9);
		return result;
	}

}

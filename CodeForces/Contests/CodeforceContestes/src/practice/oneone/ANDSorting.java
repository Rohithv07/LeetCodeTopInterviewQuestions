package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 23-Oct-2025
 */
public class ANDSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums = new int[length];
			int firstDiff = -1;
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextInt();
				if (nums[index] != index) {
					if (firstDiff == -1) {
						firstDiff = nums[index];
					}
					else
						firstDiff &= nums[index];
				}
			}
			System.out.println(firstDiff);
		}
		sc.close();
	}

}

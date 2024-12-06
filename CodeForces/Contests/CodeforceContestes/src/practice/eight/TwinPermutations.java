package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Dec-2024
 */
public class TwinPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				result[i] = n + 1 - nums[i];
			}
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();

		}
		sc.close();
	}

}

/*
 * 1 4 3 2 2 3 4 1
 */

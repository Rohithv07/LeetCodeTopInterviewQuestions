package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 30-Nov-2024
 */
public class LineTrip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMinPetrol(n, x, nums));
		}
		sc.close();
	}

	private static int findMinPetrol(int n, int x, int[] nums) {
		int max = nums[0];
		max = Math.max(max, 2 * (x - nums[n - 1]));
		for (int i = 1; i < n; i++) {
			max = Math.max(max, nums[i] - nums[i - 1]);
		}
		return max;
	}

}

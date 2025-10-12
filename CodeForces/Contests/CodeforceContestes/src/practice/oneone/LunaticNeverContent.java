package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 30-Sept-2025
 */
public class LunaticNeverContent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums = new int[length];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextInt();
			}
			int largestX = findLargestX(nums);
			System.out.println(largestX);
		}
		sc.close();
	}

	private static int findLargestX(int[] nums) {
		int answer = 0;
		for (int index = 0; index < nums.length; index++) {
			answer = findGCD(answer, Math.abs(nums[index] - nums[nums.length - index - 1]));
		}
		return answer;
	}

	private static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

}

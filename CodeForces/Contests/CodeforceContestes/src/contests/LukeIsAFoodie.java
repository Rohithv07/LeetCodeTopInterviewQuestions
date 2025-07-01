package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 29-Jun-2025
 */
public class LukeIsAFoodie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long [] nums = new long [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			System.out.println(findMinimumChange(nums, x, n));
		}
		sc.close();
	}

	private static int findMinimumChange(long[] nums, long x, int n) {
		PairNumber [] pairArray = new PairNumber [n];
		for (int index = 0; index < n; index++) {
			pairArray[index] = new PairNumber(nums[index] - x, nums[index] + x);
		}
		int segment = 0;
		int index = 1;
		long left = pairArray[0].num1;
		long right = pairArray[0].num2;
		for (index = 1; index < n; index++) {
			left = Math.max(left, pairArray[index].num1);
			right = Math.min(right, pairArray[index].num2);
			if (left > right) {
				segment++;
				left = pairArray[index].num1;
				right = pairArray[index].num2;
			}
		}
		return segment;
	}

}

class PairNumber {
	long num1;
	long num2;
	
	public PairNumber(long num1, long num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
}
/**
 * @author rohithvazhathody
 * @date 14 Feb 2026
 * Project: CodeforceContestes
 * File: DifferentialSorting.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class DifferentialSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			Result result = findResult(nums);
			int operation = result.operation;
			System.out.println(operation);
			if (operation > 0) {
				long[][] resultNums = result.result;
				for (int index = 0; index < operation; index++) {
					System.out.println(resultNums[index][0] + " " + resultNums[index][1] + " " + resultNums[index][2]);
				}
			}
		}
		sc.close();
	}

	private static Result findResult(long[] nums) {
		int length = nums.length;
		if (nums[length - 1] < nums[length - 2]) {
			return new Result(-1, null);
		} else if (nums[length - 1] >= 0) {
			int resultOp = length - 2;
			long[][] resultNums = new long[resultOp][3];
			for (int index = 0; index < resultOp; index++) {
				resultNums[index][0] = index + 1;
				resultNums[index][1] = length - 1;
				resultNums[index][2] = length;
			}
			Result result = new Result(resultOp, resultNums);
			return result;
		}
		if (increasingSorted(nums)) {
			return new Result(0, null);
		}
		return new Result(-1, null);
	}

	private static boolean increasingSorted(long[] nums) {
		int length = nums.length;
		for (int index = 0; index + 1 < length; index++) {
			if (nums[index] > nums[index + 1]) {
				return false;
			}
		}
		return true;
	}

}

class Result {
	int operation;
	long[][] result;

	public Result(int operation, long[][] result) {
		this.operation = operation;
		this.result = result;
	}
}

/**
 * 5 -4 2 -1 2
 * 
 * 
 * 
 * 
 */

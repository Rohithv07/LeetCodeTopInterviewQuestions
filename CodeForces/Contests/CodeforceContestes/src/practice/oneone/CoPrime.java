package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Oct-2025
 */
public class CoPrime {

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
			int largestSum = findLargestSum(nums);
			System.out.println(largestSum);
		}
		sc.close();
	}

	private static int findLargestSum(int[] nums) {
		int length = nums.length;
		if (nums[length - 1] == 1) {
			return length * 2;
		}
		int[][] indexMap = new int[1001][2];
		int result = -1;
		for (int index = 0; index < length; index++) {
			indexMap[nums[index]][0] = nums[index];
			indexMap[nums[index]][1] = index + 1;
		}
		for (int index1 = 1; index1 <= 1000; index1++) {
			if (indexMap[index1][0] == 0) {
				continue;
			}
			for (int index2 = index1 + 1; index2 <= 1000; index2++) {
				if (indexMap[index2][0] == 0) {
					continue;
				}
				int val1 = indexMap[index1][0];
				int val2 = indexMap[index2][0];
				int valIndex1 = indexMap[index1][1];
				int valIndex2 = indexMap[index2][1];
				if (findGCD(val1, val2) == 1) {
					result = Math.max(result, valIndex2 + valIndex1);
				}
			}
		}
		return result;
	}

	private static int findGCD(int val1, int val2) {
		if (val2 == 0) {
			return val1;
		}
		return findGCD(val2, val1 % val2);
	}

}

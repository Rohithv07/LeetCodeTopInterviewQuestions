/**
 * @author rohithvazhathody
 * @date 3 Mar 2026
 * Project: CodeforceContestes
 * File: YetAnotherProblemAboutPairsSatisfyingInEquality.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class YetAnotherProblemAboutPairsSatisfyingInEquality {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			long totalPairs = findTotalPair(nums);
			System.out.println(totalPairs);
		}
		sc.close();
	}

	private static long findTotalPair(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		List<Integer> prefixGreater = new ArrayList<>();
		long result = 0;
		int length = nums.length;
		for (int index = 0; index < length; index++ ) {
			int currentNum = nums[index];
			if (currentNum >= index + 1) {
				continue;
			}
			result += findLesserNum(prefixGreater, currentNum, nums);
			prefixGreater.add(index + 1);
		}
		return result;
	}

	private static long findLesserNum(List<Integer> prefixGreater, int currentNum, int[] nums) {
		int left = 0;
		int right = prefixGreater.size() - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (prefixGreater.get(middle) >= currentNum) {
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}
		return left;
	}

}



/*
 * ai < i < aj < j
 * 
 * 1 2 3 4 5 6 7 8
 * 1 1 2 3 8 2 1 4
 * 
 * 1 1 2 3 8 8 8 8
 * 
 * a2 = 1
 * 1 < 2 < 2 < 3
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

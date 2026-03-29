/**
 * @author rohithvazhathody
 * @date 21 Mar 2026
 * Project: CodeforceContestes
 * File: Array.java
 */

package contests.round1087;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Array {

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
			List<Long> maxNumberList = findMaxNumber(nums);
			for (Long maxNumber : maxNumberList) {
				System.out.print(maxNumber + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Long> findMaxNumber(long[] nums) {
		int length = nums.length;
		if (length == 1) {
			return new ArrayList<>(Arrays.asList(0l));
		}
		List<Long> result = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			long currentNum = nums[index];
			int smallerCount = 0;
			int largestCount = 0;
			for (int next = index + 1; next < length; next++) {
				long nextNum = nums[next];
				if (nextNum > currentNum) {
					largestCount++;
				} else if (nextNum < currentNum) {
					smallerCount++;
				}
			}
			long ans = Math.max(largestCount, smallerCount);
			result.add(ans);
		}
		return result;
	}

}
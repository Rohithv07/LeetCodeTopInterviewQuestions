package practice.oneone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Oct-2025
 */
public class NegativesAndPositives {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<Long> nums = new ArrayList<>();
			long totalSum = 0;
			int negatives = 0;
			for (int index = 0; index < n; index++) {
				nums.add(sc.nextLong());
				totalSum += nums.get(index);
				if (nums.get(index) < 0) {
					negatives++;
				}
			}
			long maximumSum = findMaximumSum(nums, negatives, totalSum);
			System.out.println(maximumSum);
		}
		sc.close();
	}

	private static long findMaximumSum(List<Long> nums, int negatives, long totalSum) {
		int length = nums.size();
		Collections.sort(nums, (n1, n2) -> Long.compare(Math.abs(n1), Math.abs(n2)));
		if (negatives % 2 == 0) {
			for (Long num : nums) {
				if (num < 0) {
					totalSum -= num;
					totalSum += Math.abs(num);
				}
			}
		} else {
			if (nums.get(0) > 0) {
				totalSum -= nums.get(0);
				totalSum += -1l * nums.get(0);
			}
			for (int index = 1; index < length; index++) {
				long num = nums.get(index);
				if (num < 0) {
					totalSum -= num;
					totalSum += Math.abs(num);
				}
			}
			// totalSum -= nums.get(0);
		}
		return totalSum;
	}

}

/*
 * -1 10 9 8 7 6
 * 
 * 1 -10 9 8 7 6
 * 
 * 
 */

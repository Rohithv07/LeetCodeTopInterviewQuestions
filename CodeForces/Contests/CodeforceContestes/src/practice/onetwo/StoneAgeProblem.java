/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: StoneAgeProblem.java
 */

package practice.onetwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class StoneAgeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		long [][] nums = new long [n][2];
		for (int index = 0; index < n; index++) {
			nums[index][0] = sc.nextLong();
		}
		List<Long> result = findSums(nums, q, sc);
		for (Long num : result) {
			System.out.println(num);
		}
		sc.close();
		
	}

	private static List<Long> findSums(long[][] nums, int q, Scanner sc) {
		List<Long> result = new ArrayList<>();
		long totalSum = 0;
		for (long []num : nums) {
			totalSum += num[0];
		}
		long queryNum = 1;
		long [] globalUpdate = new long [] {0, -1};
		while (queryNum <= q) {
			int type = sc.nextInt();
			if (type == 1) {
				int index = sc.nextInt();
				long value = sc.nextInt();
				index--;
				if (nums[index][1] > globalUpdate[1]) {
					long oldValue = nums[index][0];
					nums[index][0] = value;
					nums[index][1] = (int)queryNum;
					totalSum += value - oldValue;
				}
				else {
					long oldValue = (long) globalUpdate[0];
					nums[index][0] = value;
					nums[index][1] = (long)queryNum;
					totalSum += (value - oldValue);
				}
				result.add(totalSum);
			}
			else {
				long value = sc.nextInt();
				totalSum = value * nums.length;
				result.add(totalSum);
				globalUpdate[0] = value;
				globalUpdate[1] = queryNum;
			}
			queryNum++;
		}
		return result;
	}

}

package practice.oneooo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 19-Jan-2025
 */
public class HelmetsInNightLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int[] cost = new int[n];
			for (int i = 0; i < n; i++) {
				cost[i] = sc.nextInt();
			}
			System.out.println(findMinCost(nums, cost, n, p));
		}
		sc.close();
	}

	private static long findMinCost(int[] nums, int[] cost, int n, int p) {
		int[][] pair = new int[n][2];
		for (int i = 0; i < n; i++) {
			pair[i][0] = nums[i];
			pair[i][1] = cost[i];
		}
		Arrays.sort(pair, (p1, p2) -> Integer.compare(p1[1], p2[1]));
		long answer = p;
		n--;
		for (int i = 0; i < nums.length && pair[i][1] < p && n > 0; i++) {
			int currentNum = pair[i][0];
			if (n > currentNum) {
				n -= currentNum;
				answer += (long) currentNum * pair[i][1];
			} else {
				answer += (long) n * pair[i][1];
				n = 0;
			}
		}
		if (n != 0) {
			answer += (long) n * p;
		}
		return answer;
	}

}

/**
 * 
 * 2 3 2 1 1 3 4 3 2 6 3 6
 * 
 * (2, 2), (1, 3), (3, 3), (2, 4), (1, 6), (3, 6)
 * 
 * 9 + 4
 * 
 * 
 */

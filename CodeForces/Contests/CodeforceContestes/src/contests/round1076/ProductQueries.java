/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: ProductQueries.java
 */

package contests.round1076;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class ProductQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			List<Integer> possible = findPossible(nums);
			for (int num : possible) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Integer> findPossible(int[] nums) {
		int length = nums.length;
		Set<Integer> found = new HashSet<>();
		for (int num : nums) {
			if (num <= length) {
				found.add(num);
			}
		}
		int[] distance = new int[length + 1];
		Arrays.fill(distance, Integer.MIN_VALUE);
		List<Integer> result = new ArrayList<>();
		bfs(nums, result, distance, found, length);
		return result;
	}

	private static void bfs(int[] nums, List<Integer> result, int[] distance, Set<Integer> found, int length) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> separate = new ArrayList<>();
		if (found.contains(1)) {
			distance[1] = 1;
		}
		for (int num = 2; num <= length; num++) {
			if (found.contains(num)) {
				distance[num] = 1;
				queue.offer(num);
				separate.add(num);
			}
		}
		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int each : separate) {
				long nextPossible = ((long) each) * top;
				if (nextPossible > length) {
					break;
				}
				if (distance[(int) nextPossible] == Integer.MIN_VALUE) {
					distance[(int) nextPossible] = distance[top] + 1;
					queue.offer((int) nextPossible);
				}
			}
		}
		for (int index = 1; index <= length; index++) {
			result.add(distance[index] == Integer.MIN_VALUE ? -1 : distance[index]);
		}
	}

}

/**
 * @author rohithvazhathody
 * @date 5 Jan 2026
 * Project: CodeforceContestes
 * File: VikaAndTheBridge.java
 */

package practice.onetwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */
public class VikaAndTheBridge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int minSteps = findMinSteps(nums, k);
			System.out.println(minSteps);
		}
		sc.close();
	}

	@SuppressWarnings("unchecked")
	private static int findMinSteps(int[] nums, int k) {
		int length = nums.length;
		List<List<Integer>> colorsList = new ArrayList<>();
		for (int index = 0; index <= k; index++) {
			colorsList.add(new ArrayList<>());
			colorsList.get(index).add(0);
		}
		for (int index = 0; index < length; index++) {
			int currentNum = nums[index];
			colorsList.get(currentNum).add(index + 1);
		}
		for (int index = 0; index <= k; index++) {
			colorsList.get(index).add(length + 1);
		}
		int result = Integer.MAX_VALUE;
		PriorityQueue<Integer>[] maxHeap = new PriorityQueue[k + 1];
		for (int index = 0; index <= k; index++) {
			maxHeap[index] = new PriorityQueue<>(Collections.reverseOrder());
		}
		for (int index1 = 1; index1 <= k; index1++) {
			int listSize = colorsList.get(index1).size();
			for (int index2 = 0; index2 < listSize - 1; index2++) {
				int diff = colorsList.get(index1).get(index2 + 1) - colorsList.get(index1).get(index2) - 1;
				maxHeap[index1].add(diff);
			}
			int maxVal = maxHeap[index1].poll();
			if (maxVal % 2 == 0) {
				maxHeap[index1].add(maxVal / 2);
				maxHeap[index1].add((maxVal / 2) - 1);
			} else {
				maxHeap[index1].add(maxVal / 2);
				maxHeap[index1].add((maxVal / 2));
			}
			result = Math.min(result, maxHeap[index1].poll());
		}
		return result;
	}

}

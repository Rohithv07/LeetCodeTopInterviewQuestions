/**
 * @author rohithvazhathody
 * @date 8 Jan 2026
 * Project: CodeforceContestes
 * File: DoraAndSearch.java
 */

package practice.onetwo;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */
public class DoraAndSearch {

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
			int[] boundaries = findBoundary(nums);
			if (boundaries == null) {
				System.out.println(-1);
			} else {
				System.out.println(boundaries[0] + " " + boundaries[1]);
			}
		}
		sc.close();
	}

//	private static int[] findBoundary(int[] nums) {
//		if (nums.length <= 2) {
//			return null;
//		}
//		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
//		for (int num : nums) {
//			minHeap.offer(num);
//			maxHeap.offer(num);
//		}
//		int left = 0;
//		int right = nums.length - 1;
//		while (left < right) {
//			int leftNum = nums[left];
//			int rightNum = nums[right];
//			if (leftNum != minHeap.peek() && rightNum != maxHeap.peek() && rightNum != minHeap.peek()
//					&& leftNum != maxHeap.peek()) {
//				return new int[] { left + 1, right + 1 };
//			}
//			if (leftNum == minHeap.peek()) {
//				left++;
//				minHeap.poll();
//			} else if (leftNum == maxHeap.peek()) {
//				left++;
//				maxHeap.poll();
//			}
//			if (rightNum == maxHeap.peek()) {
//				right--;
//				maxHeap.poll();
//			} else if (rightNum == minHeap.peek()) {
//				right--;
//				minHeap.poll();
//			}
//		}
//
//		return null;
//	}
	
	// without extra space
	private static int[] findBoundary(int[] nums) {
	    int n = nums.length;
	    int left = 0;
	    int right = n - 1;
	    
	    // In a permutation of size n, min is 1 and max is n
	    int currentMin = 1;
	    int currentMax = n;

	    while (left <= right) {
	        if (nums[left] == currentMin) {
	            left++;
	            currentMin++;
	        } else if (nums[left] == currentMax) {
	            left++;
	            currentMax--;
	        } else if (nums[right] == currentMin) {
	            right--;
	            currentMin++;
	        } else if (nums[right] == currentMax) {
	            right--;
	            currentMax--;
	        } else {
	            // Found a segment where neither endpoint is the current min or max
	            return new int[] { left + 1, right + 1 };
	        }
	    }

	    return null;
	}

}

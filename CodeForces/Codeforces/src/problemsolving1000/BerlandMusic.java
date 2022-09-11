/**
 * 
 */
package problemsolving1000;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class BerlandMusic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			String s = sc.next();
			int[] result = findSequence(nums, s, n);
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static int[] findSequence(int[] nums, String s, int n) {
		int[] result = new int[n];
		PriorityQueue<Integer> minHeap0 = new PriorityQueue<>((i, j) -> Integer.compare(nums[i], nums[j]));
		PriorityQueue<Integer> minHeap1 = new PriorityQueue<>((i, j) -> Integer.compare(nums[i], nums[j]));
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '0') {
				minHeap0.offer(i);
			} else {
				minHeap1.offer(i);
			}
		}
		int k = 1;
		while (!minHeap0.isEmpty()) {
			int index = minHeap0.poll();
			result[index] = k++;
		}
		while (!minHeap1.isEmpty()) {
			int index = minHeap1.poll();
			result[index] = k++;
		}
		return result;
	}
}

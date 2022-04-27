/**
 * 
 */
package starters;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class BuyingSweets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int[] rupees = new int[n];
			for (int i = 0; i < n; i++) {
				rupees[i] = sc.nextInt();
			}
			System.out.println(maxSweet(n, r, nums, rupees));

		}
	}

	// giving TLE
	private static int maxSweet(int n, int r, int[] nums, int[] rupees) {
		int maxSweetCount = 0;
		Pair[] pair = new Pair[n];
		for (int i = 0; i < n; i++) {
			pair[i] = new Pair(nums[i] - rupees[i], i);
		}
		Arrays.sort(pair, (p1, p2) -> p1.difference - p2.difference == 0 ? Integer.compare(p1.index, p2.index)
				: Integer.compare(p1.difference, p2.difference));
		for (int i = 0; i < n; i++) {
			int c = nums[pair[i].index];
			if (r >= pair[i].difference) {
				int money = r - c;
				if (money < 0) {
					continue;
				}
				int y = money / pair[i].difference + 1;
				maxSweetCount += y;
				r -= y * pair[i].difference;
			}
		}
//		while (maxHeap.isEmpty() && r > 0) {
//			Pair current = maxHeap.poll();
//			int diff = current.difference;
//			int index = current.index;
//			int price = nums[index];
//			int money = r - price;
//			if (money < 0) {
//				continue;
//			}
//			int y = money / diff + 1;
//			maxSweetCount += y;
//			r -= y * diff;
//		}
		return maxSweetCount;
	}
}

class Pair {
	int difference;
	int index;

	public Pair(int difference, int index) {
		this.difference = difference;
		this.index = index;
	}
}
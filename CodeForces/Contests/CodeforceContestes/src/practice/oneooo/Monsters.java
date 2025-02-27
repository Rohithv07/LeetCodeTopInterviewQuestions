package practice.oneooo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 24-Feb-2025
 */
public class Monsters {

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
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			List<Integer> order = findOrderOfKilling(nums, n, k);
			for (Integer key : order) {
				System.out.print(key + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Integer> findOrderOfKilling(int[] nums, int n, int k) {
//		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> {
//			if (p1.value == p2.value) {
//				return Integer.compare(p1.index, p2.index);
//			}
//			return Integer.compare(p2.value, p1.value);
//		});
		List<Integer> result = new ArrayList<>();
		List<Pair> pairList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] % k == 0 ? k : nums[i] % k;
			pairList.add(new Pair(nums[i], i));
		}
		Collections.sort(pairList, (p1, p2) -> {
			if (p1.value == p2.value) {
				return Integer.compare(p1.index, p2.index);
			}
			return Integer.compare(p2.value, p1.value);
		});
		for (Pair p : pairList) {
			result.add(p.index + 1);
		}
//		for (int i = 0; i < n; i++) {
//			maxHeap.offer(new Pair(nums[i], i));
//		}
//		while (!maxHeap.isEmpty()) {
//			Pair top = maxHeap.poll();
//			top.value -= k;
//			if (top.value <= 0) {
//				result.add(top.index + 1);
//			} else {
//				maxHeap.offer(new Pair(top.value, top.index));
//			}
//		}
		return result;
	}

}

class Pair {
	int value;
	int index;

	Pair(int value, int index) {
		this.value = value;
		this.index = index;
	}
}

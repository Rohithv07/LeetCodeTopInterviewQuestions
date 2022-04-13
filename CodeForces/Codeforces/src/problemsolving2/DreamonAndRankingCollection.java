/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class DreamonAndRankingCollection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findLargestV(nums, n, x));
		}
	}

	private static int findLargestV(int[] nums, int n, int x) {
		int max = findMax(nums);
		boolean[] visited = new boolean[max + x + 1];
		int result = 0;
		for (int num : nums) {
			visited[num] = true;
		}
		for (result = 1; result < visited.length; result++) {
			if (visited[result]) {
				continue;
			}
			else if (!visited[result] && x > 0) {
				visited[result] = true;
				x--;
			}
			else if (!visited[result] && x <= 0) {
				break;
			}
		}
		return result - 1;
	}

	private static int findMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		return max;
	}
}


// 99 1
// 43 92 90 52 17 33 53 16 33 66 75 79 79 86 88 10 81 24 32 89 32 49 89 73 67 38 79 38 55 64 7 86 77 33 36 36 83 94 17 46 58 75 94 76 93 65 2 87 93 9 18 11 8 58 9 45 35 62 22 97 24 42 50 13 80 78 75 92 5 82 17 40 77 4 41 57 65 74 85 95 71 57 26 44 1 5 38 24 100 58 14 3 94 3 49 51 12 70 71

import java.util.*;

public class StoneGame {

	public static int minMoves(int [] nums, int n) {
		if (nums == null || n == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int number : nums) {
			min = Math.min(min, number);
			max = Math.max(max, number);
		}
		int minIndex = -1;
		int maxIndex = -1;
		for (int i=0; i<n; i++) {
			if (nums[i] == min) {
				minIndex = i + 1;
			}
			if (nums[i] == max) {
				maxIndex = i + 1;
			}
		}
		int leftRight = n - maxIndex + 1;
		int rightLeft = n - minIndex + 1;
		int leftThenRight = Math.max(leftRight, rightLeft);
		int rightThenLeft = Math.max(maxIndex, minIndex);
		int extra = Math.min(maxIndex + rightLeft, minIndex + leftRight);

		return Math.min(leftThenRight, Math.min(rightThenLeft, extra));
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(minMoves(nums, n));
		}
	}
}
package contests.round994;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Dec-2024
 */
public class MexDestruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(minOperation(nums, n));
		}
		sc.close();
	}

	private static int minOperation(int[] nums, int n) {
		// Arrays.sort(nums);
//		if (nums[0] == 0 && nums[n - 1] == 0) {
//			return 0;
//		}
		int count = 0;
		int previous = 0;
		for (int num : nums) {
			if (previous == 0 && num != 0) {
				count++;
			}
			previous = num;
		}
		return count >= 2 ? 2 : count;
	}

}

// 0 xxxx 0 xxxx 0 xxx 0
// 00000000 111111 0000000

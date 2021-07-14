import java.util.*;

public class FriendsAndCandies {

	public static int minK(int [] nums, int n) {
		if (n == 1)
			return 0;
		boolean same = false;
		for (int i=0; i<n - 1; i++) {
			if (nums[i] == nums[i + 1])
				same = true;
			else {
				same = false;
				break;
			}
		}
		if (same)
			return 0;
		int sum = 0;
		for (int number : nums) {
			sum += number;
		}

		int factor = -1;
		if (sum % n == 0) {
			factor = sum / n;
		}
		if (factor == -1)
			return -1;
		int count = 0;
		for (int number : nums) {
			if (number > factor)
				count += 1;
		}
		return count;
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
			System.out.println(minK(nums, n));
		}
	}
}
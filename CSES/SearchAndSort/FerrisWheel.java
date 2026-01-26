import java.util.*;

public class FerrisWheel {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int limit = sc.nextInt();
		int [] nums = new int [n];
		for (int index = 0; index < n; index++) {
			nums[index] = sc.nextInt();
		}
		int minimumGondolas = findMinimumGondolas(nums, limit);
		System.out.println(minimumGondolas);
	}

	private static int findMinimumGondolas(int [] nums, int limit) {
		Arrays.sort(nums);
		int length = nums.length;
		int count = 0;
		int right = length - 1;
		int left = 0;
		while (left <= right) {
			if (left != right && nums[left] + nums[right] <= limit) {
				left++;
			}
			right--;
			count++;
		}

		return count;
	}
}

/*
10 15
9 8 8 9 10 8 5 8 7 10

 8 8 8 9 9 10 10

2

*/
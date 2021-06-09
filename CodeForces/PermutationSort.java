import java.util.*;
public class PermutationSort {

	public static int minOperation(int [] nums, int n) {
		if (n <= 1)
			return 0;
		int [] clone = nums.clone();
		Arrays.sort(clone);
		int difference = 0;
		for (int i=0; i<n; i++) {
			if (nums[i] != clone[i]) {
				difference += 1;
			}
		}
		if (difference == 0)
			return 0;
		if (nums[0] == 1 || nums[n - 1] == n)
			return 1;
		if (nums[0] == n && nums[n - 1] == 1)
			return 3;
		return 2;
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
			System.out.println(minOperation(nums, n));
		}
	}
}
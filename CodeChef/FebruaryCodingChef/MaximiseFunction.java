import java.util.*;

public class MaximiseFunction {

	public static long maxResult(long [] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		long result = Math.abs(nums[0] - nums[1]) + Math.abs(nums[1] - nums[length - 1]) + Math.abs(nums[length - 1] - nums[0]);
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long [] nums = new long[n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(maxResult(nums));
		}
	}
}
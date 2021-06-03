import java.util.*;

public class MeanInequality {

	public static long [] generateMeanInequality(long [] nums, int n) {
		Arrays.sort(nums);
		long [] result = new long [2 * n];
		int left = 0;
		int right = n;
		int index = 0;
		while (left < n && right < 2 * n) {
			result[index] = nums[left];
			result[index+1] = nums[right];
			left += 1;
			right += 1;
			index += 2;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long [] nums = new long [2 * n];
			for (int i=0; i<2 * n; i++) {
				nums[i] = sc.nextInt();
			}
			long [] result = generateMeanInequality(nums, n);
			for (long number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
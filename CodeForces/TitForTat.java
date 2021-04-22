import java.util.*;

public class TitForTat {

	public static int [] lexicographicallyMinimum(int [] nums, int n, int k) {
		for (int i=0; i<n; i++) {
			while (nums[i] > 0 && k > 0) {
				nums[i] --;
				nums[n - 1] ++;
				k --;
			}
		}
		return nums;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			int [] result = lexicographicallyMinimum(nums, n, k);
			for (int i=0; i<n; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
	}
}
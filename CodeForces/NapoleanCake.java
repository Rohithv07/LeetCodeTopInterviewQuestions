import java.util.*;

public class NapoleanCake {

	public static int [] findResult(int [] nums, int n) {
		int max = 0;
		for (int i=n-1; i>=0; i--) {
			max = Math.max(nums[i], max);
			if (max != 0)
				nums[i] = 1;
			max -= 1;
		}
		return nums;
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
			int [] result = findResult(nums, n);
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		} 
	}
}
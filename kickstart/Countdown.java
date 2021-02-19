import java.util.*;

public class Countdown {

	public static int kCountDown(int [] nums, int k) {
		int length = nums.length;
		int endCounter = 0;
		int result = 0;
		for (int i=1; i<length; i++) {
			if (nums[i - 1] - nums[i] == 1)
				endCounter += 1;
			else
				endCounter = 0;
			if (nums[i] == 1 && endCounter >= k - 1)
				result += 1;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t=1; t<=test; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int [] nums = new int [n];
			for (int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println("Case #" + t + ": " + kCountDown(nums, k));
		}
	}
}
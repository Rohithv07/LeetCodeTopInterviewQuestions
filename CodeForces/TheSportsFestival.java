import java.util.*;

public class TheSportsFestival {

	public static long minDiscrepancySum(long [] nums , int n) {
		if (n == 1)
			return 0;
		Arrays.sort(nums);
		long [][] dp = new long [n][n];
		for (int i=n-1; i>=0; i--) {
			for (int j=i+1; j<n; j++) {
				dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + nums[j] - nums[i];
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long [] nums = new long [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextLong();
		}
		System.out.println(minDiscrepancySum(nums, n));
	}
}
import java.util.*;

public class IncreasingSubstring {

	public static int [] findLength(String s, int n) {
		if (n == 1)
			return new int [] {1};
		int [] dp = new int [n];
		dp[0] = 1;
		for (int i=1; i<n; i++) {
			if (s.charAt(i) > s.charAt(i - 1))
				dp[i] = dp[i - 1] + 1;
			else
				dp[i] = 1;
		}
		return dp;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i=1; i<=test; i++) {
			int n = sc.nextInt();
			String s = sc.next();
			int [] result = findLength(s, n);
			System.out.print("Case #" + i + ": ");
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
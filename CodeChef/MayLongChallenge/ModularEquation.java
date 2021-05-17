import java.util.*;

// (m - (m % b)) % a == 0 gives n^2
// so calculating m % i and incrementing the count with say dp[m % i]
// then the dp array is further updated

class ModularEquation {

	public static long countPair(long n, long m) {
		long count = 0;
		long [] dp = new long [(int)(n + 1)];
		Arrays.fill(dp, 1);
		for (int i=2; i<=n; i++) {
			int value = (int) (m % i);
			count += dp[value];
			for (int j=value; j<=n; j = j + i) {
				dp[j] += 1;
			}
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long m = sc.nextLong();
			System.out.println(countPair(n, m));
		}
	}
}
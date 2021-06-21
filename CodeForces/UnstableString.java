import java.util.*;

public class UnstableString {

	public static long countUnstableString(String s) {
		int [][] dp = new int [][]{{-1, -1}, {-1, -1}};
		long count = 0;
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			int j = i - 1;
			int value = i & 1;
			if (ch != '1') {
				j = Math.min(j, Math.max(dp[0][value ^ 1], dp[1][value]));
			}
			if (ch != '0') {
				j = Math.min(j, Math.max(dp[0][value], dp[1][value ^ 1]));
			}
			count += i - j;
			if (ch != '?') {
				dp[ch - '0'][value] = i;
			}
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test -- > 0) {
			String s = sc.next();
			System.out.println(countUnstableString(s));
		}
	}
}

/*
0 ? 1 0 -> 0 0 1 0 - 3
           0 1 1 0 - 2


*/
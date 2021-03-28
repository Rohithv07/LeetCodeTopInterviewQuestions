import java.util.*;

public class MoonsAndUmbrellas {

	public static int findCost(String s, int x, int y) {
		int length = s.length();
		StringBuilder sb = new StringBuilder(s);
		int sum = 0;
		for (int i=0; i<length - 1; i++) {
			char current = sb.charAt(i);
			char next = sb.charAt(i + 1);
			if (current == 'C' && next == 'J') {
				sum += x;
			}
			else if (current == 'J' && next == 'C') {
				sum += y;
			}
			else if (current == 'C' && next == '?') {
				if (i + 2 < length && sb.charAt(i + 2) == 'J') {
					sb.setCharAt(i + 1, 'J');
					sum += x;
				}
				else if (i + 2 < length && sb.charAt(i + 2) == 'C') {
					sb.setCharAt(i + 1, 'C');
				}
				else if (i + 2 < length && sb.charAt(i + 2) == '?') {
					sb.setCharAt(i + 1, 'C');
				}
			}
			else if (current == 'J' && next == '?') {
				if (i + 2  < length && sb.charAt(i + 2) == 'J') {
					sb.setCharAt(i + 1, 'J');
				}
				else if (i + 2 < length && sb.charAt(i + 2) == 'C') {
					sb.setCharAt(i + 1, 'C');
					sum += y;
				}
				else if (i + 2 < length && sb.charAt(i + 2) == '?') {
					sb.setCharAt(i + 1, 'J');
				}
			}
		}
		return sum;
		// int [] dp = new int [length];
		// for (int i=1; i<length; i++) {
		// 	char left = s.charAt(i - 1);
		// 	char current = s.charAt(i);
		// 	if (current == 'J' && left == 'C') {
		// 		dp[i] = dp[i - 1] + x;
		// 	}
		// 	else if (current == 'C' && left == 'J') {
		// 		dp[i] = dp[i - 1] + y;
		// 	}
		// 	else if (current == '?') {
		// 		dp[i] = dp[i - 1] + Math.min(x, y);
		// 	}
		// 	else {
		// 		dp[i] = dp[i - 1];
		// 	}
		// 	System.out.print(dp[i]+ " ");
		// }
		// return dp[length - 1];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i=1; i<=test; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.next();
			System.out.println("Case #" + i + ": " + findCost(s, x, y));
		}
	}
}
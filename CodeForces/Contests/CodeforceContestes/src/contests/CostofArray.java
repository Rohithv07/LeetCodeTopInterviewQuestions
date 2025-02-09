package contests;

import java.util.*;

public class CostofArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // Number of test cases

		StringBuilder output = new StringBuilder();
		while (T-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			k /= 2; // Halve k as per logic

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			output.append(solve(n, k, a)).append("\n");
		}
		sc.close();
		System.out.print(output);
	}

	private static int solve(int n, int k, int[] a) {
		if (2 * k == n) { 
			for (int i = 1; i < n; i += 2) { 
				if (a[i] != (i + 1) / 2) {
					return (i + 1) / 2;
				}
			}
			return k + 1;
		} else {
			for (int i = 1; i <= n - 2 * k + 1; i++) {
				if (a[i] != 1) {
					return 1;
				}
			}
			return 2;
		}
	}
}

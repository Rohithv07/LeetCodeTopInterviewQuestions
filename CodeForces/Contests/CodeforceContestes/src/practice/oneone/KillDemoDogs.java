package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 20-Oct-2025
 */
public class KillDemoDogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			final long MOD = (long) (1e9 + 7);
			long answer = ((((long) (n) * (long) (n + 1)) % MOD) * ((long) (4 * n - 1) * 337) % MOD) % MOD;
			System.out.println(answer);
		}
		sc.close();
	}

}

// code is submitted in python

/**
 * 
 * 
 * 
 * # Equivalent of KillDemoDogs.java
 * 
 * MOD = int(1e9 + 7)
 * 
 * # Read number of test cases test = int(input())
 * 
 * for _ in range(test): n = int(input()) answer = ((n * (n + 1)) % MOD) * ((4 *
 * n - 1) * 337 % MOD) answer %= MOD print(answer)
 * 
 * 
 * 
 **/
/**
 * @author rohithvazhathody
 * @date 24 Feb 2026
 * Project: CodeforceContestes
 * File: CatCycle.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class CatCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			long position = findPosition(n, k);
			System.out.println(position);
		}
		sc.close();
	}

	private static long findPosition(long n, long k) {
		k--;
		long val = n / 2;
		long result = (k + (n % 2) * k / val) % n + 1;
		return result;
	}

}


/*
 * 
 * n = 3
 * 
 * 3    1
 * 2    3
 * 1    2
 * 3    1
 * 
 * n = 4
 * 
 * 4    1
 * 3    2
 * 2    3
 * 1    4
 * 
 * 
 * n = (5+1)/2
 * 
 * 5     1 - 4
 * 4     2 - 2
 * 3     4 - 1
 * 2     5 - 3
 * 1     2 - 1
 * 5     3 - 2
 * 4     5 - 1
 * 3     1 - 2
 * 2     3 - 1
 * 1     4 - 3
 * 5     1 - 4
 * 
 * 
 * 
 */

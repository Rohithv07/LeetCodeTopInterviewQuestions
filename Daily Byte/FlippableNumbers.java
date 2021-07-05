/*
x is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number n, how many numbers x from 1 to n are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

n will be in range [1, 10000].
*/

import java.util.*;

public class FlippableNumbers {

	public static int flippable(int n) {
		if (n < 2) 
			return 0;
		int count = 0;
		int [] dp = new int [n + 1];
		// dp[i] = 0 - invalid
		// dp[i] = 1 - valid and same
		// dp[i] = 2 - valid and same after rotation
		for (int i=0; i<=n; i++) {
			if (i < 10) {
				if (i == 1 || i == 0 || i == 8) {
					dp[i] = 1;
				}
				else if (i == 2 || i == 5 || i == 6 || i == 9) {
					dp[i] = 2;
					count ++;
				}
			}
			else {
				int quotient = dp[i / 10];
				int remainder = dp[i % 10];
				if (quotient == 1 && remainder == 1) {
					dp[i] = 1;
				}
				else if (quotient >= 1 && remainder >= 1) {
					dp[i] = 2;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(flippable(n));
	}
}
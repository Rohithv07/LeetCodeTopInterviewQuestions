/*
Given two integers, N and start, return the result of applying the XOR operation to N values beginning from start.
Note: Each value that is calculated should be formed as follows: start + 2 * i (where i is the ith value you're calculating).

Ex: Given the following N and start…

N = 3, start = 0, return 6 (0 ^ 2 ^ 4 = 6).
Ex: Given the following N and start…

N = 5, start = 3, return 3.
*/

import java.util.*;

public class XORValues {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = sc.nextInt();
		int xor = 0;
		for (int i=start; i<n; i++) {
			xor ^= start;
			start += 2 * i;
		}
		System.out.println(xor);
	}
}
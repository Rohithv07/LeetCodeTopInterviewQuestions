/*
Given a binary array (i.e. an array containing only zeroes and ones), bits, return the length of the longest streak of ones after deleting one element from the given bits.

Ex: Given the following bits…

bits = [0, 1, 1, 0, 1], return 3.
Ex: Given the following bits…

bits = [1, 1, 1, 1, 1], return 4.

0 1 1 0 1

1 1 0 1 - 2
0 1 0 1 - 1
0 1 0 1 - 1
0 1 1 1 - 3
0 1 1 0 - 2
*/

import java.util.*;

public class OneBits {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		int countZero = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			int currentCount = 0;
			for (int j=0; j<n; j++) {
				if (i == j)
					continue;
				if (nums[j] == 1) {
					currentCount += 1;
				}
				else {
					countZero = Math.max(countZero, currentCount);
					currentCount = 0;
				}
			}
			countZero = Math.max(countZero, currentCount);
		}
		System.out.println(countZero);
	}
}
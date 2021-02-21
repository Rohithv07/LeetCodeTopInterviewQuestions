/*
You are given two integer arrays top and bottom that represent the top and bottom halves of dominoes respectively. Return the minimum number of rotations (i.e. the top value becomes the bottom value of the domino and the bottom value becomes the top value of the domino) you need to perform to make all the values in top the same or all the values in bottom the same.
Note: If it is not possible to make all the values in top or bottom the same, return -1.

Ex: Given the following top and bottom...

top = [2,1,2,4,2,2], bottom = [5,2,6,2,3,2], return 2.
We can rotate the second and fourth dominoes to make all values in the top row of our dominoes equal.
*/


import java.util.*;

public class MinimumRotations {

	public static int minDominoRotation(int [] a, int [] b) {
		int swap = Math.min(numberOfSwap(a[0], a, b), numberOfSwap(a[0], b, a));
		swap = Math.min(swap, numberOfSwap(b[0], a, b));
		swap = Math.min(swap, numberOfSwap(b[0], b, a));
		return swap == Integer.MAX_VALUE ? -1 : swap;
	}

	public static int numberOfSwap(int target, int [] a, int [] b) {
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i] != target && b[i] != target) {
				return Integer.MAX_VALUE;
			}
			if (a[i] != target)
				count += 1;
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int [n];
		int [] b = new int [n];
		for (int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i=0; i<n; i++) {
			b[i] = sc.nextInt();
		}
		System.out.println(minDominoRotation(a, b));
	}
}
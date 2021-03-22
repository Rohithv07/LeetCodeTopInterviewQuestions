/*
You are given n pairs of numbers and asked to form a chain. Two pairs of numbers can create a link in the chain if the second number in the first pair is less than the first number in the second pair. Return the length of the longest chain you can form.
Note: You may use the pairs of numbers in any order and the first number in a pair is always less than the second number in a pair.

Ex: Given the following pairs...

pairs = [[3,4], [5, 6], [7, 8]], return 3.
Ex: Given the following pairs...

pairs = [[9, 14], [3, 5], [4, 7]], return 2.
*/

import java.util.*;

class Pair {
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class MaxLengthChain {

	public static int maxLengthChain(Pair [] array) {
		Arrays.sort(array, (a, b) -> a.x - b.x);
		int length = array.length;
		int [] lcs = new int [length];
		for (int i=0; i<length; i++) {
			lcs[i] = 1;
		}
		int max = Integer.MIN_VALUE;
		// longest Increasing subsequence
		for (int i=1; i<length; i++) {
			for (int j=0; j<i; j++) {
				if (array[i].x > array[j].y && lcs[i] < lcs[j] + 1) {
					lcs[i] = lcs[j] + 1;
				}
			}
		}
		for (int number : lcs) {
			max = Math.max(number, max);
		}
		return max;
	}

	public static void main(String [] args) {
		Pair [] array = new Pair[] {
			new Pair(5, 24),
			new Pair(39, 60),
			new Pair(15, 28),
			new Pair(27, 40),
			new Pair(50, 90)
		};
		System.out.println(maxLengthChain(array));
	}
}
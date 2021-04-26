/*
Given a binary array, bits, return the maximum number of contiguous ones within the array.

Ex: Given the following bits…

bits = [1, 0, 1, 1], return 2.
Ex: Given the following bits…

bits = [0, 0, 0], return 0.
*/

import java.util.*;

public class BinaryBits {

	public static int numberOfContiguousOnes(int [] bits, int n) {
		int result = 0;
		int startingIndexOfOne = -1;
		for (int i=0; i<n; i++) {
			if (bits[i] == 1) {
				startingIndexOfOne = i;			
				break;
			}
		}
		if (startingIndexOfOne == -1)
			return 0;
		int pointer = startingIndexOfOne;
		int count = 0;
		while (startingIndexOfOne < n && pointer < n) {
			if (bits[pointer] == 1) {
				count += 1;
				pointer += 1;
			}
			else {
				startingIndexOfOne = pointer;
				pointer += 1;
				count = 0;
			}
			result = Math.max(result, count);
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] bits = new int [n];
		for (int i=0; i<n; i++) {
			bits[i] = sc.nextInt();
		}
		System.out.println(numberOfContiguousOnes(bits, n));
	}
}

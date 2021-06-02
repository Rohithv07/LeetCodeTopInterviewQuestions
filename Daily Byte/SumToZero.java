/*
Given an integer N, return any array that contains N elements who sum to zero.

Ex: Given the following N...

N = 1, return [0] (1 number that sums to zero is 0 itself).
Ex: Given the following N...

N = 2, return [-1, 1] (this is one possible solution).
*/

import java.util.*;

public class SumToZero {

	public static int [] generateSumToZero(int n) {
		int [] result = new int [n];
		if (n % 2 == 0) {
			for (int i=0; i<n; i++) {
				if (i % 2 == 0)
					result[i] = 1;
				else
					result[i] = -1;
			}
		}
		else {
			for (int i=1; i<n; i++) {
				if (i % 2 == 0) {
					result[i] = 1;
				}
				else {
					result[i] = -1;
				}
			}
		}
		return result;
	}

	// follow up, no repeating element in result
	public static int [] generateSumToZeroNoDuplicate(int n) {
		int [] result = new int [n];
		if (n % 2 == 0) {
			int generator = 1;
			for (int i=0; i<n; i++) {
				if (i % 2 == 0) {
					result[i] = generator;
				}
				else {
					result[i] = generator * -1;
					generator ++;
				}
			}
		}
		else {
			int generator = 1;
			for (int i=1; i<n; i++) {
				if (i % 2 != 0) {
					result[i] = generator;
				}
				else {
					result[i] = generator * -1;
					generator += 1;
				}
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result [] = generateSumToZero(n);
		int [] result2 = generateSumToZeroNoDuplicate(n);
		for (int number : result) {
			System.out.print(number + " ");
		}
		System.out.println();
		for (int number : result2) {
			System.out.print(number + " ");
		}
	}
}
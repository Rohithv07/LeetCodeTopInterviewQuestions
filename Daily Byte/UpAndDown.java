/*
You are given a string, s, where each character in the string is either 'U' (Up) or 'D' (Down). Return any permutation of an array, A, such that for every index in the array where s[i] == U then A[i] < A[i + 1] and for every index where s[i] == D then A[i] > A[i + 1].

Ex: Given the following string s…

s = "UD", you could return [0, 2, 1] (0 is less than 1, 2 is greater than 1).
Ex: Given the following string s…

s = "DUU", you could return [3,0,1,2]
*/


import java.util.*;

public class UpAndDown {

	public static int [] findPermutation(String s) {
		if (s == null || s.length() == 0)
			return new int [] {-1};
		int [] result = new int [s.length() + 1];
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'U') {
				if (result[i] < result[i + 1])
					continue;
				else if (result[i] >= result[i + 1]) {
					result[i + 1] = result[i] + 1;
				}
				// else {
				// 	// int diff = result[i] - result[i + 1];
				// 	// result[i + 1] = result[i + 1] + diff + 1;
				// 	result[i + 1] = result[i] + 1;
				// }
			}
			else {
				if (result[i] > result[i + 1])
					continue;
				else if (result[i] <= result[i + 1]) {
					result[i + 1] = result[i] - 1;
				}
				// else {
				// 	// int diff = result[i + 1] - result[i];
				// 	// result[i + 1] = result[i + 1] - diff + 1;
				// 	result[i + 1] = result[i] - 1;
				// }
			}
		}
		return result;

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int [] result = findPermutation(s);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
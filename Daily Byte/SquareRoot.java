/*
Given a non-negative integer x, return its square root.
Note: You may not use a built in square root function and decimals should be truncated to return an integer value.

Ex: Given the following x...

x = 9, return 3.
Ex: Given the following x...

x = 12, return 3.
*/

import java.util.*;


public class SquareRoot {

	public static int findSquareRoot(int number) {
		if (number == 0 || number == 1)
			return 0;
		int start = 1;
		int end = number;
		int answer = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid * mid == number)
				return mid;
			if (mid * mid < number) {
				start = mid + 1;
				answer = mid;
			}
			else
				end = mid - 1;
		}
		return answer;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(findSquareRoot(number));
	}
}
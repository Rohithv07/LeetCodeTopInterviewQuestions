/*
You are given an array of integers, nums, that only contains values between one and nums.length (inclusive). Within nums, some values appear once and some values appear twice. Return a list containing all numbers between one and nums.length that are missing.

Ex: Given the following nums...

nums = [1, 2, 3, 3], return [4].
Ex: Given the following nums...

nums = [3, 2, 4, 1, 5], return [].
*/

import java.util.*;

public class MissingNumbers {

	public static List<Integer> possibleMissingList(int [] num) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(num);
		for (int i=0; i<num.length; i++) {
			if (i+1 != num[i])
				result.add(i+1);
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] num = new int [n];
		for (int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		System.out.println(possibleMissingList(num));
	}
}
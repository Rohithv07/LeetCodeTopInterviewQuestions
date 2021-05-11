/*
You are given two integer arrays, A and B. B is an anagram of A meaning that B contains all the same elements of A but in a different order. Return an array that represents a mapping from every element in A to which index it occurs at in B.
Note: You may assume every element in A is unique.

Ex: Given the following A and B…

A = [8, 23, 2], B = [2, 23, 8], return [2, 1, 0] (8 appears at index 2 in B, 23 appears at index 1 in B, and 2 appears at index 0 in B).
Ex: Given the following A and B…

A = [9, 3, 1, 5, 2, 4], B = [2, 5, 1, 3, 4, 9], return [5,3,2,1,0,4].
*/

import java.util.*;

public class AnagramElements {

	public static int [] mapTheIndex(int [] nums1, int [] nums2, int n) {
		if (n == 1) {
			return new int [] {0};
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<n; i++) {
			map.put(nums2[i], i);
		}
		int [] result = new int [n];
		int index = 0;
		for (int number : nums1) {
			result[index++] = map.get(number);
		}
		return result;
	}	

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums1 = new int [n];
		int [] nums2 = new int [n];
		for (int i=0; i<n; i++) {
			nums1[i] = sc.nextInt();
		}
		for (int i=0; i<n; i++) {
			nums2[i] = sc.nextInt();
		}
		int [] result = mapTheIndex(nums1, nums2, n);
		for (int number : result) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}

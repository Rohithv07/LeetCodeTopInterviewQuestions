/*
You are given two integer arrays, nums1 and nums2, and asked to sort them in a particular order. The elements in nums2 are distinct and all occur within nums1. Sort the elements of nums1such that the relative ordering of values are the same as nums2. All elements that don’t appear in nums2 should appear at the end of nums1 in ascending order.
Note: It is guaranteed that no value within nums1 and nums2 exceeds one thousand.

Ex: Given the following nums1 and nums2…

nums1 = [3, 2, 5, 8, 2, 7], nums2 = [7, 8, 3], return [7, 8, 3, 2, 2, 5] (7, 8, and 3 appear first because of their ordering in nums2 followed by 2 and 5 sorted in ascending order since they don't exist in nums2).
*/


import java.util.*;

public class SortNumbers {

	public static int [] sortByRelativeOrder(int [] arr1, int [] arr2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		// count the occurace of arr1
		for (int number : arr1) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		// sort based on arr2
		int index = 0;
		for (int number : arr2) {
			for (int j=0; j<map.get(number); j++) {
				arr1[index++] = number;
			}
			// done with the current number, then remove it
			map.remove(number);
		}
		// continue with the remaining from the treemao
		for (int key : map.keySet()) {
			for (int j=0; j<map.get(key); j++) {
				arr1[index++] = key;
			}
		}
		return arr1;

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int [] arr1 = new int [n1];
		int [] arr2 = new int [n2];
		for (int i=0; i<n1; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i=0; i<n2; i++) {
			arr2[i] = sc.nextInt();
		}
		int [] result = sortByRelativeOrder(arr1, arr2);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
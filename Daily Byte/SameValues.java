/*
Given three integer arrays, nums1, nums2, and nums3, sorted in ascending order, return a list containing all integers that are common to all three arrays.
Note: There are no duplicate values in any of the arrays.

Ex: Given the following nums1, nums2, and nums3…

nums1 = [1, 2, 3], nums2 = [1, 2], nums3 = [1], return [1].
Ex: Given the following nums1, nums2, and nums3…

nums1 = [4, 5, 6], nums2 = [7, 8, 9], nums3 = [10], return [].
*/

import java.util.*;

public class SameValues {

	public static List<Integer> findTheCommonOfThree(int [] nums1, int [] nums2, int [] nums3) {
		// if no duplicates
		/*
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> commonValues = new ArrayList<>();
		for (int number : nums1) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int number : nums2) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int number: nums3) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value == 3)
				commonValues.add(key);
		}
		return commonValues;
		*/
		
/*
		// follow up, what if there are duplicates - have bucks
		Map<Integer, Boolean> map = new HashMap<>();
		List<Integer> commonValues = new ArrayList<>();
		for (int number : nums1) {
			if (!map.containsKey(number))
				map.put(number, false);
		}
		for (int number : nums2) {
			if (map.containsKey(number))
				map.put(number, false);
		}
		for (int number : nums3) {
			if (map.containsKey(number) && map.get(number) == true)
				map.put(number, true);
		}
		for (int key : map.keySet()) {
			Boolean value = map.get(key);
			if (value == true)
				commonValues.add(key);
		}
		return commonValues;
*/
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int [] nums1 = new int [n1];
		int [] nums2 = new int [n2];
		int [] nums3 = new int [n3];
		for (int i=0; i<n1; i++) 
			nums1[i] = sc.nextInt();
		for (int j=0; j<n2; j++) 
			nums2[j] = sc.nextInt();
		for (int k=0; k<n3; k++)
			nums3[k] = sc.nextInt();
		System.out.println(findTheCommonOfThree(nums1, nums2, nums3));
	}
}

/*

Given two integer arrays, nums1 and nums2, return the intersection of the two arrays (i.e. the elements they have in common).

Ex: Given the following nums1 and nums2...

nums1 = [1, 2, 2, 3], nums2 = [0, 2, 2, 5], return [2, 2].

*/

import java.util.*;

public class CommonValues {

	public static List<Integer> getAllCommon(int [] num1, int [] num2) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int num : num1) {
			set.add(num);
		}
		for (int num : num2) {
			if (set.contains(num))
				result.add(num);
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int [] num1 = new int [n1];
		int [] num2 = new int [n2];
		for (int i=0; i<n1; i++) {
			num1[i] = sc.nextInt();
		}
		for (int i=0; i<n2; i++) {
			num2[i] = sc.nextInt();
		}
		System.out.println(getAllCommon(num1, num2));
	}
}
/*
Given an integer array, nums, return the total number of “partners” in the array.
Note: Two numbers in our array are partners if they reside at different indices and both contain the same value.

Ex: Given the following array nums…

nums = [5, 5, 3, 1, 1, 3, 3], return 5.
5 (index 0) and 5 (index 1) are partners.
1 (index 3) and 1 (index 4) are partners.
3 (index 2) and 3 (index 5) are partners.
3 (index 2) and 3 (index 6) are partners.
3 (index 5) and 3 (index 6) are partners.
*/


// brute force
import java.util.*;

public class Partners {

	public static int noOfPartners(int [] nums) {
		int length = nums.length;
		int partners = 0;
		for (int i=0; i<length; i++) {
			for (int j=i+1; j<length; j++) {
				if (nums[i] == nums[j])
					partners += 1;
			}
		}
		return partners;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(noOfPartners(nums));
	}
}
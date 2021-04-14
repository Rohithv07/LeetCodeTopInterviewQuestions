/*Given a string s and an integer array, indices, you must rearrange s according to the given indices. Once you have rearranged s successfully, the ith character in s should now be located at the indices[i] index.
Note: s and indices will always be the same length.

Ex: Given the following s and indices…

s = "abc", indices = [2, 1, 0], return "cba" ('a' moves to the 2nd index, b stays at the first index, and c moves to the zeroth index).

*/


import java.util.*;

public class RearraneString {

	public static String makeTheStringsArranged(String s, int [] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<nums.length; i++) {
			sb.append(s.charAt(nums[i]));
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int [] nums = new int [s.length()];
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(makeTheStringsArranged(s, nums));
	}
}

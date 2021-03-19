/*
Given an integer array, nums that represents the score of a spelling bee’s contestants, return string array that represents each of their respective placings.

Ex: Given the following nums…

nums = [3, 1, 4, 2, 5], return ["Bronze Medal","5","Silver Medal","4","Gold Medal"].
*/

import java.util.*;

public class SpellingBee {

	public static String [] rankThem(int [] nums) {
		int length = nums.length;
		String [] result = new String[length];
		// key will be sorted
		// 1 -> 1, 2 -> 3, 3 ->0, 4 -> 2, 5 -> 4
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i=0; i<length; i++) {
			map.put(nums[i], i);
		}
		for (int key : map.keySet()) {
			int index = map.get(key);
			if (length > 3) {
				result[index] = String.valueOf(length);
			}
			else if (length == 3) {
				result[index] = "Bronze";
			}
			else if (length == 2) {
				result[index] = "Silver";
			}
			else if (length == 1) {
				result[index] = "Gold";
			}
			length --;
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		String [] result = rankThem(nums);
		for (String res : result) {
			System.out.print(res + " ");
		}
	}
}
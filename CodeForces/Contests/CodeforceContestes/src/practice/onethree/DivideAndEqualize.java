/**
 * @author rohithvazhathody
 * @date 27 Feb 2026
 * Project: CodeforceContestes
 * File: DivideAndEqualize.java
 */

package practice.onethree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class DivideAndEqualize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			String convertPossible = findConvertPossible(nums);
			System.out.println(convertPossible);
		}
		sc.close();
	}

	private static String findConvertPossible(int[] nums) {
		Map<Integer, Integer> factorMap = new HashMap<>();
		int length = nums.length;
		for (int num : nums) {
			findPrimeFactors(num, factorMap);
		}
		// we need all the prime factor count % n = 0
		for (Integer key : factorMap.keySet()) {
			int currentCount = factorMap.get(key);
			if (currentCount % length != 0) {
				return "NO";
			}
		}
		return "YES";
	}

	private static void findPrimeFactors(int num, Map<Integer, Integer> factorMap) {
		// find the count of prime 2, it is the only even
		while (num % 2 == 0) {
			factorMap.put(2, factorMap.getOrDefault(2, 0) + 1);
			num /= 2;
		}
		// now all the rest are odd, so we can start from 3 and increase by 2
		for (int index = 3; index * index <= num; index += 2) {
			while (num % index == 0) {
				factorMap.put(index, factorMap.getOrDefault(index, 0) + 1);
				num /= index;
			}
		}
		if (num > 2) {
			factorMap.put(num, factorMap.getOrDefault(num, 0) + 1);
		}
	}

}

/*
 * 8 2 4 2
 * 
 * 2 2 4 8
 * 
 * 
 * 30 50 27 20
 * 
 * 20 27 30 50
 * 
 * 
 * 5 200 10 9
 * 
 * 
 */

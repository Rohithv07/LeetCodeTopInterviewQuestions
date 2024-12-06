package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Dec-2024
 */
public class UnitArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int negative = 0;
			int positive = 0;
			for (int num : nums) {
				if (num < 0) {
					negative++;
				} else {
					positive++;
				}
			}
			int result = 0;
//			if (negative == positive) {
//				System.out.println(result);
//			} else 
			if (negative > positive) {
				int middle = n % 2 == 0 ? n / 2 : n / 2 + 1;
				result = middle - positive;
				positive += result;
				negative = n - positive;
				if (negative % 2 == 0) {
					System.out.println(result);
				} else {
					System.out.println(result + 1);
				}

			} else {
				if (negative % 2 == 0) {
					System.out.println(result);
				} else {
					System.out.println(result + 1);
				}
			}
		}
		sc.close();
	}

}

/*
 * 
 * -1 -1 1 1 1
 * 
 * 3 2
 * 
 * -1 -1 -1 1 1
 * 
 */

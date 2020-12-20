/*Given an integer array nums, return an array where each element i represents the product of all values in nums excluding nums[i].
Note: You may assume the product of all numbers within nums can safely fit within an integer range.

Ex: Given the following array nums…

nums = [1, 2, 3], return [6,3,2].
6 = 3 * 2 (we exclude 1)
3 = 3 * 1 (we exclude 2)
2 = 2 * 1 (we exclude 3)
*/
                
/*[1, 2, 3, 4]
prouct a[0] * a[1] * a[2] * a[3] = 24
p[0] = a[1] * a[2] * a[3] = 24 / a[0] = 24.
p[1] = a[0] * a[2]  * a[3] = 24 / a[1] = 12.
p[2] = 24 / a[2] = 8.
p[3] = 24 / a[3] = 6.
p[i] = product / a[i]

[1,0,3,0]
*/

import java.util.*;

public class Products {
	public static int [] productExceptSelf(int [] nums, int n) {
		if (n == 0)
			return new int [0];
		int [] productArray = new int [n];
		int product = 1;
		int productNonZero = 1;
		int countOfZero = 0;
		for (int number : nums) {
			product *= number;
			if (number == 0)
				countOfZero += 1;
			else
				productNonZero *= number;
		}
		if (product != 0) {
			for (int i=0; i<n; i++) {
				productArray[i] = product / nums[i];
			}
		}
		else {
			if (countOfZero == 1) {
				for (int i=0; i<n; i++) {
					if (nums[i] == 0)
						productArray[i] = productNonZero;
				}
			}
		}
		return productArray;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int [] nums = new int [length];
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		int [] output = productExceptSelf(nums, length);
		for (int number : output)
			System.out.println(number);
	}
}


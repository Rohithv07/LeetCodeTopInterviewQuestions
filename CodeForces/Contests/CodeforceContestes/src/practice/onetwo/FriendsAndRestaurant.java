/**
 * @author rohithvazhathody
 * @date 11 Jan 2026
 * Project: CodeforceContestes
 * File: FriendsAndRestaurant.java
 */

package practice.onetwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class FriendsAndRestaurant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] spent = new int[n];
			int[] budget = new int[n];
			for (int index = 0; index < n; index++) {
				spent[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				budget[index] = sc.nextInt();
			}
			int maxGroup = findMaxGroup(spent, budget);
			System.out.println(maxGroup);
		}
		sc.close();
	}

	private static int findMaxGroup(int[] spent, int[] budget) {
		int groups = 0;
		int length = spent.length;
		int[] diffArray = new int[length];
		for (int index = 0; index < length; index++) {
			diffArray[index] = budget[index] - spent[index];
		}
		Arrays.sort(diffArray);
		int left = 0;
		int right = length - 1;
		while (left < right) {
			if (diffArray[right] + diffArray[left] >= 0) {
				groups++;
				right--;
				left++;
			} else {
				left++;
			}
		}
		return groups;
	}

}

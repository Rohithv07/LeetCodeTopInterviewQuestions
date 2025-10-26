package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 27-Oct-2025
 */
public class YetAnotherCardDeck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] nums = new int[n];
		int[] firstFound = new int[51];
		Arrays.fill(firstFound, -1);
		for (int index = 0; index < n; index++) {
			nums[index] = sc.nextInt();
			if (firstFound[nums[index]] == -1) {
				firstFound[nums[index]] = index + 1;
			}
		}
		int[] queries = new int[q];
		for (int index = 0; index < q; index++) {
			queries[index] = sc.nextInt();
			System.out.print(findPosition(queries[index], firstFound) + " ");
		}
		System.out.println();
		sc.close();
	}

	private static int findPosition(int color, int[] firstFound) {
		int index = 1;
		int foundColor = firstFound[color];
		while (index <= 50) {
			if (firstFound[index] != -1 && firstFound[index] < foundColor) {
				firstFound[index] = firstFound[index] + 1;
			}
			index++;
		}
		firstFound[color] = 1;
		return foundColor;
	}

}

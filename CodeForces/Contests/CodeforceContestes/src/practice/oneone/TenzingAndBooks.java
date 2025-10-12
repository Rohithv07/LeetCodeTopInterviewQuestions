package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 28-Sept-2025
 */
public class TenzingAndBooks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int favorite = sc.nextInt();
			int[] stack1 = new int[length];
			int[] stack2 = new int[length];
			int[] stack3 = new int[length];
			for (int index = 0; index < length; index++) {
				stack1[index] = sc.nextInt();
			}
			for (int index = 0; index < length; index++) {
				stack2[index] = sc.nextInt();
			}
			for (int index = 0; index < length; index++) {
				stack3[index] = sc.nextInt();
			}
			String possibleForFavorite = computeStack(stack1, stack2, stack3, favorite);
			System.out.println(possibleForFavorite);
		}
		sc.close();
	}

	private static String computeStack(int[] stack1, int[] stack2, int[] stack3, int favorite) {
		if (favorite == 0) {
			return "YES";
		}
		long currentRating = 0;
		for (int index = 0; index < stack1.length; index++) {
			if ((favorite | stack1[index]) != favorite) {
				break;
			}
			currentRating |= stack1[index];

		}
		for (int index = 0; index < stack1.length; index++) {
			if ((favorite | stack2[index]) != favorite) {
				break;
			}
			currentRating |= stack2[index];

		}
		for (int index = 0; index < stack3.length; index++) {
			if ((favorite | stack3[index]) != favorite) {
				break;
			}
			currentRating |= stack3[index];

		}
		return currentRating != favorite ? "NO" : "YES";
	}

}

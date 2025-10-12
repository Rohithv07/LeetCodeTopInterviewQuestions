package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 28-Sept-2025
 */
public class CardboardForPictures {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			long square = sc.nextLong();
			int[] nums = new int[length];
			for (int index = 0; index < length; index++) {
				nums[index] = sc.nextInt();
			}
			long w = findW(square, nums);
			System.out.println(w);
		}
		sc.close();
	}

	private static long findW(long square, int[] nums) {
		long low = 0;
		long high = (long) (1e9);
		long answer = -1;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			long possibleSquare = isPossible(middle, square, nums);
			if (possibleSquare <= square) {
				if (possibleSquare == square) {
					return middle;
				}
				answer = middle;
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return answer;
	}

	private static long isPossible(long middle, long square, int[] nums) {
		long currentTotal = 0;
		for (int num : nums) {
			currentTotal = (currentTotal + ((num + 2 * middle) * (num + 2 * middle)));
			if (currentTotal > square) {
				break;
			}
		}
		// System.out.println(currentTotal);
		return currentTotal;
	}

}

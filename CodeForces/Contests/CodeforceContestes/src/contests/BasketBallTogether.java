package contests;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 24-Jun-2025
 */
public class BasketBallTogether {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int enemy = sc.nextInt();
		int[] power = new int[n];
		for (int index = 0; index < n; index++) {
			power[index] = sc.nextInt();
		}
		System.out.println(maxWins(n, enemy, power));
		sc.close();
	}

	private static int maxWins(int n, int enemy, int[] power) {
		int numberOfWins = 0;
		Arrays.sort(power);
		int start = -1;
		int end = n - 1;
		int teamSize = 1;
		while (start < end) {
			if (power[end] * teamSize <= enemy && start < end) {
				teamSize++;
				start++;
			}
			else {
				numberOfWins++;
				end--;
				teamSize = 1;
			}
		}
		return numberOfWins;
	}

}

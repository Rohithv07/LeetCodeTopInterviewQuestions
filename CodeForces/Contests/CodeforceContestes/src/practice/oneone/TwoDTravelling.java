package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 27-Sept-2025
 */
public class TwoDTravelling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int majorCities = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			long[][] cities = new long[length][2];
			for (int index = 0; index < length; index++) {
				cities[index][0] = sc.nextLong();
				cities[index][1] = sc.nextLong();
			}
			System.out.println(findMinMoney(cities, majorCities, start, end));
		}
		sc.close();
	}

	private static long findMinMoney(long[][] cities, int majorCities, int start, int end) {
		start--;
		end--;
		// this is done to have the indexing correct
		if (majorCities == 0) {
			return Math.abs(cities[start][0] - cities[end][0]) + Math.abs(cities[start][1] - cities[end][1]);
		}
		long possibleAnswer = Math.abs(cities[start][0] - cities[end][0]) + Math.abs(cities[start][1] - cities[end][1]);
		long distance1 = Long.MAX_VALUE;
		long distance2 = Long.MAX_VALUE;
		for (int index = 0; index < majorCities; index++) {
			long distanceFromSourceToMajor = Math.abs(cities[start][0] - cities[index][0])
					+ Math.abs(cities[start][1] - cities[index][1]);
			long distanceFromDestinationToMajor = Math.abs(cities[end][0] - cities[index][0])
					+ Math.abs(cities[end][1] - cities[index][1]);
			distance1 = Math.min(distance1, distanceFromSourceToMajor);
			distance2 = Math.min(distance2, distanceFromDestinationToMajor);
		}
		possibleAnswer = Math.min(distance2 + distance1, possibleAnswer);
		return possibleAnswer;
	}

}

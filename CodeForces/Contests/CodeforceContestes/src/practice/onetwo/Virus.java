/**
 * @author rohithvazhathody
 * @date 11 Jan 2026
 * Project: CodeforceContestes
 * File: Virus.java
 */

package practice.onetwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class Virus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long totalHouses = sc.nextLong();
			int infectedHouse = sc.nextInt();
			int[] infected = new int[infectedHouse];
			for (int index = 0; index < infectedHouse; index++) {
				infected[index] = sc.nextInt();
			}
			int savedHouses = findSavedHouses(infected, totalHouses);
			System.out.println(totalHouses - savedHouses);
		}
		sc.close();
	}

	private static int findSavedHouses(int[] infected, long totalHouses) {
		int length = infected.length;
		Arrays.sort(infected);
		List<Integer> sortedGaps = new ArrayList<>();
		for (int index = 0; index + 1 < length; index++) {
			int currentNum = infected[index];
			int nextNum = infected[index + 1];
			sortedGaps.add(nextNum - currentNum - 1);
		}
		int roundedLast = (int)totalHouses - infected[length - 1];
		int roundedFirst = infected[0] - 1;
		sortedGaps.add(roundedLast + roundedFirst);
		Collections.sort(sortedGaps, Collections.reverseOrder()); // descending order
		int savedHouse = 0;
		int days = 0;
		for (Integer gap : sortedGaps) {
			int currentGap = gap - 2 * days;
			if (currentGap > 0) {
				savedHouse++;
				currentGap -= 2; // one we saved and one got infected, so gap reduce by 2
				if (currentGap > 0) {
					savedHouse += currentGap;
				}
				days += 2; // the whole thing for the range takes in 2 days.
			}
		}
		return savedHouse;
	}

}

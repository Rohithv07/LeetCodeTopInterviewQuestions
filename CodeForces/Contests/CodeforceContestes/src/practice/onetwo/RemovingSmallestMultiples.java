/**
 * @author rohithvazhathody
 * @date 10 Jan 2026
 * Project: CodeforceContestes
 * File: RemovingSmallestMultiples.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class RemovingSmallestMultiples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			long totalCost = findTotalCost(s);
			System.out.println(totalCost);
		}
		sc.close();
	}

	private static long findTotalCost(String s) {
		int length = s.length();
		boolean[] trackRemoved = new boolean[length + 1];
		long totalCost = 0;
		for (int possibleK = 1; possibleK <= length; possibleK++) {
			for (int index = possibleK; index <= length; index += possibleK) {
				char currentChar = s.charAt(index - 1);
				if (currentChar == '1') {
					break;
				}
				if (trackRemoved[index]) {
					continue;
				}
				trackRemoved[index] = true;
				totalCost += possibleK;
			}
		}
		return totalCost;
	}

}

/**
 * 
 */
package kickstart;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody
 *
 */
public class WiggleWalk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int instructions = sc.nextInt();
			int row = sc.nextInt();
			int col = sc.nextInt();
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			String direction = sc.next();
			char[] directionArray = direction.toCharArray();
			int[] finalPosition = findFinalPosition(row, col, startRow - 1, startCol - 1, directionArray);
			System.out.println("Case #" + t + ": " + (finalPosition[0] + 1) + " " + (finalPosition[1] + 1));
		}
	}

	private static int[] findFinalPosition(int row, int col, int i, int j, char[] directionArray) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		set1.add(i);
		set2.add(j);
		for (char ch : directionArray) {
			if (ch == 'N') {
				while (set1.contains(i) && set2.contains(j) && i >= 0) {
					i -= 1;
				}
			} else if (ch == 'E') {
				while (set1.contains(i) && set2.contains(j) && j < col ) {
					j += 1;
				}
			} else if (ch == 'W') {
				while (set1.contains(i) && set2.contains(j) && j >= 0) {
					j -= 1;
				}
			} else if (ch == 'S') {
				while (set1.contains(i) && set2.contains(j) && i < row) {
					i += 1;
				}
			}
			set1.add(i);
			set2.add(j);
		}
		
		System.out.println(set1);
		System.out.println(set2);
		return new int[] { i, j };
	}
}

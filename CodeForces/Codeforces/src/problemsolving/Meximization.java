/**
 * 
 */
package problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Meximization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			List<Integer> toIncrease = new ArrayList<>();
			List<Integer> repeat = new ArrayList<>();
			Set<Integer> visited = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				if (visited.contains(num)) {
					repeat.add(num);
				} else {
					visited.add(num);
					toIncrease.add(num);
				}
			}
			Collections.sort(toIncrease);
			int[] result = new int[n];
			int index = 0;
			for (int number : toIncrease) {
				result[index++] = number;
			}
			for (int number : repeat) {
				result[index++] = number;
			}
			for (int number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}

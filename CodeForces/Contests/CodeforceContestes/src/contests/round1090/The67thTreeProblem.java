/**
 * @author rohithvazhathody
 * @date 4 Apr 2026
 * Project: CodeforceContestes
 * File: The67thTreeProblem.java
 */

package contests.round1090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class The67thTreeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			List<List<Integer>> tree = findTree(x, y);
			if (tree == null) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				for (List<Integer> t : tree) {
					System.out.println(t.get(0) + " " + t.get(1));
				}
			}
		}
		sc.close();
	}

	private static List<List<Integer>> findTree(int x, int y) {
		List<List<Integer>> result = new ArrayList<>();
		int totalNodes = x + y;
		if (totalNodes % 2 == 0) {
			if (x > y) {
				return null;
			}
			if (x == 0) {
				return null;
			}
		} else {
			if (x + 1 > y) {
				return null;
			}
		}
		int totalPaths = 0;
		int totalLeaves = 0;
		if (totalNodes % 2 == 0) {
			totalPaths = x - 1;
			totalLeaves = y - x + 1;
		} else {
			totalPaths = x;
			totalLeaves = y - x - 1;
		}
		int nextNodes = 2;
		for (int index = 0; index < totalPaths; index++) {
			result.add(new ArrayList<>(Arrays.asList(1, nextNodes)));
			result.add(new ArrayList<>(Arrays.asList(nextNodes, nextNodes + 1)));
			nextNodes += 2;
		}
		for (int index = 0; index < totalLeaves; index++) {
			result.add(new ArrayList<>(Arrays.asList(1, nextNodes)));
			nextNodes++;
		}
		return result;
	}

}

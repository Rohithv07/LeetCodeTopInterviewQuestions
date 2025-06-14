package contests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class DistinctSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int size = sc.nextInt();
			String s = sc.next();
			System.out.println(findMaxSplitLength(s, size));
		}
		sc.close();
	}

	private static int findMaxSplitLength(String s, int size) {
		Set<Character> visited = new HashSet<>();
		int[] prefix = new int[size];
		int[] suffix = new int[size];
		for (int index = 0; index < size; index++) {
			char ch = s.charAt(index);
			visited.add(ch);
			prefix[index] = visited.size();
		}
		visited = new HashSet<>();
		for (int index = size - 1; index >= 0; index--) {
			char ch = s.charAt(index);
			visited.add(ch);
			suffix[index] = visited.size();
		}
		int maxSize = 0;
		for (int index = 0; index < size; index++) {
			if (index == size - 1) {
				maxSize = Math.max(maxSize, prefix[index]);
			} else {
				maxSize = Math.max(maxSize, prefix[index] + suffix[index + 1]);
			}

		}
		return maxSize;
	}

}

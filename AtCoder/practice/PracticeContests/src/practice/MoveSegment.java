/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 */
public class MoveSegment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		List<Integer> blockLast = new ArrayList<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
				blockLast.add(i);
			}
		}
		if (s.charAt(s.length() - 1) == '1') {
			blockLast.add(s.length() - 1);
		}
		int neededBlock = blockLast.get(k - 1);
		StringBuilder block1 = new StringBuilder();
		while (neededBlock >= 0 && s.charAt(neededBlock) == '1') {
			block1.append(s.charAt(neededBlock--));
		}
		int where = blockLast.get(k - 2);
		// System.out.println(neededBlock);
		StringBuilder result = new StringBuilder();
		int i = 0;
		for (i = 0; i <= where; i++) {
			result.append(s.charAt(i));
		}
		result.append(block1.toString());
		for (i = where + 1; i <= neededBlock; i++) {
			result.append(s.charAt(i));
		}
		// result.append(s.substring(where + 1));
		result.append(s.substring(result.length()));
		System.out.println(result.toString());
		sc.close();

	}

}

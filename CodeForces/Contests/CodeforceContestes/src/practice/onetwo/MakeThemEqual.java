/**
 * @author rohithvazhathody
 * @date 14 Feb 2026
 * Project: CodeforceContestes
 * File: MakeThemEqual.java
 */

package practice.onetwo;

import java.util.Scanner;

/**
 * 
 */
public class MakeThemEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			char ch = sc.next().charAt(0);
			String s = sc.next();
			Pair resultPair = findOpAndX(s, ch);
			int operation = resultPair.operation;
			int[] nums = resultPair.nums;
			System.out.println(operation);
			if (operation > 0) {
				for (int num : nums) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static Pair findOpAndX(String s, char ch) {
		int countCh = 0;
		for (char c : s.toCharArray()) {
			if (c == ch) {
				countCh++;
			}
		}
		if (countCh == s.length()) {
			return new Pair(0, null);
		}
		int length = s.length();
		long val = -1;
		for (long i = 2; i <= length; i++) {
			boolean flag = true;
			for (long j = i; j <= length; j += i) {
				if (s.charAt((int) (j - 1)) != ch) {
					flag = false;
					break;
				}
			}
			if (flag) {
				val = i;
				break;
			}
		}
		if (val != -1) {
			int op = 1;
			return new Pair(op, new int[] { (int) val });
		}

		return new Pair(2, new int[] { length - 1, length });
	}

}

class Pair {
	int operation;
	int[] nums;

	public Pair(int operation, int[] nums) {
		this.operation = operation;
		this.nums = nums;
	}
}

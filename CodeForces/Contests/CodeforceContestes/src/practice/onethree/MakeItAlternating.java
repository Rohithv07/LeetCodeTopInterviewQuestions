/**
 * @author rohithvazhathody
 * @date 27 Feb 2026
 * Project: CodeforceContestes
 * File: MakeItAlternating.java
 */

package practice.onethree;

import java.util.Scanner;

/**
 * 
 */
public class MakeItAlternating {

	private static final int MOD = 998244353;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int minOperation = findMinOperation(s);
			long totalSeq = findSequence(s);
			System.out.println(minOperation - 1 + " " + totalSeq);
		}
		sc.close();
	}

	private static long findSequence(String s) {
		int length = s.length();
		int minOperation = findMinOperation(s) - 1;
		long seq = 1;
		int currentBlock = 1;
		for (int index = 1; index < length; index++) {
			if (s.charAt(index) != s.charAt(index - 1)) {
				seq = (seq * currentBlock) % MOD;
				currentBlock = 1;
			}
			else {
				currentBlock++;
			}
		}
		seq = (seq * currentBlock) % MOD;
		for (int index = 1; index <= minOperation; index++) {
			seq = (seq * index) % MOD;
		}
		return seq;
	}

	private static int findMinOperation(String s) {
		int length = s.length();
		int inEquality = 0;
		for (int index = 1; index < length; index++) {
			if (s.charAt(index) != s.charAt(index - 1)) {
				inEquality++;
			}
		}
		return length - inEquality;
	}

}

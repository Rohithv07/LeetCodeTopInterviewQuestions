/**
 * @author rohithvazhathody
 * @date 21 Feb 2026
 * Project: CodeforceContestes
 * File: StringRotationGame.java
 */

package contests.round1081;

import java.util.Scanner;

/**
 * 
 */
public class StringRotationGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int maxBlock = findMaxBlock(s);
			System.out.println(maxBlock);
		}
		sc.close();
	}

	private static int findMaxBlock(String s) {
		int maxScore = 0;
		for (int index = 0; index < s.length(); index++) {
			String block = s.substring(index) + s.substring(0, index);
			int currentBlock = findBlock(block);
			maxScore = Math.max(maxScore, currentBlock);
		}
		return maxScore;
	}

	private static int findBlock(String block) {
		int currentBlocks = 1;
        for (int j = 0; j < block.length() - 1; j++) {
            if (block.charAt(j) != block.charAt(j + 1)) {
                currentBlocks++;
            }
        }
		return currentBlocks;
	}

}

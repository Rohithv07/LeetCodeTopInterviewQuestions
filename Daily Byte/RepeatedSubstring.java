/*
Given a string, sequence, and a word to search for, return the total number of times that word can be repeated and still exist as a substring within sequence.

Ex: Given the following sequence and word…

sequence = "abcabcab", word = "abc", return 2 ("abcabc" exists within our sequence but "abcabcabc" does not).
Ex: Given the following sequence and word…

sequence = "ccc", word = "c", return 3.
*/

import java.util.*;

public class RepeatedSubstring {

	public static int countOfWord(String seq, String word) {
		int length2 = seq.length();
		int length1 = word.length();
		int [][] dp = new int [length1 + 1][length2 + 1];
		for (int i=0; i<=length1; i++) {
			for (int j=0; j<=length2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
				else if (word.charAt(i - 1) == seq.charAt(j - 1)) {
					dp[i][j] = dp[i][j - 1] + 1;
				}
				else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[length1][length2];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String seq = sc.next();
		String word = sc.next();
		System.out.println(countOfWord(seq, word));
	}
}
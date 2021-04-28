/*
Given a string, text, return how many times you can form the string “programming”.

Ex: Given the following text…

text = "mingabcprojklgram", return 1. - problem with this test case
Ex: Given the following text…

text = "rammingabcprogrammingdefprog", return 2.
*/


import java.util.*;

public class ProgrammingString {

	public static int howManyTimesProgrammingAppears(String s, String programming) {
		int length1 = s.length();
		int length2 = programming.length();
		int [][] dp = new int [length1 + 1][length2 + 1];
		for (int i=0; i<=length2; i++) {
			dp[0][i] = 0;
		}
		for (int i=0; i<=length1; i++) {
			dp[i][0] = 1;
		}
		for (int i=1; i<=length1; i++) {
			for (int j=1; j<=length2; j++) {
				if (s.charAt(i - 1) == programming.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[length1][length2];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		String programming = "programming";
		System.out.println(howManyTimesProgrammingAppears(text, programming));
	}
}

/*
This question is asked by Apple. Given a string and a character, return an array of integers where each index is the shortest distance from the character.
Ex: Given the following string s and character s...

s = "dailybyte", c = 'y', return [7, 6, 5, 4, 3, 2, 1, 0, 1, 0, 1, 2]
*/


import java.util.*;

public class ShortestDistance {

	public static int [] findShortestDistance(String s, char c) {
		int n = s.length();
		int [] dp = new int [n];
		for (int i=0; i<n; i++) {
			if (s.charAt(i) != c)
				dp[i] = Integer.MAX_VALUE;
		}
		for (int i=0; i<n-1; i++) {
			if (dp[i] != Integer.MAX_VALUE)
				dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
		}
		for (int i=n-1; i>0; i--) {
			dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
		}
		return dp;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = sc.next().charAt(0);
		int [] result = findShortestDistance(s, c);
		for (int i=0; i<result.length; i++)
			System.out.print(result[i] + " ");
	}
}
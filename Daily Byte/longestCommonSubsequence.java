This question is asked by Google. Given two strings, s and t, return the length of their longest subsequence.

Ex: Given the following strings s and t…

s = "xyz", t = "xyz". return 3.
Ex: Given the following strings s and t…

s = "abca", t = "acea", return 3.
Ex: Given the following strings s and t…

s = "abc", t = "def", return 0.

// here the idea is we have a 2 string and we have to find the longest common subsequence.
// brute force is to consider every sequence and find the maxLenght from them which is not efficient
// another way will consider say this is a function f[i,j]
// if i-1 and j-1 words of s and t are equal then our function is f[i,j] = f[i-1,j-1] + 1 as we have a common word
// else our function is the max(f[i][j-1], f[i-1][j])

// so we can make use of 2d dynamic array and the last element will give us the result

import java.util.*;

public class Solution {
	public static int longestCommonSubsequence(String s, String t) {
		int length1 = s.length();
		int length2 = t.length();
		if (s.equals(t))
			return length1;
		int [][] dp = new int [length1+1][length2+1];
		for (int i=0; i<=length1; i++) {
			for (int j=0; j<=length2; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s.charAt(i-1) == t.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[length1][length2];
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		System.out.println(longestCommonSubsequence(s, t));
	}
} 
O(lengthS * lengtht)

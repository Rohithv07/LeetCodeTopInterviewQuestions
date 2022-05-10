// https://practice.geeksforgeeks.org/contest/interview-series-49/problems/


class Solution{
	String cbaSubsequence(String S, int N) {
		//Write your code here
		char [] ch = S.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
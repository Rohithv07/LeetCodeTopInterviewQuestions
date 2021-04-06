Given two strings S and T of length n and m respectively. find count of distinct occurrences of T in S as a sub-sequence. 
 

Example 1:

Input:
S = "banana" , T = "ban"
Output: 3
Explanation: There are 3 sub-sequences:
[ban], [ba n], [b an].

â€‹Example 2:

Input:
S = "geeksforgeeks" , T = "ge"
Output: 6
Explanation: There are 6 sub-sequences:
[ge], [ ge], [g e], [g e] [g e] and [ g e].

 

Your Task:
You don't need to read input or print anything.Your task is to complete the function subsequenceCount() which takes two strings as argument S and T and returns the count of the sub-sequences modulo 109 + 7.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).

Constraints:
1<=length of(T)<=100
1<=length of(S)<=8000


class Solution
{
    int  subsequenceCount(String s, String t)
    {
	// Your code here	
	    int mod = (int)(1e9 + 7);
    	int sLength = s.length();
    	int tLength = t.length();
    	int [][] dp = new int [tLength + 1][sLength + 1];
    	for (int i=0; i<=sLength; i++) {
    	    dp[0][i] = 1;
    	}
    	for (int i=1; i<=tLength; i++) {
    	    for (int j=1; j<=sLength; j++) {
    	        if (t.charAt(i - 1) == s.charAt(j - 1)) {
    	            dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % mod ;
    	        }
    	        else {
    	            dp[i][j] = (dp[i][j - 1]) % mod;
    	        }
    	    }
    	}
    	return dp[tLength][sLength] % mod;
    }
}




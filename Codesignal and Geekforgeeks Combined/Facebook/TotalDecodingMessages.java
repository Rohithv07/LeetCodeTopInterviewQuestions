A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.
 

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).
Example 2:

Input: str = "27"
Output: 1
Explanation: "27" can be decoded as "BG".
 

Your Task:
You don't need to read or print anything. Your task is to complete the function CountWays() which takes the string as str as input parameter and returns the total number of ways the string can be decoded modulo 109 + 7.
 

Expected Time Complexity: O(n)
Expected Space Complexity: O(n) where n  = |str|



class Solution
{
    public int CountWays(String str)
    {
        // code here
        if (str == null || str.length() == 0)
            return 0;
        int length = str.length();
        int mod = (int)1e9 + 7;
        int [] dp = new int [length + 1];
        dp[0] = 1;
        dp[1] = (str.charAt(0) == '0') ? 0 : 1;
        for (int i=2; i<=length; i++) {
            int firstPart = Integer.valueOf(str.substring(i - 1, i));
            int secondPart = Integer.valueOf(str.substring(i - 2, i));
            if (firstPart > 0 && firstPart <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }
            if (secondPart > 9 && secondPart <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }
        return dp[length] % mod;
    }
}
A string is k palindrome if it can be transformed into a palindrome on removing at most k characters from it. Your task is to complete the function is_k_palin which takes two arguments a string str and a number N . Your function should return true if the string is k palindrome else it should return false.

Input:
The first line of input is an integer T denoting the number of test cases . Then T test cases follow . Each test case  contains a string str and an integer N separated by space.  

Output:
The output will be 1 if the string is  k palindrome else 0 .

Constraints:
1<=T<=100
1<=length of str<=100
1<=N<=20

Example:
Input
2
abcdecba 1
acdcb  1
Output
1
0




// reverse the string
// use dp table and find the lcs
// check whetehr the length pf input string - lcs length <= k
// if yes return true otherwise false

class GfG
{
    boolean is_k_palin(String str, int k)
    {
	// Your code here
	    if (str == null || str.length() == 0)
	        return false;
	    String reversedStr = reverse(str);
	    int [][] dp = new int [str.length() + 1][reversedStr.length() + 1];
	    for (int i=1; i<=str.length(); i++) {
	        for (int j=1; j<=reversedStr.length(); j++) {
	            if (str.charAt(i - 1) == reversedStr.charAt(j - 1))
	                dp[i][j] = dp[i - 1][j - 1] + 1;
	            else
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	        }
	    }
	    if (str.length() - dp[str.length()][reversedStr.length()] <= k)
	        return true;
	    return false;
    }
    
    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

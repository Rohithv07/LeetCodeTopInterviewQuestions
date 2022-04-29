Given a string str you have to answer several queries on that string. In each query you will be provided two values L and R and you have to find the number of distinct characters in the sub string from index L to index R (inclusive) of the original string.
 

Example 1:

Input: str = "abcbaed",
Query = {{1,4},{2,4},{1,7}}
Output: {3,2,5}
Explanation: For the first query distinct 
characters from [1, 4] are a, b and c.
For the second query distinct characters from
[2, 4] are b and c.
For the third query distinct characters from
[1, 7] are a, b, c, d and e.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function SolveQueries() which takes str and Query as input parameter and returns a list containing answer for each query.
 

Expected Time Complexity: O(max(26*length of str, 26 * No of queries))
Expected Space Complexity: O(26 * length of str)
 

Constraints:
1 <= |str| <= 105
1 <= No of Queries <= 104
1 <= Li <= Ri <= |str|



class Solution
{
    public int[] SolveQueris(String str, int[][] query)
    {
        // Code here
        int length = str.length();
        int queryLength = query.length;
        int [][] dp = new int [26][length + 1];
        int [] result = new int [queryLength];
        for (int i = 1; i <= length; i++) {
            int currentIndex = str.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                if (currentIndex == j) {
                    dp[j][i] = dp[j][i - 1] + 1;
                }
                else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }
        int index = 0;
        for (int [] q : query) {
            int l = q[0];
            int r = q[1];
            int currentCount = 0;
            for (int i = 0; i < 26; i++) {
                int count1 = dp[i][l - 1];
                int count2 = dp[i][r];
                if (count2 > count1) {
                    currentCount++;
                }
            }
            result[index++] = currentCount;
        }
        return result;
    }
}
You have a sequence 2,5,16,65,........Given an integer n as input . You have to find the value at nth position in the sequence.
 

Example 1:

Input: n = 4
Output: 65
Example 2:

Input: n = 10
Output: 9864101
 

Your Task:

You don't need to read or print anything, Your task is to complete the function NthTerm() which takes n as input parameter and retruns value at nth position of the given sequence modulo 109 + 7.
 

Expected Time Compelxity:  O(n)
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 104


class Solution
{
    public int NthTerm(int n)
    {
        // code here
        long answer = 1;
        final long MOD = (long)(1e9 + 7);
        for (int i = 1; i <= n; i++) {
            answer = (answer * i) % MOD + 1;
        }
        return (int)(answer % MOD);
    }
}
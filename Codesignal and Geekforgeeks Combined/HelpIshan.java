Ishaan has been given a task by his teacher. He needs to find the Nth term of a series. His teacher gives him some examples to help him out (Refer examples below). He is a bit weak in pattern searching so to help him his teacher told him that the Nth term is related to prime numbers. The Nth term is the difference of N and the closest prime number to N. Help him find the Nth term for a given N.
 

Example 1:

Input: N = 10
Output: 1
Explanation: Closest prime to 10 is 11.
Example 2:

Input: N = 7
Output: 0
Explanation: Closest prime to 7 is 7.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function NthTerm() which takes N as input paramater and returns Nth term.
 

Expected Time Complexity: O(N* √ N)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 100000


//User function Template for Java

class Solution
{
    public int NthTerm(int n)
    {
        // code here
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 2;
        }
        if (isPrime(n)) {
            return 0;
        }
        int maxLimit = n + 1;
        while (!isPrime(maxLimit)) {
            maxLimit++;
        }
        int minLimit = n - 1;
        while (!isPrime(minLimit)) {
            minLimit--;
        }
        return Math.min(maxLimit - n, n - minLimit);
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
A prime number is Super Prime if it is a sum of two primes. Find all the Super Primes upto N

Example 1:

Input:
N = 5
Output: 1
Explanation: 5 = 2 + 3, 5 is the
only super prime

Example 2:

Input:
N = 10 
Output: 2
Explanation: 5 and 7 are super primes

Your Task:  
You don't need to read input or print anything. Your task is to complete the function superPrimes() which takes the N as input and returns the count of super primes.

Expected Time Complexity: O(Nlog(logN))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105


//User function Template for Java

class Solution {
    int superPrimes(int n) {
        // code here
        if (n == 1) {
            return 0;
        }
        boolean [] prime = new boolean [n + 1];
        sieve(n, prime);
        int count = 0;
        for (int i = 5; i <= n; i++) {
            if (!prime[i] && !prime[i - 2]) {
                count++;
            }
        }
        return count;
    }
    
    void sieve(int n, boolean [] track) {
        for (int i = 2; i * i <= n; i++) {
            if (!track[i]) {
                for (int j = 2; j * i <= n; j++) {
                    track[i * j] = true;
                }
            }
        }
    }
}
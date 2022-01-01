GIven two positive integers N and K. You have to find the Kth smallest factor of N. A factor of N is a positive integer which divides N. Output the Kth smallest factor of N if it exists otherwise print -1.

 

Example 1:

Input : N = 4 , K = 2
Output: 2
Explanation:
All factors of 4 are 1,2 and 4. Out of
these 2 is the 2nd smallest.
Example 2:

Input : N = 4 , K = 3
Output: 4
Explanation:
All factors of 4 are 1,2 and 4. Out of
these 4 is the 3rd smallest.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kThSmallestFactor() which takes 2 Integers N and K as input and returns the answer.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106
1 <= K <= 106



// o(n) approach

class Solution {
    static int kThSmallestFactor(int n , int k) {
        // code here
        if (n <= 0) {
            return -1;
        }
        int counter = 0;
        int i = 0;
        for (i=1; i<=n; i++) {
            if (n % i == 0) {
                counter++;
            }
            if (counter == k) {
                return i;
            }
        }
        return counter < k ? -1 : n;
    }
}

// O(sqrt(n)) approach

class Solution {
    static int kThSmallestFactor(int n , int k) {
        // code here
        if (n <= 0) {
            return -1;
        }
        int counter = 0;
        for (int i=1; i*i<n; i++) {
            if (n % i == 0) {
                counter++;
            }
            if (counter == k) {
                return i;
            }
        }
        for (int i=(int)(Math.sqrt(n)); i>=1; i--) {
            if (n % i == 0) {
                counter++;
            }
            if (counter == k) {
                return n/i;
            }
        }
        return -1;
    }
Given two integers M and N, generate all primes between M and N.

Example 1:

Input:
M=1,N=10
Output:
2 3 5 7
Explanation:
The prime numbers between 1 and 10
are 2,3,5 and 7.
Example 2:

Input:
M=2, N=5
Output:
2,3,5
Explanation:
The prime numbers between 2 and 5 are 
2,3 and 5.

Your Task:
You don't need to read input or print anything. Your task is to complete the function primeRange() which takes 2 integer inputs M and N and returns a list of all primes between M and N.


Expected Time Complexity:O(N*sqrt(N))
Expected Auxillary Space:O(1)


Constraints:
1<=M<=N<=106


// User function Template for Java

class Solution {
    ArrayList<Integer> primeRange(int m, int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = m ; i <= n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    boolean isPrime(int n) {
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 



public class Solution {
    public ArrayList<Integer> primesum(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean [] isPrime = sieve(n);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=2; i<=n; i++) {
            if (!isPrime[i] && !isPrime[n-i]) {
                min = Math.min(min, i);
                max = Math.max(max, n-i);
            }
        }
        result.add(min);
        result.add(max);
        return result;
    }
    public boolean [] sieve(int n) {
        boolean [] prime = new boolean [n+1];
        for (int i=2; i*i<=n; i++) {
            if (!prime[i]) {
                for (int j=2; j*i<=n; j++) {
                    prime[i*j] = true;
                }
            }
        }
        return prime;
    }
}


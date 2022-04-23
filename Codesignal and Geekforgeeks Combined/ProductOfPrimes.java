Given two numbers L and R (inclusive) find the product of primes within this range. Print the product modulo 109+7. If there are no primes in that range you must print 1.

Example 1:

Input: L = 1, R = 10
Output: 210
Explaination: The prime numbers are 
2, 3, 5 and 7.
Example 2:

Input: L = 1, R = 20
Output: 9699690
Explaination: The primes are 2, 3, 
5, 7, 11, 13, 17 and 19.
Your Task:
You do not need to read input or print anything. Your task is to complete the function primeProduct() which takes L and R and returns the product of the primes within the range. If there are no primes in that range then return 1.

Expected Time Complexity: O((R-L)*(logR))
Expected Auxiliary Space: O(sqrt(R))

Constraints:
1 ≤ L ≤ R ≤ 109
0 ≤ L - R ≤ 106  







// one method

class Solution{
    static long primeProduct(long l, long r){
        // code here
        if (l == 1) {
            l = 2;
        }
        long product = 1;
        final long MOD = (long)(1e9 + 7);
        for (long i = l; i <= r; i++) {
            if (isPrime(i)) {
                //System.out.println(i);
                product = (product * i) % MOD;
            }
        }
        return product;
    }
    
    static boolean isPrime(long n) {
        if (n == 2) {
            return true;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// another one sieve

class Solution{
    static long primeProduct(long l, long r){
        // code here
        if (l == 1) {
            l = 2;
        }
        long product = 1;
        final long MOD = (long)(1e9 + 7);
        boolean [] primeTrack = new boolean [(int)(r + 1)];
        for (long i = 2; i * i <= r; i++) {
            if (!primeTrack[(int)i]) {
                for (long j = 2; j * i <= r; j++) {
                    primeTrack[(int)(i * j)] = true;
                }
            }
        }
        //System.out.println(primeTrack[4]);
        for (long  i = l; i <= r; i++) {
            if (!primeTrack[(int)i]) {
                product = (product * i) % MOD;
            }
        }
        return product;
    }
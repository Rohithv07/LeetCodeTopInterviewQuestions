package AdvancedAlgo;

class Combinatorics {
    long[] fact;
    long[] invFact;
    int MOD;

    public Combinatorics(int maxN, int mod) {
        this.MOD = mod;
        fact = new long[maxN + 1];
        invFact = new long[maxN + 1];
        
        // 1. Precompute Factorials
        fact[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // 2. Precompute Inverse Factorials in O(N)
        // First, find the inverse of the maximum factorial using Fermat's Little Theorem
        invFact[maxN] = power(fact[maxN], MOD - 2);
        
        // Then, compute the rest by iterating backwards
        for (int i = maxN - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Binary Exponentiation to calculate (base^exp) % MOD in O(log exp) time
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    // Calculate nCr in O(1) time
    public int nCr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        
        // Formula: n! / (r! * (n-r)!)
        // Under modulo: n! * invFact[r] * invFact[n-r]
        long ans = fact[n];
        ans = (ans * invFact[r]) % MOD;
        ans = (ans * invFact[n - r]) % MOD;
        
        return (int) ans;
    }
    
    // Optional: Calculate nPr in O(1) time
    public int nPr(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        long ans = fact[n];
        ans = (ans * invFact[n - r]) % MOD;
        return (int) ans;
    }
}

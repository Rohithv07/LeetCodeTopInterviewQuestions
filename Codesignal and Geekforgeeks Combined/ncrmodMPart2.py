Given 3 integers n, r and m. You task is to calculate nCr%m.
Note: m is a square free number and largest prime factor of m <= 50.

 

Example 1:

Input: n = 5, r = 2, m = 98697
Output: 10
Explanation: 5C2 = 5!/(2!*3!) = 10%98697 = 10
Example 2:

Input: n = 3, r = 2, m = 98697
Output: 3
Explanation: 3C2 = 3!/(2!*1!) = 3%98697 = 3
 

Your Task:
You don't need to read or print anything. Your task is to complete the function nCrModM() which takes n, r and m as input parameter and returns nCr modulo m.
 

Expected Time Complexity: O(m + logmn) 
Expected Space Complexity: O(m)
 

Constraints:
1 <= n <= r <= 109
1 <= m <= 105


class Solution:
    def nCrModM(self, n, r, m):
       # Code here
       def leastPrimeFactor(n):
           least_prime = [0] * (n + 1)
       
           least_prime[1] = 1
       
           for i in range(2, n + 1):
               if (least_prime[i] == 0):
                   least_prime[i] = i
       
                   for j in range(2 * i, n + 1, i):
                       if (least_prime[j] == 0):
                           least_prime[j] = i
           return least_prime
       
       
       # To compute x^y under modulo m
       def power(x, y, m):
           if (y == 0):
               return 1
       
           p = power(x, y // 2, m) % m
           p = (p * p) % m
       
           if (y % 2 == 0):
               return p
           else:
               return ((x * p) % m)
       
       def ncr_kris(n, r, p):
           if(n < r):
               return 0
           if(r > n - r):
               r = n - r
           num = den = 1
           for i in range(r):
               num = (num * (n - i)) % p
               den = (den * (i + 1)) % p
           ans =(num * power(den, p - 2, p)) % p
           return ans
       
           
       def toBaseB(N, B):
           digits = []
           while N > 0:
             digits.insert(0, N % B)
             N = N // B
           return digits
       
       def nCrModp_Lucas(n, r, p):
           m = toBaseB(n, p)
           n = toBaseB(r, p)
           l1 = len(m)
           l2 = len(n)
           ans = 1
           for i in range(l2):
               ans = (ans * ncr_kris(m[(l1-l2) + i], n[i], p)) % p
           return ans

       SPF = leastPrimeFactor(m)

       PrimeFactors = []

       x = m

       i = 0

       ans = 0

       while x != 1:

           PrimeFactors.append(SPF[x])

           ans = ans + ((nCrModp_Lucas(n, r, PrimeFactors[i]) * (m//PrimeFactors[i]) * (power(m//PrimeFactors[i], PrimeFactors[i] - 2, PrimeFactors[i]))) % m)

           i += 1

           x = x // SPF[x]

       return ans % m
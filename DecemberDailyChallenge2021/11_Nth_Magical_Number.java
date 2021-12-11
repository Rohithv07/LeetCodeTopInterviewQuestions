A positive integer is magical if it is divisible by either a or b.

Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: n = 1, a = 2, b = 3
Output: 2
Example 2:

Input: n = 4, a = 2, b = 3
Output: 6
Example 3:

Input: n = 5, a = 2, b = 4
Output: 10
Example 4:

Input: n = 3, a = 6, b = 4
Output: 8
 

Constraints:

1 <= n <= 109
2 <= a, b <= 4 * 104


class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        long A = a, B = b;
        long mod = (long)(Math.pow(10,9)+7);
        
        
        long left = Math.min(a,b), right = (long)n*Math.min(a,b);
        
		// Finding GCD
        while (B > 0) {
            long tmp = A;
            A = B;
            B = tmp % B;
        }
        
        while (left < right) {
            long m = left+(right-left)/2;
            long lcm = (a*b)/A;     //(n1*n2)/GCD
            if ((m / a) + (m / b) - (m / lcm) < n) left = m + 1;   
            else right = m;
        }
        return (int)(left % mod);
    }
}
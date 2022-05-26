Consider the set of irreducible fractions A = {n/d | n≤d and d ≤ 10000 and gcd(n,d) = 1}.You are given a member of this set and your task is to find the largest fraction in this set less than the given fraction.
Note : this is a set and all the members are unique.

Example 1:

Input: n = 1, d = 4
Output: {2499, 9997}  
Explanation: 2499/9997 is the largest fraction.

Example 2:

Input: n = 2, d = 4
Output: {4999, 9999}
Explanation: 4999/9999 is the largest fraction. 

Your Task:  
You dont need to read input or print anything. Complete the function numAndDen() which takes n and d as input parameter and returns the numerator and the denominator of the required irreducible fraction.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= d <=1000


//User function Template for Java
class Solution
{
    public int[] numAndDen(int n, int d)
    {
        // code here
        int num = 0;
        int den = 1;
        for (int i = 10000; i >= 2; i--) {
            int p = (n * i - 1) / d;
            if (p * den >= num * i) {
                den = i;
                num = p;
            }
        }
        int tot = findGCD(num, den);
        int num1 = num / tot;
        int num2 = den / tot;
        return new int [] {num1, num2};
    }
    
    public int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
A prime number is a Circular Prime Number if all of its possible rotations are itself prime numbers. Now given a number N check if it is Circular Prime or Not.
 

Example 1:

Input: N = 197
Output: 1
Explanation: 197 is a Circular Prime because
all rotations of 197 are 197, 719, 971 all of 
the 3 are prime number's hence 197 is a 
circular prime.
Example 2:

Input: N = 101
Output: 0
Explanation: 101 and 11 is prime but 110 is
not a prime number.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCircularPrime() which takes N as input parameter and returns 1 if it is Circular Prime otherwise returns -1.
 

Expected Time Complexity: O(Nlog(log(N))
Expected Space Complexity: O(N)
 

Constraints:
1 <= N <= 105


//User function Template for Java

class Solution
{
    public boolean isPrime(int n) {
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int isCircularPrime(int n)
    {
        // code here
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3 || n == 7 || n == 5) {
            return 1;
        }
        int sum = 0;
        int digit = n;
        int temp = n;
        while (temp > 0) {
            digit = temp % 10;
            temp /= 10;
            if (digit % 2 == 0 || digit % 5 == 0) {
                return 0;
            }
            sum += digit;
        }
        if (sum % 3 == 0 || sum % 9 == 0) {
            return 0;
        }
        String converted = String.valueOf(n);
        //System.out.println(converted);
        for (int i=0; i<converted.length(); i++) {
            int number = Integer.valueOf(converted);
            //System.out.println(number);
            if (!isPrime(number)) {
                return 0;
            }
            converted = converted.substring(1) + converted.substring(0, 1);
            //System.out.println(converted);
        }
        return 1;
    }
}
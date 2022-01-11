Given a non-negative integer N, repeatedly add all its digits until the result has only one digit.

Example 1:

Input:
N = 98

Output:
8

Explanation:
Sum of digit of N = 98  is 9 + 8 = 17
Sum of digit of 17 = 1 + 7 = 8
Since 8 is the single digit number hence it is the 
required answer.
Example 2:

Input:
N = 1

Output:
1

Explanation:
Since 1 is the single-digit number hence it is the 
required answer.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function singleDigit() which takes an integer N as an input parameter and return the single-digit you will get after repeatedly adding the digits of N.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 1018



// constant time
class Solution{
    static int singleDigit(long n){
        // code here
        return n % 9 == 0 ? (int)9 : (int)(n % 9);
    }
}

// using while loop

class Solution{
    static int singleDigit(long n){
        // code here
        int sum = 0;
        while (n > 0 || sum > 9) {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}


// using recursion

class Solution{
    static int singleDigit(long n){
        // code here
        if (n <= 0) {
            return 0;
        }
        long result = (int)singleDigit(n / 10) + (int)(n % 10);
        if (result < 10) {
            return (int)result;
        }
        else {
            return singleDigit(result);
        }
    }
}
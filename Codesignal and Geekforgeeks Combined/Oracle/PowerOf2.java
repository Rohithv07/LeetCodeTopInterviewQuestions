Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some x.
 

Example 1:

Input: N = 1
Output: true
Explanation:
1 is equal to 2 raised to 0 (20 = 1).
Example 2:

Input: N = 98
Output: false
Explanation: 
98 cannot be obtained by any power of 2.

Your Task: Your task is to complete the function isPowerofTwo() which takes n as a parameter and returns true or false by checking is given number can be represented as a power of two or not.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
0 ≤ N ≤ 1018


class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        if (n == 0)
            return false;
        if (n <= 2)
            return true;
        return  (n & (n - 1)) == 0;   
    }
    
}
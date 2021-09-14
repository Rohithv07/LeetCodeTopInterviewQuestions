Given an integer, check whether it is a palindrome or not.

Example 1:

Input: n = 55555
Output: Yes

Example 2:

Input: n = 123
Output: No
 

Your Task:
You don't need to read or print anything. Your task is to complete the function is_palindrome() which takes the number as input parameter and returns "Yes" if it is palindrome otherwise returns "No"(Without quotes).
 

Expected Time Complexity: O(x)
Expected Space Complexity: O(x) where x is number of digits in n.
 

Constraints:
1 <= n <= 1000




class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        if (n <= 9)
            return "Yes";
        int temporary = n;
        int possibility = 0;
        while (n > 0) {
            int remainder = n % 10;
            possibility = (possibility * 10) + remainder;
            n /= 10;
        }
        if (possibility == temporary)
            return "Yes";
        return "No";
    }
}
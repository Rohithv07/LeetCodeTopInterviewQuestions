Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

public class Solution {
    public int isPalindrome(int A) {
        int temp = A;
        int pal = 0;
        while (A > 0) {
            int rem = A % 10;
            pal = pal * 10 + rem;
            A /= 10;
        }
        return pal == temp ? 1 : 0;
    }
}


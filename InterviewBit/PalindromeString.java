Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem


public class Solution {
    public int isPalindrome(String A) {
        A = A.toLowerCase();
        A = A.replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = A.length() - 1;
        while (left < right) {
            if (A.charAt(left) != A.charAt(right))
                return 0;
            left += 1;
            right -= 1;
        }
        return 1;
        
    }
}


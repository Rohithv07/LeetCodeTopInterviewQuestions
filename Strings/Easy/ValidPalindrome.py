Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Solution:
class Solution:
    def isPalindrome(self, s: str) -> bool:
        new_string = re.sub(r"[^a-z0-9]+","",s.lower())
        return new_string == new_string[::-1]

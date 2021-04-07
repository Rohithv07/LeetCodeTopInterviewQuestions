You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

 

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
Example 3:

Input: s = "MerryChristmas"
Output: false
Example 4:

Input: s = "AbCdEfGh"
Output: true
 

Constraints:

2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.



class Solution {
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        int mid = length / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        return isThereEqualVowels(firstHalf, secondHalf);
    }
    
    public boolean isThereEqualVowels(String s1, String s2) {
        int vowelCount = 0;
        for (char ch : s1.toCharArray()) {
            if (isAVowel(ch))
                vowelCount += 1;
        }
        for (char ch : s2.toCharArray()) {
            if (isAVowel(ch))
                vowelCount -= 1;
        }
        return vowelCount == 0;
    }
    
    public boolean isAVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            return true;
        return false;
    }
}

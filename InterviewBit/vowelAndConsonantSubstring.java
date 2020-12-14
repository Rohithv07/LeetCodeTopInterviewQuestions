Given a string A consisting of lowercase characters.

You have to find the number of substrings in A which starts with vowel and end with consonants or vice-versa.

Return the count of substring modulo 109 + 7.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.



Input Format
First argument is an string A.



Output Format
Return a integer denoting the the number of substrings in A which starts with vowel and end with consonants or vice-versa with modulo 109 + 7.



Example Input
Input 1:

 A = "aba"
Input 2:

 A = "a"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings of S are : [a, ab, aba, b, ba, a]Out of these only 'ab' and 'ba' satisfy the condition for special Substring. So the answer is 2.
Explanation 2:

 No possible substring that start with vowel and end with consonant or vice-versa.


public class Solution {
    public int solve(String A) {
        if (A.length() == 1)
            return 0;
        int length = A.length();
        int [] countConsonent = new int [length+1];
        int [] countVowel = new int [length + 1];
        if (isConsonent(A.charAt(length - 1)))
            countConsonent[length - 1] = 1;
        else
            countVowel[length - 1] += 1;
        for (int i=length-2; i>=0; i--) {
            if (isConsonent(A.charAt(i))) {
                countConsonent[i] = countConsonent[i+1] + 1;
                countVowel[i] = countVowel[i+1];
            }
            else {
                countVowel[i] = countVowel[i+1] + 1;
                countConsonent[i] = countConsonent[i+1];
            }
        }
        int count = 0;
        for (int i=0; i<length; i++) {
            // If vowel, then count of substrings 
            // starting with str[i] is equal to 
            // count of consonants after it. 
            if (isVowel(A.charAt(i)))
                count = (count + countConsonent[i]) % 1000000007;
            else
                count = (count + countVowel[i]) % 1000000007;
        }
        return count;
    }
    
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
    
    public boolean isConsonent(char ch) {
        if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
            return true;
        return false;
    }
}


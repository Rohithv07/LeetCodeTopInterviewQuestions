Given a String S and an integer K. Find the count of all substrings of length K which have exactly K-1 distinct characters.

 

Example 1:

Input:
S = "abcc"
K = 2
Output:
1
Explanation:
Possible substrings of length K = 2 are
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct character
Only one valid substring exists {"cc"}. 
Example 2:
Input:
S = "aabab"
K = 3
Output :
3
Explanation:
Possible substrings of length K = 3 are
aab : 2 distinct characters
aba : 2 distinct characters
bab : 2 distinct characters.
All of these Substrings are a possible answer,
so the count is 3.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function countOfSubstrings() which takes a String S and an integer K as input and returns the count of substrings of length K having K-1 distinct characters.


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(constant)


Constraints:
1 ≤ K ≤ |S| ≤ 105


class Solution {
    static int countOfSubstrings(String s, int k) {
        // code here
        int [] frequency = new int [26];
        int n = s.length();
        int result = 0;
        for (int i = 0; i < k; i++) {
            int index = s.charAt(i) - 'a';
            frequency[index]++;
        }
        if (isDistinctCharacters(frequency, k)) {
            result++;
        }
        for (int i = k; i < n; i++) {
            int previous = i - k;
            int previousCharIndex = s.charAt(previous) - 'a';
            frequency[previousCharIndex]--;
            int currentIndex = s.charAt(i) - 'a';
            frequency[currentIndex]++;
            if (isDistinctCharacters(frequency, k)) {
                result++;
            }
        }
        return result;
    }
    
    private static boolean isDistinctCharacters(int [] frequency, int k) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                count++;
            }
        }
        if (count == k - 1) {
            return true;
        }
        return false;
    }
}
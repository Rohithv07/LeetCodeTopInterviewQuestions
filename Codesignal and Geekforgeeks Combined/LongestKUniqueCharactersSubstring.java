/*
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:

Input:
S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest 
substring with K distinct characters.
â€‹Example 2:

Input: 
S = "aaaa", K = 2
Output: -1
Explanation: There's no substring with K
distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).




*/



class Solution {
    public int longestkSubstr(String s, int k) {
        // take the count of each characater and check whentehr the unique character > k
        int length = s.length();
        int uniqueCount = 0;
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                uniqueCount += 1;
            }
            count[ch - 'a'] += 1;
        }
        if (uniqueCount < k)
            return -1;
        int currentStart = 0;
        int currentEnd = 0;
        int maxWindowSize = 1;
        int maxWindowStart = 0;
        Arrays.fill(count, 0);
        count[s.charAt(0) - 'a'] += 1;
        for (int i=1; i<length; i++) {
            count[s.charAt(i) - 'a'] += 1;
            currentEnd += 1;
            while (!isValid(count, k)) {
                count[s.charAt(currentStart) - 'a'] -= 1;
                currentStart += 1;
            }
            if (maxWindowSize < currentEnd - currentStart + 1) {
                maxWindowSize = currentEnd - currentStart + 1;
                maxWindowStart = currentStart;
            }
        }
        System.out.println("longest word is " + s.substring(maxWindowStart, maxWindowStart + maxWindowSize));
        return maxWindowSize;
    }
    
    public boolean isValid(int [] count, int k) {
        int value = 0;
        for (int number : count) {
            if (number > 0)
                value += 1;
        }
        return k >= value;
    }
}

Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.



class Solution {
    
    private int maxLength = 0;
    
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        if (arr.size() == 1) {
            return arr.get(0).length();
        }
        dfs(arr, "", 0);
        return maxLength;
    }
    
    public void dfs(List<String>arr, String current, int position) {
        boolean isCurrentUniqueChar = isUniqueChar(current);
        if (isCurrentUniqueChar) {
            maxLength = Math.max(maxLength, current.length());
        }
        if (position == arr.size() || !isCurrentUniqueChar) {
            return;
        }
        for (int i=position; i<arr.size(); i++) {
            dfs(arr, current + arr.get(i), i+1);
        }
    }
    
    private boolean isUniqueChar(String s) {
        int [] count = new int [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int number : count) {
            if (number > 1)
                return false;
        }
        return true;
    }
}

// O(n * 2 ^ n) : this is kind like a subset implementation so for every case you consider add or not, and the way to determine is to do a n check. You can refer 78. Subsets, they are same algorithm actually. Like here it checks every subset to get the max value. O(n!) happens in permutation btw.
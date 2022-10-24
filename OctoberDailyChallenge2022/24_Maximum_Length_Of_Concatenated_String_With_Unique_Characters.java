You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lowercase English letters.


class Solution {
    public int maxLength(List<String> arr) {
        int length = arr.size();
        int [] maxLength = new int [1];
        backtrack(0, arr, "", maxLength);
        return maxLength[0];
    }
    
    private void backtrack(int index, List<String> arr, String current, int [] maxLength) {
        boolean isStringUnique = findIsStringUnique(current);
        if (isStringUnique) {
            maxLength[0] = Math.max(maxLength[0], current.length());
        }
        if (index >= arr.size() || !isStringUnique) {
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            backtrack(i + 1, arr, current + arr.get(i), maxLength);
        }
    }
    
    private boolean findIsStringUnique(String s) {
        boolean [] isPresent = new boolean [26];
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (isPresent[index]) {
                return false;
            }
            isPresent[index] = true;
        }
        return true;
    }
}
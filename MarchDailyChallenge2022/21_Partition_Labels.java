You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.


class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int length = s.length();
        List<Integer> result = new ArrayList<>();
        // this can be optimised to use an array of size 26
        Map<Character, Integer> trackLastOccur = new HashMap<>();
        for (int i = 0; i < length; i++) {
            trackLastOccur.put(s.charAt(i), i);
        }
        int starting = 0;
        while (starting < length) {
            char currentChar = s.charAt(starting);
            int lastIndex = trackLastOccur.get(currentChar);
            int ending = starting;
            while (ending != lastIndex) {
                lastIndex = Math.max(lastIndex, trackLastOccur.get(s.charAt(ending++)));
            }
            result.add(ending - starting + 1);
            starting = ending + 1;
        }
        return result;
    }
}
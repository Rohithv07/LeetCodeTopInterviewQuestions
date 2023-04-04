Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

 

Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.
Example 2:

Input: s = "ssssss"
Output: 6
Explanation:
The only valid partition is ("s","s","s","s","s","s").
 

Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.


class Solution {
    public int partitionString(String s) {
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < s.length(); i ++){
            //char at that index present in the hashset
            if(hs.contains(s.charAt(i))){
                //increase the count by 1
                count++;
                //clear the hashset so that it can again start collecting new unique char.
                hs.clear();
            }
            hs.add(s.charAt(i));
        }
        //returning count + 1 because we are counting total cuts in 
        //the string and we need to return total new substrings
        return count+1;
    }
}
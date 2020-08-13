Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

Solution : O(NK), where N is the length of strs, and K is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> result = new HashMap();
        int [] countAlphabets = new int[26];
        for (String s: strs){
            Arrays.fill(countAlphabets, 0);
            for (char character: s.toCharArray())
                countAlphabets[character - 'a'] ++;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++){
                sb.append('*');
                sb.append(countAlphabets[i]);
            }
            String mapKey = sb.toString();
            if (!result.containsKey(mapKey))
                result.put(mapKey, new ArrayList());
            result.get(mapKey).add(s);
        }
        return new ArrayList(result.values());
    }
}

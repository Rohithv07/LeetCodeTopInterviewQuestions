All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.

// we can store the 10 letter substring in a hashmap and track the count too.
// if we get the count == 2, as we dont want duplicates, we add that substring into the result.
// we loop from i+10 to len(s)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i+10 <= s.length()) {
            String subS = s.substring(i, i++ + 10); // we increment the i the same time.
            map.put(subS, map.getOrDefault(subS, 0) + 1);
            if (map.get(subS) == 2)
                result.add(subS);
        }
        return result;
    }
}

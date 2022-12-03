Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.


class Solution {
    public String frequencySort(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        Pair [] pair = new Pair[256];
        for (char ch : s.toCharArray()) {
            if (pair[ch] == null) {
                pair[ch] = new Pair(ch, 1);
            }
            else {
                pair[ch].freq += 1;
            }
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.freq, p1.freq));
        for (Pair p : pair) {
            if (p != null) {
                maxHeap.offer(p);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            char currentChar = current.ch;
            int currentFreq = current.freq;
            while (currentFreq-- > 0) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
} 

class Pair {
    char ch;
    int freq;
    
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
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
        if (s == null || s.length() == 0) {
            return "";
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
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair2.freq, pair1.freq));
        StringBuilder result = new StringBuilder();
        for (Pair p : pair) {
            if (p != null)
                maxHeap.offer(p);
        }
        while (!maxHeap.isEmpty()) {
            Pair currentPair = maxHeap.poll();
            int frequency = currentPair.freq;
            while (frequency-- > 0) {
                result.append(currentPair.ch);
            }
        }
        return result.toString();
    }
}

class Pair {
    char ch;
    int freq;
    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

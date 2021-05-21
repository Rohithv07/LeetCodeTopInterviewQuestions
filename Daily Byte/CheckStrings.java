/*
Given two string arrays, word1 and word2, return whether or not the two arrays represent the same string.

Ex: Given the following word1 and word2…

word1 = ["abc", "d"], word2 = ["ab", "cd"], return true.
Ex: Given the following word1 and word2…

word1 = ["a", "b", "c"], word2 = ["a", "b", "d"], return false.
*/


class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null)
            return false;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String word : word1)
            sb1.append(word);
        for (String word : word2)
            sb2.append(word);
        return sb1.toString().equals(sb2.toString());
    }
}

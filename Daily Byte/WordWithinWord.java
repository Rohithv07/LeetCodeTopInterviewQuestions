/*
Given an array of words, return all strings in words that are a substring of another word.
Note: The order in which you return the substrings does not matter.

Ex: Given the following words…

words = ["abc", "a", "b"], return ["a", "b"].
Ex: Given the following words…

words = ["ab", "ba", "c"], return [].
*/



class Solution {
    public List<String> stringMatching(String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<>();
        Set<String> set = new HashSet<>();
        int length = words.length;
        for (int i=0; i<length; i++) {
            String currentWord = words[i];
            for (int j=i+1; j<length; j++) {
                String nextWord = words[j];
                if (currentWord.contains(nextWord)) {
                    set.add(nextWord);
                }
                if (nextWord.contains(currentWord)) {
                    set.add(currentWord);
                }
            }
        }
        List<String> result = new ArrayList<>(set);
        return result;
    }
}

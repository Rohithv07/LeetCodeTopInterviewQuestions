A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            count += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return count;
                }
                char [] currentArray = current.toCharArray();
                for (int pos = 0; pos < beginWord.length(); pos++) {
                    char currentChar = currentArray[pos];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentArray[pos] = ch;
                        String newString = String.valueOf(currentArray);
                        if (newString.equals(endWord)) {
                            return count += 1;
                        }
                        if (!wordSet.contains(newString)) {
                            continue;
                        }
                        wordSet.remove(newString);
                        queue.offer(newString);
                    }
                    currentArray[pos] = currentChar;
                }
            }
        }
        return 0;
    }
}
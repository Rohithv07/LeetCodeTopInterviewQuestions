Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        int length = 0;
        int beginWordLength = beginWord.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            length += 1;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                char [] word = queue.poll().toCharArray();
                for (int pos=0; pos<beginWordLength; pos++) {
                    char originalChar = word[pos];
                    for (char c='a'; c<='z'; c++) {
                        word[pos] = c;
                        if (String.valueOf(word).equals(endWord))
                            return length + 1;
                        if (!wordSet.contains(String.valueOf(word)))
                            continue;
                        wordSet.remove(String.valueOf(word));
                        queue.add(String.valueOf(word));
                    }
                    word[pos] = originalChar;
                }
            }
        }
        return 0;
    }
}

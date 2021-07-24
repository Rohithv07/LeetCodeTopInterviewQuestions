A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 1000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.




// Node maintains current word and distance/path from startWord to it
class Node {
    String word;
    int distance;
    List<String> path;
    Node(String word, int distance, List<String> path) {
        this.word = word;
        this.distance = distance;
        this.path = path;
    }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        
        Set<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        
        Set<String> visited = new HashSet<>();
        
        Queue<Node> queue = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        Node beginNode = new Node(beginWord, 1, temp);
        queue.offer(beginNode);
        
        Integer shortestDist = null;
        
        while (!queue.isEmpty()) {
            // Record what we meet at this level
            Set<String> thisLevelVisited = new HashSet<>();
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Node curNode = queue.poll();
                
                // If this level has a distance greater than shortest distance, we don't need to consider it any more
                if (shortestDist != null && curNode.distance > shortestDist) {
                    continue;
                }
                
                // If we find the endWord, then we have the shortest distance
                if (curNode.word.equals(endWord)) {
                    if (shortestDist == null) {
                        shortestDist = curNode.distance;
                    }
                    res.add(curNode.path);
                    continue;
                }
                
                List<String> nextWords = findNextWords(curNode.word, wordDict, visited);
                for (String nextWord : nextWords) {
                    List<String> newPath = new ArrayList<>(curNode.path);
                    newPath.add(nextWord);
                    queue.offer(new Node(nextWord, curNode.distance + 1, newPath));
                    thisLevelVisited.add(nextWord); 
                }
            }
            
            // Add what we meet in this level to total visited word set
            visited.addAll(thisLevelVisited);
        }
        
        return res;
    }
    
    private List<String> findNextWords(String curWord, Set<String> wordDict, Set<String> visited) {
        List<String> res = new ArrayList<>();
        
        char[] letters = curWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char originLetter = letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originLetter) {
                    continue;
                }

                letters[i] = c;
                String nextWord = new String(letters);
                if (wordDict.contains(nextWord) && !visited.contains(nextWord)) {
                    res.add(nextWord);
                }
            }
            letters[i] = originLetter;
        }
        
        return res;
    }
}
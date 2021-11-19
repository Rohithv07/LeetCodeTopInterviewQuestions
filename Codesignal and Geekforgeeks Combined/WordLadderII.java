Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList.
Return an empty list if there is no such transformation sequence.
The first part of this problem can be found here.


Example 1:

Input:
startWord = "der", targetWord = "dfs",
wordList = {"des","der","dfr","dgt","dfs"}
Output:
der dfr dfs
der des dfs
Explanation:
The length of the smallest transformation is 3.
And the following are the only two ways to get
to targetWord:-
"der" -> "des" -> "dfs".
"der" -> "dfr" -> "dfs".
Example 2:

Input:
startWord = "gedk", targetWord = "geek", 
wordList = {"geek", "gefk"}
Output:
"gedk" -> "geek"

Your Task:
You don't need to read or print anything, Your task is to complete the function findSequences() which takes startWord, targetWord and wordList as input parameter and returns a list of list of strings of the shortest transformation sequence from startWord to targetWord.
Note: You don't have to return -1 in case of no possible sequence. Just return the Empty List.


Expected Time Compelxity: O(N*(logN * M * 26))
Expected Auxiliary Space: O(N * M) where N = length of wordList and M = |wordListi|


Constraints:
1 ≤ N ≤ 100
1 ≤ M ≤ 10



class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if (wordList == null || wordList.length == 0) {
            return res;
        }
        
        Set<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        
        Set<String> visited = new HashSet<>();
        
        Queue<Node> queue = new LinkedList<>();
        ArrayList<String> temp = new ArrayList<>();
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
                
                ArrayList<String> nextWords = findNextWords(curNode.word, wordDict, visited);
                for (String nextWord : nextWords) {
                    ArrayList<String> newPath = new ArrayList<>(curNode.path);
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
    
    private ArrayList<String> findNextWords(String curWord, Set<String> wordDict, Set<String> visited) {
        ArrayList<String> res = new ArrayList<>();
        
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


class Node {
    String word;
    int distance;
    ArrayList<String> path;
    Node(String word, int distance, ArrayList<String> path) {
        this.word = word;
        this.distance = distance;
        this.path = path;
    }
}
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
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.


/*
We start from a begin word, and try out each and every possiblity of english alphabets and check whether each of possible words are already provided in the wordlist. If present, we can again make use of that word to try and reach the end word.
Now this is a kind of search, where we are trying to replace each and every letter and checking newly formed strings are in the word list. So this a bfs.
Now inside the bfs, we will add the starting word into the queue and do the necessary items.
Instead of just adding the starting word alone, we just create a ds, which holds the word, the distance that it takes to reach from the very starting word and a list which tracks the path being taken to reach there.
So we will be adding each and every node to the queue, replacing all the letters during the bfs and when we reach the end word at any instance, it will be shortest distance becuase we will confirm it by checking whether the distance that its taken so far is not exceeding in other paths.



*/


// this approach is now giving TLE due to some refined test cases

class Node {
    String word;
    int distanceToReachWord;
    List<String> pathToReachWord;
    
    public Node(String word, int distanceToReachWord, List<String> pathToReachWord) {
        this.word = word;
        this.distanceToReachWord = distanceToReachWord;
        this.pathToReachWord = pathToReachWord;
    }
}


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || wordList.size() == 0 || beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return result;
        }
        
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return result;
        }
        List<String> starting = new ArrayList<>();
        starting.add(beginWord);
        Node startingNode = new Node(beginWord, 1, starting);
        bfs(result, endWord, wordSet, startingNode);
        return result;
    }
    
    private void bfs(List<List<String>> result, String endWord, Set<String> wordSet, Node startingNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startingNode);
        Set<String> visited = new HashSet<>();
        visited.add(startingNode.word);
        int shortestDistanceRecorded = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Set<String> wordsVisitedThisLevel = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                String currentWord = currentNode.word;
                int currentDistance = currentNode.distanceToReachWord;
                List<String> currentPath = currentNode.pathToReachWord;
                if (shortestDistanceRecorded != Integer.MAX_VALUE && currentDistance > shortestDistanceRecorded) {
                    // this step will ensure we always find the shortest path
                    continue;
                }
                if (currentWord.equals(endWord)) {
                    shortestDistanceRecorded = currentDistance;
                    result.add(currentPath);
                    continue;
                }
                List<String> nextPossibility = findAllPossibility(currentWord, visited, wordSet);
                for (String nextPossible : nextPossibility) {
                        List<String> nextPath = new ArrayList<>(currentPath);
                        nextPath.add(nextPossible);
                        queue.offer(new Node(nextPossible, currentDistance + 1, nextPath));
                        wordsVisitedThisLevel.add(nextPossible);
                }
            }
            visited.addAll(wordsVisitedThisLevel);
        }
    }
    
    private List<String> findAllPossibility(String word, Set<String> visited, Set<String> wordSet) {
        List<String> possibilities = new ArrayList<>();
        char [] everyLetter = word.toCharArray();
        for (int i = 0; i < everyLetter.length; i++) {
            char currentLetter = everyLetter[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == currentLetter) {
                    continue;
                }
                everyLetter[i] = ch;
                String possibleWord = new String(everyLetter);
                if (visited.contains(possibleWord)) {
                    continue;
                }
                if (wordSet.contains(possibleWord)) {
                    possibilities.add(possibleWord);
                }
            }
            // bringing back the changed letter
            everyLetter[i] = currentLetter;
        }
        return possibilities;
    } 
    
}


// accepted copied solution


public class Solution {
     List<List<String>> res;
     Map<Integer, Set<String>> map;
     Set<String> set;
     int goal;
     String es;
     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new LinkedList<>();
        set = new HashSet<>(wordList);
        es = endWord;
        if(!set.contains(endWord)) return(res);
        int step = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        map = new HashMap<>();
        boolean found = false;
        while(!q.isEmpty()){
            int sz = q.size();
            map.put(step, new HashSet<>());
            while(sz-- > 0){
                String cs = q.poll();
                map.get(step).add(cs);
                if(cs.equals(endWord)){
                    found = true;
                    break;
                }
                Set<String> nbrs = nb(cs, set, seen);
                for(String ns: nbrs){
                    q.offer(ns);
                }
            }
            if(found) break;
            step++;
        }
        if(!found) return(res);
        //System.out.println(step);
        //System.out.println(map);
        goal = step;
        List<String> list = new LinkedList<>();
        list.add(es);
        dfs(es, goal, list);
        return(res);
    }
    
    public void dfs(String s, int level, List<String> list){
        if(level == 0){
            List<String> copy = new LinkedList<>(list);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }
        Set<String> nbrs = new HashSet<>();
        for(String nss: map.get(level - 1)){
            if(isnb(nss, s)) nbrs.add(nss);
        }
        for(String ns: nbrs){
            list.add(ns);
            dfs(ns, level - 1, list);
            list.remove(list.size() - 1);
        }
    }
    public boolean isnb(String s1, String s2){
        int n = s1.length();
        int d = 0;
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)) d++;
        }
        return(d == 1);
    }
    public Set<String> nnb(String s, Set<String> set, int dep){
        Set<String> res = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            int chi = s.charAt(i) - 'a';
            for(int j = 0; j < 26; j++){
                if(j == chi) continue;
                String ns = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1);
            }
        }
        return(res);
    }
    public Set<String> nb(String s, Set<String> set, Set<String> seen){
        Set<String> res = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            int chi = s.charAt(i) - 'a';
            for(int j = 0; j < 26; j++){
                if(j == chi) continue;
                String ns = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1);
                if(set.contains(ns) && seen.add(ns)) res.add(ns);
                
            }
        }
        return(res);
    }
}

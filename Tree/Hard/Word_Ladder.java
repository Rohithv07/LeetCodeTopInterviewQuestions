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
                char [] word = queue.peek().toCharArray();
                queue.remove();
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

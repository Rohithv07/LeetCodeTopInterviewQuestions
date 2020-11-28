Given two words, beginWord and endWord, and a wordList of approved words, find the length of the shortest transformation sequence from beginWord to endWord such that:

Only one letter can be changed at a time
Each transformed word must exist in the wordList.
Return the length of the shortest transformation sequence, or 0 if no such transformation sequence exists.

Note: beginWord does not count as a transformed word. You can assume that beginWord and endWord are not empty and are not the same.

Example

For beginWord = "hit", endWord = "cog", and wordList = ["hot", "dot", "dog", "lot", "log", "cog"], the output should be
wordLadder(beginWord, endWord, wordList) = 5.

The shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with a length of 5.




int wordLadder(String beginWord, String endWord, String[] wordList) {
	Set<String> wordSet = new HashSet(Arrays.asList(wordList));
	if (!wordSet.contains(endWord))
		return 0;
	int length = 0;
	int beginLength = beginWord.length();
	Queue<String> queue = new LinkedList<>();
	queue.add(beginWord);
	while(!queue.isEmpty()) {
		length += 1;
		int size = queue.size();
		for (int i=0; i<size; i++) {
			char [] word = queue.peek().toCharArray();
			queue.remove();
			for (int pos=0; pos<beginLength; pos++) {
				char original = word[pos];
				for (char c='a'; c<='z'; c++) {
					word[pos] = c;
					if (String.valueOf(word).equals(endWord))
						return length + 1;
					if (!wordSet.contains(String.valueOf(word)))
						continue;
					wordSet.remove(String.valueOf(word));
					queue.add(String.valueOf(word));
				}
				word[pos] = original;
			}
		}
	}
	return 0;
}




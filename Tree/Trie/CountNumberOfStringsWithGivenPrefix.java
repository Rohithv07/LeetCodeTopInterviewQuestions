class TrieNode {
	char ch;
	int prefixCount = 0;
	TrieNode [] array = new TrieNode[26];
}

class CountNumberOfStringsWithGivenPrefix {
	TrieNode root = null;
	public CountNumberOfStringsWithGivenPrefix() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.array[index] == null) {
				node.array[index] = new TrieNode();
				node.array[index].ch = ch;
				node.array[index].prefixCount = 1;
			}
			else {
				node.array[index].prefixCount += 1;
			}
			node = node.array[index];
		}
	}

	public int countPrefix(String prefix) {
		TrieNode node = root;
		for (char ch : prefix.toCharArray()) {
			int index = ch - 'a';
			if (node.array[index] == null) {
				return 0;
			}
			node = node.array[index];
		}
		return node.prefixCount;
	}

	public static void main(String [] args) {
		CountNumberOfStringsWithGivenPrefix countNumberOfStringsWithGivenPrefix = new CountNumberOfStringsWithGivenPrefix();
		countNumberOfStringsWithGivenPrefix.insert("abac");
		countNumberOfStringsWithGivenPrefix.insert("abaa");
		countNumberOfStringsWithGivenPrefix.insert("abab");
		countNumberOfStringsWithGivenPrefix.insert("aabb");
		countNumberOfStringsWithGivenPrefix.insert("aabc");
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("ab"));
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("aba"));
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("abaa"));
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("ac"));
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("aa"));
		System.out.println(countNumberOfStringsWithGivenPrefix.countPrefix("a"));
		
		

	}
}
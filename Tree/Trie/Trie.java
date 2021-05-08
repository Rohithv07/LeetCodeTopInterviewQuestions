class TrieNode {
	char ch;
	TrieNode [] array = new TrieNode[26];
	int wordEnd = 0;
}

public class Trie {
	TrieNode root = null;
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.array[index] == null) {
				node.array[index] = new TrieNode();
				node.array[index].ch = ch;
				node.array[index].wordEnd = 0;	
			}
			node = node.array[index];
		}
		node.wordEnd += 1;
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.array[index] == null)
				return false;
			node = node.array[index];
		}
		return node.wordEnd >= 1;
	}

	public void delete(String word) {
		if (search(word)) {
			TrieNode node = root;
			for (char ch : word.toCharArray()) {
				int index = ch - 'a';
				node = node.array[index];
			}
			node.wordEnd -= 1;
			System.out.println("Deleted");
		}
		else {
			System.out.println("Cannot delete");
		}
	}

	public boolean isPrefix(String word) {
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';
			if (node.array[index] == null)
				return false;
			node = node.array[index];
		}
		return true;
	}

	// public int prefixCount(String word) {
	// 	TrieNode node = root;
	// 	for (char ch : word.toCharArray()) {
	// 		int index = ch - 'a';
	// 		if (node.array[index] == null)
	// 			return 0;
	// 		node = node.array[index];
	// 	}
	// 	return node.wordEnd + 1;
	// }

	public static void main(String [] args) {
		Trie trie = new Trie();
		String a = "abcd";
		String b = "cd";
		String c = "ab";
		trie.insert(a);
		trie.insert(a);
		trie.insert(b);
		trie.insert(c);
		System.out.println(trie.search(a)); // true
		System.out.println(trie.search(b)); // true
		System.out.println(trie.search(c)); // true
		System.out.println(trie.isPrefix("p")); // false;
		trie.delete(a);
		System.out.println(trie.search(a)); // true;
		trie.delete(a);	
		trie.delete(a);
		//System.out.println(trie.prefixCount("a"));

	}
}
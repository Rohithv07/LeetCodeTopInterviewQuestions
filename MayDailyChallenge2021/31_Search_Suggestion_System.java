class Solution {
    
    private TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()){
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
            node.suggestion.offer(word);
            if (node.suggestion.size() > 3) {
                node.suggestion.pollLast();
            }
        }
    }
    
    public List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char ch : searchWord.toCharArray()) {
            int index = ch - 'a';
            if (node != null) {
                node = node.child[index];
            }
            result.add(node == null ? Arrays.asList() : node.suggestion);
        }
        return result;
    }
    
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            insert(product);
        }
        return search(searchWord);
    }
}

class TrieNode {
    TrieNode [] child = new TrieNode [26];
    LinkedList<String> suggestion = new LinkedList<>();
}


/*
Complexity depends on the process of building Trie and the length of searchWord. Building Trie cost time O(m * m * n), due to involving comparing String, which cost time O(m) for each comparison. Therefore,
Time: O(m * m * n + L), space: O(m * n + L * m) - including return list ans, where m = average length of products, n = products.length, L = searchWord.length().
*/

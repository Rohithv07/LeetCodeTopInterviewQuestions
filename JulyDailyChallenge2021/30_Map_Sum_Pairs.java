Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 

Example 1:

Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]

Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 

Constraints:

1 <= key.length, prefix.length <= 50
key and prefix consist of only lowercase English letters.
1 <= val <= 1000
At most 50 calls will be made to insert and sum.



class MapSum {

    /** Initialize your data structure here. */
    private TrieNode root;
    
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insertToTrie(String s, int val) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
                node.child[index].ch = ch;
            }
            node = node.child[index];
        }
        node.currentWordValue = val;
    }
    
    public int searchInTrie(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null)
                return 0;
            node = node.child[index];
        }
        return findByDfs(node);
    }
    
    public void insert(String key, int val) {
        insertToTrie(key, val);
    }
    
    public int sum(String prefix) {
        return searchInTrie(prefix);
    }
    
    public int findByDfs(TrieNode node) {
        int sum = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.child[ch - 'a'] != null)
                sum += findByDfs(node.child[ch - 'a']);
        }
        return sum + node.currentWordValue;
    }
}

class TrieNode {
    char ch;
    int currentWordValue = 0;
    TrieNode[] child = new TrieNode[26];
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
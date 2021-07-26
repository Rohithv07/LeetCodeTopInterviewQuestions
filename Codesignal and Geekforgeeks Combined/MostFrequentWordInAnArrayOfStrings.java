Given an array arr containing N words consisting of lowercase characters. Your task is to find the most frequent word in the array. If multiple words have same frequency, then print the word whose first occurence occurs last in the array as compared to the other strings with same frequency.

Example 1:

Input:
N = 3
arr[] = {geeks,for,geeks}
Output: geeks
Explanation: "geeks" comes 2 times.
Example 2:

Input:
N = 2
arr[] = {hello,world}
Output: world
Explanation: "hello" and "world" both
have 1 frequency. We print world as
its first occurence comes last in the
input array.
Your Task:
Complete mostFrequentWord function which takes array of strings and its length as arguments and returns the most frequent word. The printing is done by the driver code.

Expected Time Complexity: O(N * WORD_LEN).
Expected Auxiliary Space: O(N * WORD_LEN).

Constraints:
1 <= N <= 50000
1 <= |each string| <= 50
Sum of length of every string does not exceed 5*105



class Solution
{
    private TrieNode root = new TrieNode();
    //Function to find most frequent word in an array of strings.
    
    private void insert(String word, int index) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (node.child[ind] == null) {
                node.child[ind] = new TrieNode();
            }
            node = node.child[ind];
        }
        node.word = word;
        node.count += 1;
        if (node.index == -1)
            node.index = index;
    }
    
    private void search(String word, PriorityQueue<TrieNode> maxHeap) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null)
                return;
            node = node.child[index];
        }
        maxHeap.offer(node);
    }
    public String mostFrequentWord(String s[],int n)
    {
        // code here
        if (s == null || n == 0)
            return "";
        for (int i=0; i<n; i++) {
            String word = s[i];
            insert(word, i);
        }
        PriorityQueue<TrieNode> maxHeap = new PriorityQueue<>((node1, node2) ->
        node1.count == node2.count ? Integer.compare(node2.index, node1.index) : 
        Integer.compare(node2.count, node1.count));
        for (String word : s) {
            search(word, maxHeap);
        }
        return maxHeap.peek().word;
    }
    

}

class TrieNode {
    char ch;
    String word;
    TrieNode [] child = new TrieNode[26];
    int count = 0;
    int index = -1;
}
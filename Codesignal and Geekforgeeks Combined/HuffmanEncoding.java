Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.
Note: If two elements have same frequency, then the element which occur at first will be taken on the left of Binary Tree and other one to the right.

Example 1:

S = "abcdef"
f[] = {5, 9, 12, 13, 16, 45}
Output: 
0 100 101 1100 1101 111
Explanation:
HuffmanCodes will be:
f : 0
c : 100
d : 101
a : 1100
b : 1101
e : 111
Hence printing them in the PreOrder of Binary 
Tree.
Your Task:
You don't need to read or print anything. Your task is to complete the function huffmanCodes() which takes the given string S, frequency array f[ ] and number of characters N as input parameters and returns a vector of strings containing all huffman codes in order of preorder traversal of the tree.

Expected Time complexity: O(N * LogN) 
Expected Space complexity: O(N) 

Constraints:
1 ≤ N ≤ 26


class Solution {
    public ArrayList<String> huffmanCodes(String s, int f[], int n)
    {
        // Code here
        if (s == null || f == null || n == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new MyComparator());
        for (int i=0; i<n; i++) {
            queue.offer(new Node(f[i]));
        }
        while (queue.size() != 1) {
            Node first = queue.poll();
            Node second = queue.poll();
            Node resultant = new Node(first.freq + second.freq);
            resultant.left = first;
            resultant.right = second;
            queue.offer(resultant);
        }
        ArrayList<String> result = new ArrayList<>();
        Node root = queue.poll();
        preorder(result, root, "");
        return result;
    }
    
    public void preorder(ArrayList<String> result, Node node, String s) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(s);
        }
        preorder(result, node.left, s + "0");
        preorder(result, node.right, s + "1");
    }
}

class Node {
    int freq;
    Node left;
    Node right;
    Node(){}
    Node(int freq) {
        this.freq = freq;
    }
    Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

class MyComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
        if (node1.freq == node2.freq) {
            return 1;
        }
        return Integer.compare(node1.freq, node2.freq);
    }
}
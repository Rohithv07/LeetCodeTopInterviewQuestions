https://www.hackerrank.com/challenges/tree-huffman-decoding/problemimport java.util.*;
 
abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends Node {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

	void decode(String s, Node root) {
        
        Node temp = root;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '0')
                temp = temp.left;
            else
                temp = temp.right;
            if (temp.left == null && temp.right == null) { // leaf node
                sb.append(temp.data);
                temp = root;
            }
        }
       System.out.println(sb.toString());
    }



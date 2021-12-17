There is BST given with root node with key part as integer only. You need to find the inorder successor and predecessor of a given key. In case, if the either of predecessor or successor is not found print -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains n denoting the number of edges of the BST. The next line contains the edges of the BST. The last line contains the key.

Output:
Print the predecessor followed by successor for the given key. If the predecessor or successor is not found print -1.

Constraints:
1<=T<=100
1<=n<=100
1<=data of node<=100
1<=key<=100

Example:
Input:
2
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
65
6
50 30 L 30 20 L 30 40 R 50 70 R 70 60 L 70 80 R
100

Output:
60 70
80 -1




/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    static int pre = -1;
    static int succ = -1;
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       // successor - immediate smallest number greater than key node 
       // predecessor - immediate largest number lesser than key node
       if (root == null) {
           return;
       }
       traverse(root, key);
       p.pre = new Node(pre);
       s.succ = new Node(succ);
       pre = -1;
       succ = -1;
    }
    
    public static void traverse(Node node, int key) {
        if (node == null) {
            return;
        }
        if (node.data < key) {
            if (pre == -1) {
                pre = node.data;
            }
            else
                pre = Math.max(pre, node.data);
        }
        if (node.data > key) {
            if (succ == -1) {
                succ = node.data;
            }
            else
                succ = Math.min(succ, node.data);
        }
        traverse(node.left, key);
        traverse(node.right, key);
    }
}
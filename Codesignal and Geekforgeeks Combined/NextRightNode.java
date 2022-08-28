Given a Binary tree and a key in the binary tree, find the node right to the given key. If there is no node on right side, then return a node with value -1.

Example 1:

Input:

       10
     /    \
    2      6
   / \      \
  8   4      5
and key = 2
Output: 6
Explanation: We can see in the above tree
that the next right node of 2 is 6.
Example 2:

Input:
      10
    /     \
   2       6
  / \       \
 8   4       5
and key = 5
Output: -1
Explanation: We can see in the above tree 
that there's No next right node of 5.
So, the output is -1.
Your Task:
You don't need to read input or print anything. Your task is to complete the function nextRight() which takes root node of the tree and an integer key as input parameters and returns the next right node of the node with value key. 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=103
1<=data of node<=103
1<=key<=103



class Solution{
	Node nextRight(Node root, int key)
    {
		//Write your code here
		if (root == null) {
		    return new Node(-1);
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
		    int size = queue.size();
		    for (int i = 0; i < size; i++) {
		        Node current = queue.poll();
		        if (current.data == key) {
		            if (i != size - 1) {
		                return queue.poll();
		            }
		            else {
		                return new Node(-1);
		            }
		        }
		        if (current.left != null) {
		            queue.offer(current.left);
		        }
		        if (current.right != null) {
		            queue.offer(current.right);
		        }
		    }
		}
		return new Node(-1);
    }
}
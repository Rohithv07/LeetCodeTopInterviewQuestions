Given an n-ary tree, return its level order traversal.
Note: an n-ary tree is a tree in which each node has no more than N children.

Ex: Give the following n-ary tree…

    8
  / | \
 2  3  29
return [[8], [2, 3, 29]]
Ex: Given the following n-ary tree…

     2
   / | \
  1  6  9
 /   |   \
8    2    2
   / | \
 19 12 90
return [[2], [1, 6, 9], [8, 2, 2], [19, 12, 90]]

// here we can do a BFS search. But here we can't deal with say node.left, node.right checking as there can be n children for a node.
// so a list of children will be provided and these children must be also added and considered

     2
   / | \
  1  6  9     -> At first we add 2, then we add all its children to the queue and pops out 2 -> [[2]]
 /   |   \    -> Next we take 1, 6, 9 , find their children and add them into the queue adn pops each 1, 6, 9 ->[[2],[1,6,9]]
8    2    2   -> Same way we do for 8, 2, 2 and also 19, 12, 90 and add them into the list and our final answer become [[2],[1,6,9],[8,2,2],[19,12,90]]
   / | \
 19 12 90


// Since we are doing a BFS here and we are going through all the node time = O(nodes) and space = O(width)

public class Node {
	int val;
	List<Node> children;
	Node(){};
	Node(int val){this.val = val;}
	Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}
}
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		// 1. initialise our result holding variable
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		// 2. Initialize queue for BFS
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root); //start by adding the root
		while (!queue.isEmpty()) {
			List<Integer> current = new ArrayList<>(); // inorder to store the current level items
			int size = queue.size();
			for (int i=0; i<size; i++) {
				Node temp = queue.poll(); // pop out the first element from the queue.
				current.add(temp.val);   // add the element into current list.
				queue.addAll(temp.children); // add all the children of the node to the queue.
			}
			result.add(current);  // we have all the elements of current level and add it into the final result
		}
		return result;
	}
}


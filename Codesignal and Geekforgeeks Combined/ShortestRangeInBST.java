Given a BST (Binary Search Tree), find the shortest range [x, y], such that, at least one node of every level of the BST lies in the range.
If there are multiple ranges with the same gap (i.e. (y-x)) return the range with the smallest x.

Example 1:

Input:
              8
          /   \
         3     10
       /  \      \
      2    6      14
          / \     /
         4   7   12
                /  \
               11   13
Output: 6 11
Explanation: Level order traversal of the tree 
is [8], [3, 10], [2, 6, 14], [4, 7, 12], [11, 13]. 
The shortest range which satisfies the above 
mentioned condition is [6, 11]. 

Example 2:

Input:
   12
    \
     13
       \
        14
         \
          15
           \
           16

Output: 12 16
Explanation: Each level contains one node, 
so the shortest range is [12, 16].

Your Task:
You don't need to read input or print anything. Complete the function shortestRange() which takes the root of the tree as an input parameter and returns the pair of numbers

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ Node Value ≤ 104

class Solution {
    public Range shortestRange(Node root) {
        // inOrder: stores inorder traversal of the bst
        // level: stores level of ith node in inorder traversal
        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        storeInOrder(root, 0, inOrder, level);
        /*
            cntZero: counts number of zeros
            i: left pointer (initially at 0)
            j: right pointer
            k: index of root in inorder traversal
            maxDepth: maximum depth of bst
            Note: these pointers are on the inorder traversal of the tree
        */
        int i = 0, j = 0, k = 0, cntZero = 0,
            maxDepth = Collections.max(level) + 1;
        // stores number of nodes at ith level
        int[] depth = new int[maxDepth];
        // first count number of nodes at ith level till the root
        // right pointer initially is at root's index in inorder traversal of
        // bst
        for (k = 0; k < level.size(); k++) {
            depth[level.get(k)]++;
            if (level.get(k) == 0) {
                j = k;
                break;
            }
        }
        // count number of levels where there are 0 nodes in the range
        // inorder[i] to inorder[j]
        for (int u : depth) {
            if (u == 0) {
                cntZero++;
            }
        }
        // intially shortest range is [x, y]
        // x=node at 0th index
        // y=node at last index
        // i.e. the whole tree
        int x = inOrder.get(0), y = inOrder.get(inOrder.size() - 1);
        // if currently picked range contains all levels change x and y
        // accordingly
        if (cntZero == 0) {
            x = inOrder.get(i);
            y = inOrder.get(j);
        }
        // left pointer can at most go upto root's index(i.e. k)
        // right pointer can go upto last index of inorder traversal of tree
        while (i <= k && j < inOrder.size()) {
            // while right pointer doesn't reach last index
            // and the current range doesn't contain all levels
            while (j < inOrder.size()) {
                // if cntZero is 0 then this range contains all levels
                if (cntZero == 0) {
                    // if previous range is large then change the range
                    if ((y - x) > (inOrder.get(j) - inOrder.get(i))) {
                        x = inOrder.get(i);
                        y = inOrder.get(j);
                    }
                    break;
                }
                j++;
                if (j >= inOrder.size()) {
                    break;
                }
                // if new level is discovered by this range then cntZero is
                // decreased by 1
                if (depth[level.get(j)] == 0) {
                    cntZero--;
                }
                depth[level.get(j)]++;
            }
            // while current range contains all levels
            // we can shift the left pointer by +1
            while (cntZero == 0 && i <= k) {
                if ((y - x) > (inOrder.get(j) - inOrder.get(i))) {
                    x = inOrder.get(i);
                    y = inOrder.get(j);
                }
                depth[level.get(i)]--;
                // if this level is outside the current range then cntZero is
                // increased by 1
                if (depth[level.get(i)] == 0) {
                    cntZero++;
                }
                i++;
            }
        }
        return new Range(x, y);
    }

    /*
        root: current node
        depth: depth of current node
        inOrder: inorder traversal of tree
        level: stores levels of the nodes
    */
    public void storeInOrder(Node root, int depth, ArrayList<Integer> inOrder,
                      ArrayList<Integer> level) {
        if (root == null) return;
        // recur for left subtree
        storeInOrder(root.left, depth + 1, inOrder, level);
        // store inorder
        inOrder.add(root.data);
        // store depth of that node
        level.add(depth);
        storeInOrder(root.right, depth + 1, inOrder, level);
    }
}

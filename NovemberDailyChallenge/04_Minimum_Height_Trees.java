A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
Example 3:

Input: n = 1, edges = []
Output: [0]
Example 4:

Input: n = 2, edges = [[0,1]]
Output: [0,1]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.



// start pointers from all leaf nodes
/*
Start pointers from all leaf nodes and move one step inside each time, keep combining pointers which overlap while moving, at the end only one pointer will remain on some vertex or two pointers will remain at one distance away. Those nodes represent the root of the vertex which will minimize the height of the tree. 
So we can have only one root or at max two roots for minimum height depending on tree structure as explained above. For the implementation we will not use actual pointers instead we’ll follow BFS like approach, In starting all leaf node are pushed into the queue, then they are removed from the tree, next new leaf node is pushed in the queue, this procedure keeps on going until we have only 1 or 2 node in our tree, which represent the result. 
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1 && edges.length == 0) {
            result.add(0);
            return result;
        }
        // build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++)
            adj.add(new LinkedList<>());
        int [] degree = new int [n]; // for tracking leaf node or not. Here degree == 1 mean its leaf
        for (int [] e: edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]] += 1;
            degree[e[1]] += 1;
        }
        // we need to do bfs, so we need a queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++)
            if (degree[i] == 1)
                queue.offer(i);
        while (n > 2) {
            int size = queue.size();
            // subtract this from the number of vertices
            n -= size;
            for (int i=0; i<size; i++) {
                // pop the front the element
                int current = queue.poll();
                // for each neighbour decrease the degree and if its leaf, insert to queue
                List<Integer> neighbour = adj.get(current);
                for (Integer child: neighbour) {
                    degree[child] -= 1;
                    if (degree[child] == 1)
                        queue.offer(child);
                }
            }
        }
        // remaining of the queue will be the answer and we can copy it into the result
        while (!queue.isEmpty()) {
            int element = queue.poll();
            result.add(element);
        }
        return result;
    }
}

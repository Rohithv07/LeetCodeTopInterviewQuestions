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






class Solution{
    
    public:
    void bfs(Node * root, vector<vector<int>> &trav) {
        queue<Node*> q;
        Node * temp;
        q.push(root);
        while (q.empty() == false) {
            int n = q.size();
            vector<int> v;
            for (int i=1; i<=n; i++) {
                temp = q.front();
                q.pop();
                v.push_back(temp -> data);
                if (temp -> left != NULL) 
                    q.push(temp -> left);
                if (temp -> right != NULL)
                    q.push(temp -> right);
            }
            trav.push_back(v);
        }
    }
    pair<int, int> shortestRange(Node *root) {
        // Your code goes here
        vector<vector<int>> trav;
        bfs(root, trav);
        priority_queue<pair<int, pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int, pair<int,int>>>> pq;
        int n = trav.size();
        int maximum = INT_MIN;
        int minimum = INT_MAX;
        int range = INT_MAX, final_min, final_max;
        for (int i=0; i<n; i++) {
            pq.push(make_pair(trav[i][0], make_pair(i, 0)));
            maximum = max(maximum, trav[i][0]);
        }
        while (true) {
            minimum = pq.top().first;
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            pq.pop();
            if (maximum - minimum < range) {
                range = maximum - minimum;
                final_min = minimum;
                final_max = maximum;
            }
            if (y + 1 == trav[x].size()) {
                break;
            }
            if (y + 1 < trav[x].size()) {
                pq.push(make_pair(trav[x][y+1], make_pair(x, y+1)));
                maximum = max(maximum, trav[x][y + 1]);
            }
        }
        return (make_pair(final_min, final_max));
        
        
        
        
        
    }
};


Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.

Example 1:

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
Explanation: 
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5
Example 2:

Input:
N = 5
preorder[] = {1, 5, 4, 2, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 1, 2, 3, 5}
Output: No
Explanation: The three traversals can 
not be of the same tree.

Your Task:
You don't need to read input or print anything. Complete the function checktree() which takes the array preorder[ ], inorder[ ], postorder[ ] and integer N as input parameters and returns true if the three traversals are of the same tree or not. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)




class Solution{
    public:
    bool checktree(int preorder[], int inorder[], int postorder[], int N) 
    { 
        vector<int> nodes;
        int i = 0;
        bool result = true;
        buildPostOrder(preorder, inorder, 0, N-1, i, nodes, result);
        if (result == false) {
            return false;
        }
        result = true;
        for (i=0; i<N && i<nodes.size(); i++) {
            if (nodes[i] != postorder[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
    void buildPostOrder(int  preorder[], int inorder[], int low, int high, int &i, vector<int> &nodes, bool &result) {
        if (low > high || !result)
            return;
        int key = preorder[i++];
        int k;
        for (k=0; k<=high; k++) {
            if (inorder[k] == key) {
                break;
            }
        }
        if (k == high + 1) {
            result = false;
            return;
        }
        buildPostOrder(preorder, inorder, low, k-1, i, nodes, result);
        buildPostOrder(preorder, inorder, k+1, high, i, nodes, result);
        nodes.push_back(key);
    }

};


Given a parent array arr[] of a binary tree of N nodes. Element at index i in the array arr[] represents the parent of ith node, i.e, arr[i] = parent(i). Find the height of this binary tree.
Note: There will be a node in the array arr[], where arr[i] = -1, which means this node is the root of binary tree.

Example 1:

Input: N = 7
arr = {-1, 0, 0, 1, 1, 3, 5}
Output: 5
Explanation: Tree formed is:
                    0
                   / \
                  1   2
                 / \
                3   4
               /
              5
             /
            6      Height of the tree= 5
Your Task:
You do not need to read input or print anything. Your task is to complete the function findHeight() which takes N and arr[] as input parameters and returns the height of the given binary tree.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
0 ≤ arr[i] ≤ 104   


class Solution{
    static int findHeight(int n, int arr[]){
        // code here
        if (n == 1) {
            return 1;
        }
        // O(n) time and O(n) extra space
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int height = 1;
        for (int i = 1; i < n; i++) {
            map.put(i, map.get(arr[i]) + 1);
            height = Math.max(height, map.get(i));
        }
        return height;
    }
}


class Solution{
    static int findHeight(int n, int arr[]){
        // code here
        if (n == 1) {
            return 1;
        }
        int [] height = new int [1];
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            dfs(arr, element, 0, height);
        }
        return height[0];
    }
    
    static void dfs(int [] arr, int element, int index, int [] height) {
        if (element == -1) {
            height[0] = Math.max(height[0], index + 1);
            return;
        }
        dfs(arr, arr[element], index + 1, height);
    }
}
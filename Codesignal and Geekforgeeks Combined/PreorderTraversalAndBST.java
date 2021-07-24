Given an array arr[ ] of size N, write a program that returns 1 if given array can represent preorder traversal of a possible BST, else returns 0.

Example 1:

Input:
N = 3
arr = {2, 4, 3}
Output: 1
Explaination: Given arr[] can represent
preorder traversal of following BST:
               2
                \
                 4
                /
               3
Example 2:

Input:
N = 3
Arr = {2, 4, 1}
Output: 0
Explaination: Given arr[] cannot represent
preorder traversal of a BST.
Your Task:
You don't need to read input or print anything. Your task is to complete the function canRepresentBST() which takes the array arr[] and its size N as input parameters and returns 1 if given array can represent preorder traversal of a BST, else returns 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105



class Solution {
    static int canRepresentBST(int arr[], int n) {
        // code here
        if (arr == null || n == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (arr[i] < root)
                return 0;
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                root = stack.pop();
            }
            stack.push(arr[i]);
        }
        return 1;
    }
}

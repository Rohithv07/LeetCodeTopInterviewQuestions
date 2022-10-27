Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.


Example 1:

Input:
N = 2
arr = {2,1}
Output: {1}
Explaination: 1 is the only leaf node.

Example 2:

Input:
N = 3
Arr = {3, 2, 4}
Output: {2, 4}
Explaination: 2, 4 are the leaf nodes.

Your Task:
You don't need to read input or print anything. Your task is to complete the function leafNodes() which takes the array arr[] and its size N as input parameters and returns the leaf nodes of the tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 103



//User function Template for Java
class Solution
{
    public int[] leafNodes(int arr[], int n)
    {
        // code here
        int left = 0;
        int right = n - 1;
        List<Integer> result = new ArrayList<>();
        bstRecursive(left, right, result, arr);
        int [] finalResult = new int [result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
    
    private void bstRecursive(int left, int right, List<Integer> result, int [] arr) {
        if (left > right) {
            return;
        }
        if (left == right) {
            int leaf = arr[left];
            result.add(leaf);
            return;
        }
        int index;
        for (index = left + 1; index <= right; index++) {
            if (arr[index] > arr[left]) {
                break;
            }
        }
        bstRecursive(left + 1, index - 1, result, arr);
        bstRecursive(index, right, result, arr);
    }
}
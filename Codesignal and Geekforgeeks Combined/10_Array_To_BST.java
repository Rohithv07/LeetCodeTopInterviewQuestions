Given a sorted array. Convert it into a Height balanced Binary Search Tree (BST). Find the preorder traversal of height balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.
Height balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.

Example 1:

Input: nums = {1, 2, 3, 4}
Output: {2, 1, 3, 4}
Explanation: 
The preorder traversal of the following 
BST formed is {2, 1, 3, 4}:
           2
         /   \
           1     3
               \
                4
 

Example 2:

Input: nums = {1,2,3,4,5,6,7}
Ouput: {4,2,1,3,6,5,7}
Explanation: 
The preorder traversal of the following
BST formed is {4,2,1,3,6,5,7} :
        4
       / \
      2   6
     / \  / \
    1   3 5  7
 

Your Task:
You don't need to read or print anything. Your task is to complete the function sortedArrayToBST() which takes the sorted array nums as input paramater and returns the preorder traversal of height balanced BST. If there exist many such balanced BST consider the tree whose preorder is lexicographically smallest.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 ≤ |nums| ≤ 104
-104 ≤ nums[i] ≤ 104



// we can also have a global variable for index and remove use of ArrayList
class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        List<Integer> preorderList = new ArrayList<>();
        int [] preorder = new int [length];
        convertToBST(nums, 0, length - 1, preorderList);
        int index = 0;
        for (int pre : preorderList) {
            preorder[index++] = pre;
        }
        return preorder;
    }
    
    public void convertToBST(int [] nums, int start, int end, List<Integer> preorderList) {
        if (start > end) {
            return;
        }
        int middle = start + (end - start) / 2;
        preorderList.add(nums[middle]);
        convertToBST(nums, start, middle - 1, preorderList);
        convertToBST(nums, middle + 1, end, preorderList);
    }
}
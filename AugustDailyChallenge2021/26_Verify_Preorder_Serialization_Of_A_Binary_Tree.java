One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.


For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".
Note: You are not allowed to reconstruct the tree.

 

Example 1:

Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: preorder = "1,#"
Output: false
Example 3:

Input: preorder = "9,#,#,1"
Output: false
 

Constraints:

1 <= preorder.length <= 104
preoder consist of integers in the range [0, 100] and '#' separated by commas ','.


/*
Using stack, this is the idea
// case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;
        String [] root = preorder.split(",");
        /*
        all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
        all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
        */
        int diff = 1;
        for (String node : root) {
            if (--diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }
        return diff == 0;
    }
}
You are given two arrays A and B of unique elements of size N. Check if one array is a stack permutation of the other array or not.
Stack permutation means that one array can be created from another array using a stack and stack operations.

 

Example 1:

Input:
N = 3
A = {1,2,3}
B = {2,1,3}
Output:
1
Explanation:
1. push 1 from A to stack
2. push 2 from A to stack
3. pop 2 from stack to B
4. pop 1 from stack to B
5. push 3 from A to stack
6. pop 3 from stack to B
 

Example 2:

Input:
N = 3
A = {1,2,3}
B = {3,1,2}
Output:
0
Explanation:
Not Possible
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function isStackPermutation() which takes two arrays A and B as inputs and returns 1 if it is a stack permutation otherwise returns 0.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
0 <= A[i], B[i] <= 2*105
Sum of N over all test cases doesn't exceeds 106



class Solution {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int num : ip) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == op[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
            
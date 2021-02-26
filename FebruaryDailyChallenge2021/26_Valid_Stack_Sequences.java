Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 

Constraints:

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values.




class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length1 = pushed.length;
        int length2 = popped.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j += 1;
            }
            i += 1;
        }
        return stack.isEmpty() ? true : false;

	// 2nd approach
        int i = 0;
        int j = 0;
        for (int number : pushed) {
            pushed[i++] = number;
            while (i > 0  && pushed[i - 1] == popped[j]) {
                j += 1;
                i -= 1;
            }
        }
        return i == 0;
    }
}


/*
pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Stack = [] -> [1] -> [1, 2] ->[1, 2, 3] -> [1, 2, 3, 4] -> [1, 2, 3] -> [1, 2,3, 5] -> [1, 2, 3] -> [1, 2] -> [1] -> [] - true


pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Stack = [] -> [1] -> [1, 2] -> [1, 2, 3] -> [1, 2, 3, 4] -> [1, 2, 3] -> [1, 2] -> [1, 2, 5] -> [1, 2] -> element ot be popped is 1 but the top is 2, so not possible and not a valid sequence 


*/

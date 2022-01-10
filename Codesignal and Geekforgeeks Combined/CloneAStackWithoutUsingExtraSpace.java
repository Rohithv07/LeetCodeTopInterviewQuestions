Given elements of a stack, clone the stack without using extra space.


Example 1:

Input:
N = 10
st[] = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7}
Output:
1 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function clonestack() which takes the input stack st[], an empty stack cloned[], you have to clone the stack st into stack cloned.
The driver code itself prints 1 in the output if the stack st is cloned properly and prints 0 otherwise.


Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 1000
1<= st[i] <= 105

class Solution {
    void clonestack(Stack<Integer> stack, Stack<Integer> cloned) {
        // code here
        if (stack.isEmpty()) {
            return;
        }
        // this is by using recursion
        int top = stack.pop();
        clonestack(stack, cloned);
        cloned.push(top);
        
        // first by reversing 
        Collections.reverse(stack);
        while (!stack.isEmpty()) {
            cloned.push(stack.pop());
        }
    }
}


// finding reverse without using built in function

class Solution {
    void clonestack(Stack<Integer> stack, Stack<Integer> cloned) {
        // code here
        if (stack.isEmpty()) {
            return;
        }
        int count = 0;
        while (count != stack.size() - 1) {
            int top = stack.pop();
            while (count != stack.size()) {
                cloned.push(stack.pop());
            }
            stack.push(top);
            while (!cloned.isEmpty()) {
                stack.push(cloned.pop());
            }
            count ++;
        }
        
        while (!stack.isEmpty()) {
            cloned.push(stack.pop());
        }
    }
}
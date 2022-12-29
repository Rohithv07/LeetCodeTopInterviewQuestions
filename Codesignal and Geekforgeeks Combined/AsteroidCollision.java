We are given an integer array asteroids of size N representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are of same size, both will explode. Two asteroids moving in the same direction will never meet.
 

Example 1:

Input:
N = 3
asteroids[ ] = {3, 5, -3}
Output: {3, 5}
Explanation: The asteroid 5 and -3 collide resulting in 5. The 5 and 3 never collide.
Example 2:

Input:
N = 2
asteroids[ ] = {10, -10}
Output: { }
Explanation: The asteroid -10 and 10 collide exploding each other.
Your Task:
You don't need to read input or print anything. Your task is to complete the function asteroidCollision() which takes the array of integers asteroids and N as parameters and returns the state of asteroids after all collisions.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
-1000 ≤ asteroidsi  ≤ 1000
asteroids[i]!=0





Steps to solve this question :

initialize a stack.

simple strategy is to iterate over the elements

and at each step of iteration we have to make sure the following things:

if element is positive just put in the stack 
otherwise check certain conditions:
if stack is empty ,put the element in stack 
if not empty and last element of stack is negative,put the element in stack
otherwise pop the positve elements on top of stack having absolute value lesser than absolute value of element
if after poping st becomes empty put the element in the stack as it is the largest absolute value 
otherwise check the stack's top is equal absolute value of element then pop the stack's top 
otherwise check whether stack's top is negative integer ,if it is put the element in the stack.


class Solution {
    public static int[] asteroidCollision(int n, int[] asteroids) {
        // code here
        if (n == 0 || asteroids == null) {
            return new int []{};
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                stack.push(asteroid);
            }
            else {
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                }
                else if (stack.peek() < 0) {
                    stack.push(asteroid);
                }
                else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        stack.push(asteroid);
                    }
                    else {
                        if (stack.peek() == Math.abs(asteroid)) {
                            stack.pop();
                        }
                        else {
                            if (stack.peek() < 0) {
                                stack.push(asteroid);
                            }
                        }
                    }
                }
            }
        }
        int resultSize = stack.size();
        int [] result = new int [resultSize];
        int resultIndex = resultSize - 1;
        while (!stack.isEmpty()) {
            int asteroid = stack.pop();
            result[resultIndex--] = asteroid;
        }
        return result;
    }
}


// more understandable code from geeksforgeeks


// Back-end complete function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                s.push(i);
            } else { // i is negative
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)) {
                    s.pop();
                }
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(i);
                } else if (i + s.peek() == 0) {
                    s.pop(); // equal
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}

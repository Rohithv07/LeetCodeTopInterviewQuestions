We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
Example 4:

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 

Constraints:

1 <= asteroids <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0



// here we need to use stack and we can easily check whether the asteroids are moving in opposite direction or not + whether they are completely exploded
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 1)
            return asteroids;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < asteroids.length) {    // O(lengthArray)
            // if positive push to the stack
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
            // otherwise we need to consider with the negative numbers and the equality
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) { // O(stackSize)
                    // now we have collision and we can pop the element
                    stack.pop();
                }
                // we already have a negative number and we can still push the element
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.add(asteroids[i]);
                // if we have same values, then completely gets destroyed
                else if (stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
            }
            i += 1;
        }
        int [] finalResult = new int [stack.size()];
        // since stack elements are in reverse order(LastInFirstOut), then we need to add elements to the back
        for (int j=stack.size()-1; j>=0; j--)
            finalResult[j] = stack.pop();
        return finalResult;
    }
}

// O(arrayLength * stacksize)

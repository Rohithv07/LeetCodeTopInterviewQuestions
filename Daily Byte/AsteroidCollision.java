/*
You’re given a set of integers, dominoes, that represent a set of domino tiles. The value of domino represents either weight and its sign, positive or negative, represents the direction it is falling: positive falls right and negative falls left. When two dominoes collide, the larger domino destroys the smaller domino. If two dominoes of the same size collide, both dominoes are destroyed. After all the collisions, return the state of the dominoes.

Ex: Given the following dominoes…

dominoes = [3, -3], return [].
Ex: Given the following dominoes…

dominoes = [1, 2, -3, 2, -1], return [-3, 2] (-3 destroys both dominoes to its left and the second two destroys the domino to the right of it).
*/


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 1)
            return new int [asteroids[0]];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<asteroids.length; i++) {
            if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.add(asteroids[i]);
                else if (stack.peek() == Math.abs(asteroids[i]))
                    stack.pop();
            }
        }
        int [] result = new int [stack.size()];
        for (int i=result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

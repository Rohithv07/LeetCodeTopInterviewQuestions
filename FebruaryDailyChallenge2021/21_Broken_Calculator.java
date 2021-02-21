On a broken calculator that has a number showing on its display, we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.

 

Example 1:

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: X = 5, Y = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Example 4:

Input: X = 1024, Y = 1
Output: 1023
Explanation: Use decrement operations 1023 times.
 

Note:

1 <= X <= 10^9
1 <= Y <= 10^9



// 1st check if X > Y, then we need to decrease by 1 and the answer will be X - Y
// Otherwise we have two options
// Until Y > X -> if Y is even, update Y as Y / 2 else Y + 1;
// increment a counter
// final result will be counter + X - Y
// O(logY)


class Solution {
    public int brokenCalc(int X, int Y) {
        if (X > Y) {
            return X - Y;
        }
        int result = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            result += 1;
        }
        return result + X - Y;
    }
}

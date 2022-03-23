There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

 

Example 1:

Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 

Constraints:

1 <= x, y <= 109



class Solution {
    public int brokenCalc(int startValue, int target) {
        // do the reverse way
        // make target to startValue
        if (startValue == target) {
            return 0;
        }
        int minOperation = 0;
        while (target > startValue) {
            if (target % 2 == 0)
                target /= 2;
            else {
                target++;
            }
            minOperation++;
        }
        if (target == startValue) {
            return minOperation;
        }
        return minOperation + startValue - target;
    }
}
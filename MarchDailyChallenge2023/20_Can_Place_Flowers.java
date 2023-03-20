You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n == 0) {
            return true;
        }
        int length = flowerbed.length;
        int countOfPlacedFlowers = 0;
        for (int i=0; i<length && countOfPlacedFlowers < n; i++) {
            if (flowerbed[i] == 0) {
                int rightOfZero = (i == length - 1) ? 0 : flowerbed[i + 1];
                int leftOfZero = (i == 0) ? 0 : flowerbed[i - 1];
                if (rightOfZero == 0 && leftOfZero == 0) {
                    flowerbed[i] = 1;
                    countOfPlacedFlowers += 1;
                }
            }
        }
        return countOfPlacedFlowers == n;
    }
}
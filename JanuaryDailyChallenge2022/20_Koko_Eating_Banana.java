Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h <= 0) {
            return 0;
        }
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isPossible(piles, h, middle)) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }
    
    public boolean isPossible(int [] piles, int h, int middle) {
        int total = 0;
        for (int pile : piles) {
            total += (pile - 1) / middle + 1;
        }
        return total <= h;
    }
}
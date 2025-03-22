/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 *  The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile 
of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all
 of them instead and will not eat any more bananas during this hour.

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


3 6 7 11 => 28 total bananas h = 1
k = 28

h = 28 
k = 1

minimum = 1
maximum = totalSum = 28

1 to 28


1 to 14
1 to 7
4 to 7
4
*/

import java.util.*;
public class KokoEatingBananas {
    public static void  main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [] nums = new int [length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        int hour = sc.nextInt();
        System.out.println(speedOfKoko(nums, length, hour));
        sc.close();
    }

    private static long speedOfKoko(int [] nums, int length, int hour) {
        if (length == 0 || nums == null) {
            return 0;
        }
        long left = 1;
        long right = 0;
        for (int num : nums) {
            right += num;
        }
        long speedOfKoko = 0;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (canKokoFinishInHour(nums, hour, middle)) {
                speedOfKoko = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return speedOfKoko;
    }

    private static boolean canKokoFinishInHour(int [] nums, int hour, long middle) {
        long hourTook = 0;
        for (int num : nums) {
            long hours = num / middle;
            hourTook += hours;
            if (num % middle != 0) {
                hourTook++;
            }
        }
        return hourTook <= hour;
    }
}


// TC : O(NLogN)
// SC : O(1)



























/* 
class Solution {
        public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length;i++)   hi = Math.max(hi, piles[i]);
        while(lo < hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(canEatBananas(piles, mid, h)) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
    boolean canEatBananas(int[] piles, int mid, int h)
    {
        int actualHours = 0;
        for(int bananas : piles)
        {
            int hours = bananas/ mid;  // no. of hours
                actualHours = actualHours + hours;
                if(bananas % mid != 0) actualHours++; 
        }
            return actualHours <= h;
    }
}
 */



 
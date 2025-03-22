/*
 * You are given an array of integers nums, there is a sliding window of 
 * size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length



1 3 -1 -3 5 3 6 7
k = 3

1 3 -1 => 3
3 -1 -3 => 3
-1 -3 5 => 5
-3 5 3 => 5
5 3 6 => 6
3 6 7 => 7


1 3 -1 -3 5 3 6 7
k = 4

1 3 -1 -3 => 3
3 -1 -3 5 => 5
-1 -3 5 3 => 5
-3 5 3 6 => 6
5 3 6 7 => 7

8 - 4 + 1 = 5

3 3 5 5 6 7

1 3 -1 -3 5 3 6 7
0 1 2 3
10 9 8 7

k = 3


1 2 3 4
 9 8 7 6
7


k = 2

 5 4 3 2

 1 2

*/

import java.util.*;

public class SlidingWindowMax {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [] nums = new int [length];
        for (int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int [] slidingMax = findMaximumForKSizeWindow(nums, length, k);
        for (int max : slidingMax) {
            System.out.print(max + " ");
        }
        sc.close();
    }

    private static int [] findMaximumForKSizeWindow(int [] nums, int length, int k) {
        if (length < k || nums == null) {
            return new int []{};
        }
        int [] slidingMaxArray = new int [length - k + 1];
        Deque<Integer> trackMaxDeque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (!trackMaxDeque.isEmpty() && i - k == trackMaxDeque.peekFirst()) {
                trackMaxDeque.pollFirst();
            }
            while (!trackMaxDeque.isEmpty() && nums[i] > nums[trackMaxDeque.peekLast()]) {
                trackMaxDeque.pollLast();
            }
            trackMaxDeque.offer(i);
            if (i >= k - 1) {
                slidingMaxArray[index++] = nums[trackMaxDeque.peekFirst()];
            }
        }
        return slidingMaxArray;
    }
}

// TC : O(Lenght of array)
// SC : O(size of result array) + O(k)


















/*
 * 
 

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (nums == null || length < k) {
            return new int []{};
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int [] result = new int [length - k + 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
 */
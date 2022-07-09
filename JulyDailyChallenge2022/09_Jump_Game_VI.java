You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.

 

Example 1:

Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
Example 2:

Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
Example 3:

Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
 

Constraints:

1 <= nums.length, k <= 105
-104 <= nums[i] <= 104


class Solution {
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<length; i++) {
            int currentMax = (!deque.isEmpty()) ? nums[deque.peekFirst()] : 0;
            nums[i] = nums[i] + currentMax;
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            while (!deque.isEmpty() && i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
        }
        // while (!deque.isEmpty()) {
        //     System.out.println(deque.poll());
        // }
        // System.out.println();
        // for (int number : nums) {
        //     System.out.print(number + " ");
        // }
        return nums[length - 1];
    }
}

/*
[1, -1, -2, 4, -7, 3] k = 2

1st iteration = deque = [] current max = 0 nums[0] = nums[0], deque[0]
2nd iteration = deque[0] current max = 1 nums[1] = 0 deque[0, 1] nums = [1, 0, -2, 4, -7, 3]
3rd iteration = deque[0, 1] current max = -3 nums[2] = -5  deque[0, 1, 2]  => [1, 2] nums = [1, 0, -1, 4, -7, 3]
4th iteration = deque[1, 2] current max = 0 nums[3] = 4 deque[3] nums = [1, 0, -1, 4, -7, 3]
5th iteration = deque[3] current max = 4 nums[4] = -3 deque[3, 4] nums = [1, 0, -1, 4, -3, 3]
6th iteration = deque[3, 4] current max = 4 nums[5] = 7 deque[5] nums = [1, 0, -1, 4, -3, 7]
*/
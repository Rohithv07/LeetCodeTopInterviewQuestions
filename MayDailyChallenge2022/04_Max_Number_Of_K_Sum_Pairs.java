You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109

// nlogn
class Solution {
    public int maxOperations(int[] nums, int k) {
        int length = nums.length;
        if (length == 1 && nums[0] == k) {
            return 1;
        }
        if (length == 1 && nums[0] != k) {
            return 0;
        }
        int operation = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum < k) {
                left++;
            }
            else if (currentSum > k) {
                right--;
            }
            else {
                left++;
                right--;
                operation++;
            }
        }
        return operation;
    }
}


// n

class Solution {
    public int maxOperations(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == k) {
                return 1;
            }
            return 0;
        }
        int operation = 0;
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int currentNum = nums[i];
            int diff = k - currentNum;
            if (diff < 0) {
                // we have only positive numbers
                continue;
            }
            if (tracker.containsKey(currentNum) && tracker.get(currentNum) > 0) {
                operation++;
                tracker.put(currentNum, tracker.get(currentNum) - 1);
            }
            else {
                tracker.put(diff, tracker.getOrDefault(diff, 0) + 1);
            }
        }
        return operation;
    }
}
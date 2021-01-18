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



class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int operations = 0;
        for (int number : nums)
            map.put(number, map.getOrDefault(number, 0) + 1);
        for (int key1 : map.keySet()) {
            int key2 = k - key1;
            if (key1 == key2)
                operations += map.get(key1) / 2;
            else {
                if (map.containsKey(key2)) {
                    int minimum = Math.min(map.get(key1), map.get(key2));
                    operations += minimum;
                    map.put(key1, map.get(key1) - minimum);
                    map.put(key2, map.get(key2) - minimum);
                }
            }
        }
        return operations;
        
        
        // another solution using sorting
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;
        while (left < right) {
            if (nums[left] + nums[right] < k)
                left ++;
            else if (nums[left] + nums[right] > k)
                right -= 1;
            else {
                operations += 1;
                left ++;
                right --;
            }
        }
        return operations;
    }
}

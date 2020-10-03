Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
a <= b
b - a == k
 

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2
Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2



Solution:

//Count the elements with Counter
//If k > 0, for each element i, check if i + k exist.
//If k == 0, for each element i, check if count[i] > 1

class Solution {
    public int findPairs(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number: nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int x: map.keySet()) {
            if ((k>0 && map.containsKey(x+k)) || (k == 0 && map.get(x) > 1))
                pairs += 1;
        }
        return pairs;
    }
}

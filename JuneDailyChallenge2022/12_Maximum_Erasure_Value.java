You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104



class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        int pointer1 = 0;
        int pointer2 = 0;
        int currentSum = 0;
        int result = 0;
        while (pointer1 < length && pointer2 < length) {
            int num1 = nums[pointer1];
            int num2 = nums[pointer2];
            if (!set.contains(num2)) {
                currentSum += num2;
                result = Math.max(result, currentSum);
                set.add(num2);
                pointer2++;
            }
            else {
                currentSum -= num1;
                set.remove(num1);
                pointer1++;
            }
        }
        return result;
    }
}
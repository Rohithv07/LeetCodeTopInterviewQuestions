Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.



class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        // sort the array so that we only need to check one condition
        Arrays.sort(nums);
        int [] lis = new int [length];
        int [] previousIndex = new int [length];
        Arrays.fill(lis, 1);
        Arrays.fill(previousIndex, -1);
        int max = 0;
        int index = -1;
        for (int i=0; i<length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0 && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    previousIndex[i] = j;
                }
            }
            if (lis[i] > max) {
                // record the largest element of it
                index = i;
                max = lis[i];
            }
        }
        // loop from the largest element until 0
        while (index >= 0) {
            result.add(nums[index]);
            index = previousIndex[index];
        }
        return result;
    }
}
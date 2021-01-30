You are given an array nums of n positive integers.

You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
Example 2:

Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
Example 3:

Input: nums = [2,10,8]
Output: 3
 

Constraints:

n == nums.length
2 <= n <= 105
1 <= nums[i] <= 109




class Solution {
    public int minimumDeviation(int[] nums) {
        // 1. We can use a Treeset here as we can get the values in sorted order
        TreeSet<Integer> set = new TreeSet<>();
        // 2. If the values inside array is even, just simply add it into set else add value*2 into the set(operation given)
        for (int val : nums) {
            if (val % 2 == 0)
                set.add(val);
            else
                set.add(val * 2);
        }
        int answer = Integer.MAX_VALUE;
        while (true) {
            // 3. Use the last() method to get the last value which is the largest and take the diff wrt to that last value
            int lastValue = set.last();
            // 4. Update the answer
            answer = Math.min(answer, lastValue - set.first());
            // 5. If we encounter an even number at the lastValue, we just remove and add evenNumber / 2 to it.(operation given)
            if (lastValue % 2 == 0) {
                set.remove(lastValue);
                set.add(lastValue / 2); // we do this until the number becomes odd.
            }
            else
                break;
        }
        return answer;
    }
}

// nlognlogm -> m = largest number

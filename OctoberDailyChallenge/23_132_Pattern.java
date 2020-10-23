Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109


class Solution {
    public boolean find132pattern(int[] nums) {
        // brute force O(n^3)
        /*if (nums.length < 3)
            return false;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    int one = nums[i];
                    int two = nums[j];
                    int three = nums[k];
                    if (one < three && three < two)
                        return true;
                }
            }
        }
        return false;
        */
        // lets try to bring it down to O(n^2) and dont know whether it will work
        /*if (nums.length < 3)
            return false;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n-1; j++) {
                int one = nums[i];
                int two = nums[j];
                int three = nums[j+1];
                if (one < three && three < two)
                    return true;
            }
        }
        return false;
        */
        // but this solution is completely wrong but passes 86 of the test cases
        // so the main idea here is to make use of stack and also fidn the minimum from the given array
        if (nums.length < 3)
            return false;
        int n = nums.length;
        // we need a stack
        Stack<Integer> stack = new Stack<>();
        int [] min = new int [n];
        // fill the min array with minimum values
        min[0] = nums[0];
        for (int i=1; i<n; i++) 
            min[i] = Math.min(min[i-1], nums[i]);
        // now we need to traverse from the back and check for the element greater than the min
        for (int i=n-1; i>=0; i--) {
            if (nums[i] > min[i]) {
                // now we look into our stack and also check whther the top element is <= min[i]
                while (!stack.isEmpty() && stack.peek() <= min[i])
                    // we pops the element
                    stack.pop();
                // if the top element after poping is < nums[i], then we have min[i], stack.peek(), nums[i] in 132 fashion
                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
        // time complexity O(lengthOfArray)
        // space O(lengthOfArray) as the stack may grow upto the size of the array
    }
}

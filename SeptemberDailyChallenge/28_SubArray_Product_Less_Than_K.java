/* 
My thought process
Here we can build each and every subset of the given array and find the product and check the condition of thequestion. If satisfies, then we can increment our count. But it will be very much inefficient and we can do it in O(n) time.

SO the approach is to use sliding window technique.
We need to take proper window and do the multiplication and update the count.
So let us start from a windw where start = 0, end =0;
    -> Now find the product of prdouct X nums[end]
    -> If the product exceeds and until it become less than the value k, we divide the product by nums[start] and increment start.
    -> If we do not have this condtion met, then we have our product < k, so update count as end - start + 1 + initial count.
    
Thats the whole problem.
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int length = nums.length;
        int start = 0;
        long product = 1;
        int count = 0;
        for (int end = 0; end<length; end ++) {
            product = product * nums[end];
            while (product >= k) {
                product = product / nums[start ++];
            }
            count += end - start + 1;
        }
        return count;
    }
}

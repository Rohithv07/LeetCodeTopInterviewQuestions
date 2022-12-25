/*
We need to find the size of longest subsequence such that the sum in those subsequence must be lesser than equal to each of the query q.

For each query q, we need to find such maximum size.

So we can sort the array and find the prefix sum.
Now just do normal binary search on the prefix sum in hope of finding the size whose sum is lesser than or equal to q.

*/



class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int lengthQ = queries.length;
        int lengthNum = nums.length;
        int [] result = new int [lengthQ];
        Arrays.sort(nums);
        int [] prefix = new int [lengthNum];
        prefix[0] = nums[0];
        for (int i = 1; i < lengthNum; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int index = 0;
        for (int q : queries) {
            int maxSize = findSize(prefix, 0, lengthNum - 1, q);
            result[index++] = maxSize;
        }
        return result;
    }
    
    private int findSize(int [] prefix, int low, int high, int q) {
        int result = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (prefix[middle] <= q) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return low;
    }
}
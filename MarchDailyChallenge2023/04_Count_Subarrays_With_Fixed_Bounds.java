class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minPointer = -1;
        int maxPointer = -1;
        int length = nums.length;
        int wrongIndex = -1; // this is where num < minK || num > maxK;
        for (int i = 0; i < length; i++) {
            int currentNum = nums[i];
            if (currentNum < minK || currentNum > maxK) {
                wrongIndex = i;
            }
            else {
                if (currentNum == minK) {
                    minPointer = i;
                }
                if (currentNum == maxK) {
                    maxPointer = i;
                }
            }
            // here why we find minimum, becuase in the subarray the max element can occur before min element
            // so to properly find the starting point of subarray, we take the min between minPointer and maxPointer
            count += Math.max(0L, Math.min(minPointer, maxPointer) - wrongIndex);
        }
        return count;
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int i = 0;
        int j = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] != 0) {
                j = i + 1; // end of consecutive 0
            } 
            result += i - j + 1;
            i++;
        }
        return result;
    }
}
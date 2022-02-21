class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Integer candidate = null;
        int vote = 0;
        for (int number : nums) {
            if (vote == 0) {
                candidate = number;
            }
            vote += candidate == number ? 1 : -1;
        }
        return candidate;
    }
}
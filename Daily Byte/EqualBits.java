/*
Given an integer array, bits, that represents a binary sequence (i.e. it only contains zeroes and ones), return the length of the longest contiguous sequence of bits that contains the same number of zeroes and ones.

Ex: Given the following bits…

bits = [1, 0, 1, 1, 0, 0], return 6 (the entire sequence has the 3 zeroes and 3 ones).
Ex: Given the following bits…

bits = [1, 1], return 0.
*/


class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                sum -= 1;
            else
                sum += 1;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return result;
    } 
}

/*
[1, 0, 1, 1, 0, 0] -> [1, 0, 1, 2, 1, 0]
 1 - 0
 0 - 1
 1 - 2 2 - map.get(1) = 2

*/

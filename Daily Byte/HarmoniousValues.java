/*

Given an integer array, nums, return the length of the longest harmonious subsequence it contains.
Note: A harmonious subsequence is a subsequence in which the difference between the largest value and the smallest value in the subsequence is exactly one.

Ex: Given the following nums...

nums = [1, 1], return 0.
Ex: Given the following nums...

nums = [3, 4, 5], return 2.
Ex: Given the following nums...

nums = [3, 2, 2, 2, 4, 3, 3], return 6.
*/


class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }
        return result;
    }
}
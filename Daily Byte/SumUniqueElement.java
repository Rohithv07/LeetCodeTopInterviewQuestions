/*
Given an array of integers, nums, return the sum of all uniquely occurring elements.

Ex: Given the following nums…

nums = [1, 3, 5, 5, 2], return 6 (1 + 3 + 2).
Ex: Given the following nums…

nums = [4, 4, 2, 3, 3, 2], return 0.
*/

class Solution {
    public int sumOfUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int totalSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                totalSum += key;
            }
        }
        return totalSum;
    }
}
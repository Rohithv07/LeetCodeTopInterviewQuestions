You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104



class Solution {
    public int[] findErrorNums(int[] nums) {
        /*
        // 1. with hashMap
        int length = nums.length;
        int [] result = new int [2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                result[0] = key;
                break;
            }
        }
        for (int i=1; i<=length; i++) {
            if (!map.containsKey(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
        */
        int length = nums.length;
        int [] count = new int [length];
        int [] result = new int [2];
        for (int number : nums) {
            count[number - 1] += 1;
        }
        for (int i=1; i<=length; i++) {
            if (count[i - 1] == 2) {
                result[0] = i;
            }
            else if (count[i - 1] == 0)
                result[1] = i;
        }
        return result;
    }
}

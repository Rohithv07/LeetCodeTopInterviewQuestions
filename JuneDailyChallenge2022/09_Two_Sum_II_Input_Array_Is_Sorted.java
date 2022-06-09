Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.



// using binary search 

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int [] result = new int [2];
        for (int i = 0; i < length; i++) {
            int current = numbers[i];
            int compliment = target - current;
            int complimentIndex = findIndex(numbers, i + 1, length - 1, compliment);
            if (complimentIndex != -1) {
                result[0] = i + 1;
                result[1] = complimentIndex + 1;
                break;
            }
        } 
        return result;
    }
    
    private int findIndex(int [] numbers, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[middle] > target) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return -1;
    }
}


// just 2 pointers

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else {
                return new int [] {left + 1, right + 1};
            }
        }
        return new int []{};
    }
}
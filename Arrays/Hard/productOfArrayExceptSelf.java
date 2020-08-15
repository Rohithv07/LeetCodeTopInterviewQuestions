Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Solution:

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] outputArray = new int[nums.length];
        int product = 1;
        int productNonZero = 1;
        int countZero = 0;
        for (int number: nums){
            product *= number;
            if (number == 0)
                countZero ++;
            else
                productNonZero *= number;
        }
        if (product != 0){
            for (int i=0; i<nums.length; i++){
                outputArray[i] = product / nums[i];
            }
        }
        else {
            if (countZero == 1){
                for (int i=0; i<nums.length; i++){
                    if (nums[i] == 0)
                        outputArray[i] = productNonZero;
                }
            }
        }
        return outputArray;
    }
}

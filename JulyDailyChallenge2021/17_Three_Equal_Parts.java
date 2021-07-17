You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

If it is possible, return any [i, j] with i + 1 < j, such that:

arr[0], arr[1], ..., arr[i] is the first part,
arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
All three parts have equal binary values.
If it is not possible, return [-1, -1].

Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.

 

Example 1:

Input: arr = [1,0,1,0,1]
Output: [0,3]
Example 2:

Input: arr = [1,1,0,1,1]
Output: [-1,-1]
Example 3:

Input: arr = [1,1,0,0,1]
Output: [0,2]
 

Constraints:

3 <= arr.length <= 3 * 104
arr[i] is 0 or 1


// first we counted the number of ones and check if it can be divied to 3 parts
// next we traverse from back to front and find the index until the count of one == totalCountOne / 3
// this is the third part index
// now we find the firstend index and secondend index traversing through arr and checking the equalities and return firstend and secondend + 1 in an array

class Solution {
    public int[] threeEqualParts(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int []{-1, -1};
        int length = arr.length;
        // there must be equal ones
        int sumOfOne = 0;
        for (int number : arr) {
            if (number == 1)
                sumOfOne += 1;
        }
        if (sumOfOne % 3 != 0)
            return new int []{-1, -1};
        if (sumOfOne == 0)
            return new int []{0, 2};
        int thirdPartStartingIndex = 0;
        int count = 0;
        int part = sumOfOne / 3;
        // right to left
        for (int i=length - 1; i>=0; i--) {
            if (arr[i] == 1) {
                if (++count == part) {
                    thirdPartStartingIndex = i;
                    break;
                }
            }
        }
        int firstPartEndingIndex = findEndingIndex(arr, 0, thirdPartStartingIndex);
        if (firstPartEndingIndex < 0)
            return new int []{-1, -1};
        int secondPartEndingIndex = findEndingIndex(arr, firstPartEndingIndex+1, thirdPartStartingIndex);
        if (secondPartEndingIndex < 0)
            return new int[]{-1, -1};
        return new int []{firstPartEndingIndex, secondPartEndingIndex + 1};
    }
    
    public int findEndingIndex(int [] arr, int start, int end) {
        // moving start pointer until we see a 1
        while (arr[start] == 0)
            start += 1;
        while (end < arr.length) {
            if (arr[start] != arr[end])
                return -1;
            start += 1;
            end += 1;
        }
        return start - 1;
    }
}
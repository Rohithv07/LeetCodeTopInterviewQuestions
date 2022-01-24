Given an array arr[] of N weights. Find the least weight capacity of a boat to ship all weights within D days.
Note: You have to load weights on the ship in the given order.

 

Example 1:

Input:
N = 3
arr[] = {1, 2, 1}
D = 2
Output:
3
Explanation:
We can ship the weights in 2 days
in the following way:-
Day 1- 1,2
Day 2- 1
Example 2:
Input:
N = 3
arr[] = {9, 8, 10}
D = 3
Output:
10
Explanation:
We can ship the weights in 3 days
in the following way:-
Day 1- 9
Day 2- 8
Day 3- 10
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function leastWeightCapacity() which takes 2 integers N, and D, and an array arr of size N as input and returns the least weight capacity of the boat required.


Expected Time Complexity: O(N*log(Sum of weights - max(list of weights))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ D ≤ N ≤ 105
1 ≤ arr[i] ≤ 500


class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int sum = 0;
        int max = -1;
        for (int number : arr) {
            sum += number;
            if (max < number) {
                max = number;
            }
        }
        int left = max;
        int right = sum;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isFeasible(arr, middle, d)) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }
    
    public static boolean isFeasible(int [] arr, int capacity, int d) {
        int day = 1;
        int sum = 0;
        for (int number : arr) {
            sum += number;
            if (sum > capacity) {
                sum = number;
                day ++;
                if (day > d) {
                    return false;
                }
            }
        }
        return true;
    }
}
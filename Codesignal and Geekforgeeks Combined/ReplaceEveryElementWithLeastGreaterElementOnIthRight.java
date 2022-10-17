Given an array arr[] of N integers and replace every element with the least greater element on its right side in the array. If there are no greater elements on the right side, replace it with -1. 

Example 1:

Input:
arr[] = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28}
Output: {18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1}
Explanation: 
The least next greater element of 8 is 18.
The least next greater element of 58 is 63 and so on.

Example 2:

Input:
arr[] = {2, 6, 9, 1, 3, 2}
Output: {3, 9, -1, 2, -1, -1}
Explanation: 
The least next greater element of 2 is 3. 
The least next greater element of 6 is 9.
least next greater element for 9 does not
exist and so on.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findLeastGreater() which takes an array arr[] of size N and returns a list as an output.

Expected Time Complexity: O(N* log N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
1 <= A[i] <= 105

class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            set.add(arr[i]);
            if (set.higher(arr[i]) == null) {
                result.add(-1);
            }
            else {
                int higher = set.higher(arr[i]);
                result.add(higher);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
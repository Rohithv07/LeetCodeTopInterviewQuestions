You are given a binary string str. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and complement the characters between L and R i.e strL, strL+1, , strR. By complement, we mean change character 0 to 1 and vice-versa.

You task is to perform ATMOST one operation such that in final string number of 1s is maximised. If there is no need to completement, i.e., string contains all 1s, return -1. Else, return the two values denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Example 1:

Input:
N = 3
str = "111"
Output: -1
Explanation: As all characters are '1', 
so don't need to complement any.
Example 2:

Input:
N = 2
str = "01"
Output: 1 1
Explanation: After complementing [1, 1] 
the string becomes "11".
Your Task:
You don't need to read input or print anything. Complete the function findRange() which takes the string str and the size of the string, n, as input parameters and returns an array of length 2 or 1 representing the answer. 
You don't have to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
Str is a binary string i.e. contains only '0' and '1'.


class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        // we do kadanes algo to find the maximum sum subarray
        // because after complement, that subarray will surely have maximum ones
        Vector<Integer> result = new Vector<>();
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        if (count == n) {
            result.add(-1);
            return result;
        }
        int maxSum = 0;
        int curSum = 0;
        int end = 0;
        int start = 0;
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';
            num = num == 1 ? -1 : 1;
            curSum += num;
            if (curSum > maxSum) {
                maxSum = curSum;
                end = i;
                start = pointer;
            }
            if (curSum < 0) {
                curSum = 0;
                pointer = i + 1;
            }
        }
        result.add(start + 1);
        result.add(end + 1);
        return result;
    }
}
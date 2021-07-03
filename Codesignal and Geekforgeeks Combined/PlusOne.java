Given a non-negative number represented as a list of digits, add 1 to the number (increment the number represented by the digits). The digits are stored such that the most significant digit is first element of array.
 

Example 1:

Input: 
N = 3
arr[] = {1, 2, 4}
Output: 
1 2 5
Explanation:
124+1 = 125, and so the Output
Example 2:

Input: 
N = 3
arr[] = {9,9,9}
Output: 
1 0 0 0
Explanation:
999+1 = 1000, and so the output

Your Task:
You don't need to read input or print anything. You only need to complete the function increment() that takes an integer N, and an array arr of size N as input and returns a list of integers denoting the new number which we get after adding one to the number denoted by the array arr.


Expected Time Complexity:  O(N)
Expected Auxilliary Space: O(1)
 

Constraints:
1 <= N <= 105
0 <= arri <= 9



class Solution {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int n) {
        // code here
        int carry = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=n-1; i>=0; i--) {
            int currentNumber = arr.get(i);
            if (i == n - 1 && currentNumber == 9) {
                result.add(0);
                carry = 1;
            }
            else if (currentNumber == 9 && carry == 1) {
                result.add(0);
                carry = 1;
            }
            else if (currentNumber == 9 && carry == 0) {
                result.add(currentNumber);
                carry = 0;
            }
            else if ((i == n - 1 && currentNumber != 9) || carry == 1) {
                result.add(currentNumber + 1);
                carry = 0;
            }
            else {
                result.add(currentNumber);
            }
        }
        if (carry == 1) {
            result.add(1);
        }
        Collections.reverse(result);
        return result;
    }
}

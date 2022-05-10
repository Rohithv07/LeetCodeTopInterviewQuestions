Geek lost the password of his super locker. He remembers the number of digits N as well as the sum S of all the digits of his password. He know that his password is the largest number of N digits that can be made with given sum S. As he is busy doing his homework, help him retrieving his password.

Example 1:

Input:
N = 5, S = 12
Output:
93000
Explanation:
Sum of elements is 12. Largest possible 
5 digit number is 93000 with sum 12.
Example 2:

Input:
N = 3, S = 29
Output:
-1
Explanation:
There is no such three digit number 
whose sum is 29.
Your Task : 
You don't need to read input or print anything. Your task is to complete the function largestNumber() which takes 2 integers N and S as input parameters and returns the password in the form of string, else return "-1" in the form of string.

Constraints:
1 ≤ N ≤ 104
0 ≤ S ≤ 9*104

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
        if (sum == 0) {
            if (n > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<n; i++) {
                    sb.append(0);
                }
                return sb.toString();
            }
            else {
                return "-1";
            }
        }
        
        if (sum > 9 * n) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (sum > 9) {
                sb.append(9);
                sum -= 9;
            }
            else {
                sb.append(sum);
                sum = 0;
            }
        }
        return sb.toString();
    }
}


// samw logic, different way


class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
        if (9 * n < sum) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        while (sum - 9 > 0) {
            sb.append(9);
            sum -= 9;
        }
        if (sum == 0) {
            int currentLength = sb.length();
            if (currentLength == n) {
                return sb.toString();
            }
            for (int i = currentLength; i < n; i++) {
                sb.append(0);
            }
            return sb.toString();
        }
        else {
            sb.append(sum);
            int currentLength = sb.length();
            if (currentLength == n) {
                return sb.toString();
            }
            for (int i = currentLength; i < n; i++) {
                sb.append(0);
            }
            return sb.toString();
        }
    }
}





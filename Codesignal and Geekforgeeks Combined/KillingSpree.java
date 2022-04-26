There are Infinite People Standing in a row, indexed from 1.
A person having index 'i' has strength of (i*i).
You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.
You can only Kill a person with strength 'X' if P >= 'X'  and after killing him, Your Strength decreases by 'X'. 
 

Example 1:

Input:
N = 14
Output: 3
Explanation:
The strengths of people is 1, 4, 9, 16, .... 
and so on. WE can kill the first 3 person , 
after which our Power becomes 0 and we cant 
kill anyone else. So answer is 3
 

Example 2:

Input:
N = 10
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function killinSpree() which takes the integer N as input parameters and returns the maximum Number of People You can kill.

Expected Time Complexity: O(log(n))
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ T ≤ 103
1 ≤ N ≤ 1012



class Solution{
    
    long killinSpree(long n)
    {
        // Code Here
        long low = 1;
        long high = (long)(1e6);
        long result = -1;
        while (low <= high) {
            long middle = low + (high - low) / 2;
            if (squareSum(middle) > n) {
                high = middle - 1;
            }
            else if (squareSum(middle) < n) {
                result = middle;
                low = middle + 1;
            }
            else {
                return middle;
            }
        }
        return result;
    }
    
    long squareSum(long x) {
        return (x * (x + 1) * (2 * x + 1)) / 6;
    }
}

You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value. 

Each book will be allocated to exactly one student. Each student has to be allocated at least one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).


Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:
113
Explanation: 
Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90}  Maximum Pages =113
Therefore, the minimum of these cases is 
113, which is selected as the output.
Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:
32
Explanation:
Allocation is done as 
{15,17} and {20}

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105


class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        //Your code here
        if (a == null || n == 0 || m == 0 || m > n)
            return -1;
        int start = 0;
        int end = 0;
        // start will be the max from the array, end will be the total sum
        // that is our search space
        for (int i=0; i<n; i++) {
            end += a[i];
            start = Math.max(start, a[i]);
        }
        return binarySearch(a, n, m, start, end);
    }
    
    public static int binarySearch(int [] a, int n, int m, int start, int end) {
        int result = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (isValid(a, n, m, middle)) {
                result = middle;
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return result;
    }
    
    public static boolean isValid(int [] a, int n, int m, int currentSum) {
        int sum = a[0];
        int student = 1;
        for (int i=1; i<n; i++) {
            sum += a[i];
            if (sum > currentSum) {
                sum = a[i];
                student += 1;
            }
            if (student > m) {
                return false;
            }
        }
        return true;
    }
}
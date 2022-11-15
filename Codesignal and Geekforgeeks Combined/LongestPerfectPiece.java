Given an array arr[] of N Numbers. A Perfect Piece is defined as a subarray such that the difference between the minimum and the maximum value in that range is at most 1. Find the Maximal Length Perfect Piece.

 

Example 1:

Input:
N = 4
arr[] = {8, 8, 8, 8}
Output:
4
Explanation:
The longest subarray is [1, 4]
where maximum=8 and minimum = 8 and
difference is 0, which is less than 1.
Its length is 4.
Example 2:

Input:
N = 11
arr[] = {5, 4, 5, 5, 6, 7, 8, 8, 8, 7, 6}
Output:
5
Explanation:
The longest subarray is [6, 10]
where maximum=8 and minimum = 7 and
difference is 1. Its length is 5. 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPerfectPiece() which takes an Integer N and an array arr[] of length N as input and returns the maximal length Perfect Piece.

 

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= arr[i] <= 105


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int n) {
        // code here
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        while (j < n) {
            min.offer(arr[j]);
            max.offer(arr[j]);
            while (i <= j && max.peek() - min.peek() > 1) {
                min.remove(arr[i]);
                max.remove(arr[i]);
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
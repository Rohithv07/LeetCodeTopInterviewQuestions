Given an integer N, print all the N digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

Example 1:

Input:
N = 1
Output:
0 1 2 3 4 5 6 7 8 9
Explanation:
Single digit numbers are considered to be 
strictly increasing order.
Example 2:

Input:
N = 2
Output:
12 13 14 15 16 17 18 19 23....79 89
Explanation:
For N = 2, the correct sequence is
12 13 14 15 16 17 18 19 23 and so on 
up to 89.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function increasingNumbers() which takes an integer N as an input parameter and return the list of numbers such that their digits are in strictly increasing order.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 9



//User function Template for Java
class Solution{
    static ArrayList<Integer> increasingNumbers(int n){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i=0; i<=9; i++) {
                result.add(i);
            }
            return result;
        }
        findIncreasingNumbers(n, 0, result, 1);
        return result;
    }
    
    static void findIncreasingNumbers(int n, int number, ArrayList<Integer> result, int start) {
        if (n == 0) {
            result.add(number);
            return;
        }
        for (int i=start; i<=9; i++) {
            findIncreasingNumbers(n - 1, number * 10 + i, result, i + 1);
        }
    }
}
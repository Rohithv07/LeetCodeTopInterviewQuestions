As we know, Ishaan has a love for chocolates. He has bought a huge chocolate bar that contains N chocolate squares. Each of the squares has a tastiness level which is denoted by an array A[].
Ishaan can eat the first or the last square of the chocolate at once. Ishaan has a sister who loves chocolates too and she demands the last chocolate square. Now, Ishaan being greedy eats the more tasty square first. 
Determine the tastiness level of the square which his sister gets.

Example 1:

Input : arr[ ] = {5, 3, 1, 6, 9}
Output : 1
Explanation:
Initially: 5 3 1 6 9
In first step: 5 3 1 6
In Second step: 5 3 1
In Third step: 3 1
In Fourth step: 1
Return 1


Example 2:

Input : arr[ ] = {5, 9, 2, 6} 
Output :  2

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function chocolates() that takes an array (arr), sizeOfArray (n) and return the tastiness level of the square which his sister gets. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints : 
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 109


//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static int chocolates (int arr[], int n) {
        //Complete the function
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
    
    
}



Given n arrays of size m each. Find maximum sum obtained by selecting a number from each array such that the element selected from the i-th array is more than the element selected from (i-1)-th array. If maximum sum cannot be obtained then return 0.

Example 1:

â€‹Input : arr[ ] = {{1,7,4,3}, {4,2,5,1}, {9,5,1,8}}
Output : 18
Explanation:
We can select 4 from the first array,
5 from second array and 9 from the third array.

â€‹Example 2:

Input : arr[ ] = {{9,8,7}, {6,5,4}, {3,2,1}} 
Output :  0

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maximumSum() that takes number of row N, a number of Column M, 2-d array (arr), and return the maximum sum if cannot be obtained then return 0. The driver code takes care of the printing.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N, M ≤ 500



//User function Template for Java


class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
        for (int i=0; i<n; i++) {
            Arrays.sort(arr[i]);
        }
        int sum = arr[n - 1][m - 1]; // the every last element
        int previousLargestElement = arr[n - 1][m - 1];
        // we will be going from end to start by checking for element that is lesser than the previouslarger element
        for (int i=n-2; i>=0; i--) {
            if (arr[i][0] >= previousLargestElement) {
                return 0;
            }
            for (int j=m-1; j>=0; j--) {
                if (arr[i][j] < previousLargestElement) {
                    sum += arr[i][j];
                    previousLargestElement = arr[i][j];
                    break;
                    
                }
            }
        }
        return sum;
    }
    
    
}






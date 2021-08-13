Given an array with positive number the task to find the largest subsequence from array that contain elements which are Fibonacci numbers.

 

Example 1:

Input : arr[] = {1, 4, 3, 9, 10, 13, 7}
Output : subset[] = {1, 3, 13}
The output three numbers are Fibonacci
numbers.
 
Example 2:
Input  : arr[] = {0, 2, 8, 5, 2, 1, 4,
                  13, 23}
Output : subset[] = {0, 2, 8, 5, 2, 1,
                    13, 23}


Your Task:  
You don't need to read input or print anything. Your task is to complete the function findFibSubset() which takes the array A[] and its size N as inputs and returns the  elements of the fibonacci subsequence in a vector. If no such number found return empty vector.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1<=N<=103
1<=A[]<=109


class Solution {
    
    public void fillFibonacci(Set<Integer> fibonacci, int n) {
        fibonacci.add(0);
        fibonacci.add(1);
        int first = 0;
        int second = 1;
        int howMany = 2;
        while (howMany++ <= n) {
            int third = first + second;
            fibonacci.add(third);
            first = second;
            second = third;
        }
    }
    
    public int[] findFibSubset(int arr[], int n)
    {
        if (n == 0 || arr == null) {
            return new int []{};
        }   
        List<Integer> possibleResult = new ArrayList<>();
        Set<Integer> fibonacci = new HashSet<>();
        // since constraint is given as 1000
        fillFibonacci(fibonacci, 1000);
        for (int number : arr) {
            if (fibonacci.contains(number)) {
                possibleResult.add(number);
            }
        }
        int [] result = new int [possibleResult.size()];
        fillResult(result, possibleResult);
        return result;
    }
    
    public void fillResult(int [] result, List<Integer> possibleResult) {
        for (int i=0; i<result.length; i++) {
            result[i] = possibleResult.get(i);
        }
    }
}
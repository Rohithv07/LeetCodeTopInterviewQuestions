Given an array A[] of size N. Find the number of pairs (i, j) such that
Ai XOR Aj = 0, and 1 ≤ i < j ≤ N.

Example 1:

â€‹Input : arr[ ] = {1, 3, 4, 1, 4}
Output : 2
Explanation:
Index( 0, 3 ) and (2 , 4 ) are only pairs 
whose xors is zero so count is 2.

â€‹Example 2:

Input : arr[ ] = {2, 2, 2} 
Output :  3

 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function calculate() that takes an array (arr), sizeOfArray (n), and return the count of Zeros Xor's Pairs. The driver code takes care of the printing.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(1).



Output:
For each test case, output a single integer i.e counts of Zeros Xors Pairs

Constraints
2 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^5


class Complete{
    
   
    // Function for finding maximum and value pair
    public static long calculate (int arr[], int n) {
        //Complete the function
        
        // nlogn and no extra space
        Arrays.sort(arr);
        long count = 1;
        long result = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            }
            if (i == n - 1 || arr[i] != arr[i - 1]){
                result += ((count * (count - 1)) / 2);
                count = 1;
            }
        }
        return result;
        
        // O(n) with extra space
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int occur = map.get(key);
            result += (occur) * (occur - 1) / 2;
        }
        return result;
    }
}



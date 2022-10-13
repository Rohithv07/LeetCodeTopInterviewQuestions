Given a array of N numbers, we need to maximize the sum of selected numbers. At each step, you need to select a number Ai, delete one occurrence of Ai-1 (if exists), and Ai each from the array. Repeat these steps until the array gets empty. The problem is to maximize the sum of the selected numbers.

Example 1:

Input : arr[ ] = {1, 2, 2, 2, 3, 4}
Output : 10
Explanation:
We select 4, so 4 and 3 are deleted leaving us with {1,2,2,2}.
Then we select 2, so 2 & 1 are deleted. We are left with{2,2}.
We select 2 in next two steps, thus the sum is 4+2+2+2=10.

Example 2:

Input : arr[ ] = {1, 2, 3} 
Output :  4
Explanation: We select 3, so 3 and 2 are deleted leaving us with {1}. Then we select 1, 0 doesn't exist so we delete 1. thus the sum is 3+1=4.
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maximizeSum() that takes an array (arr), sizeOfArray (n), and return the maximum sum of the selected numbers. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i] ≤ 105
Note: Numbers need to be selected from maximum to minimum.



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        //Complete the function
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            if (map.get(num) > 0) {
                sum += num;
                map.put(num, map.get(num) - 1);
                if (map.containsKey(num - 1) && map.get(num - 1) > 0) {
                    map.put(num - 1, map.get(num - 1) - 1);
                }
            }
        }
        return sum;
    }
    
    
}



Given an array A of N length. We need to calculate the next greater element for each element in a given array. If the next greater element is not available in a given array then we need to fill -10000000 at that index place.

Example 1:

Input : arr[] = {13, 6, 7, 12}
Output : _ 7 12 13 
Explanation:
Here, at index 0, 13 is the greatest value 
in given array and no other array element 
is greater from 13. So at index 0 we fill 
'-10000000'.

Example 2:

Input : arr[] = {6, 3, 9, 8, 10, 2, 1, 15, 7} 
Output :  7 6 10 9 15 3 2 _ 8
Explanation: Here, at index 7, 15 is the greatest
value in given array and no other array element is
greater from 15. So at index 7 we fill '-10000000'.
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function greaterElement() that takes an array (arr), sizeOfArray (n), and return an array that displays the next greater element to element at that index. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
-106 ≤ Ai ≤ 106



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        // Complete the function
        if (arr == null || n == 0) {
            return new int []{};
        }
        int [] greaterArray = new int [n];
        // clone method in java
        int [] copyArray = arr.clone(); // n
        Arrays.sort(copyArray); // nlogn
        Map<Integer, Integer> numberToRankMap = new HashMap<>(); //n
        for (int i = 0; i < n; i++) { // n
            int currentNumber = copyArray[i];
            numberToRankMap.put(currentNumber, i);
        }
        for (int i = 0; i < n; i++) { // n
            int currentNumber = arr[i];
            int rankOfCurrentNumber = numberToRankMap.get(currentNumber);
            if (rankOfCurrentNumber + 1 >= n) {
                greaterArray[i] = -10000000;
            }
            else {
                greaterArray[i] = copyArray[rankOfCurrentNumber + 1];
            }
        }
        return greaterArray;
    }
    
    
}

// TC nlogn + n + n
// SC n + n

The teacher gives a mental ability question to Raju. The question is as follows:-

Raju is in an elevator. Given by his teacher is an array of size N which denotes the number of floors and has a 1 based indexing. The elevator starts from the ground and moves up and down, X and Y floors respectively. There is a code used in the elevator according to which it moves up X floors given at odd indexes of the array and moves down Y floors given at even indexes of the array. He is asked to go to the highest floor possible. Help him to sort the array such that he reaches the highest floor after traversing the whole array from starting till the end, without skipping any index.

He always prefers to move more number of floors up and less number of floors down. Once he gets into the elevator, the elevator should not reach the ground again, if it does print Not Possible.

Example 1:

Input : arr[ ] = {2, 3, 4, 5}
Output : 5 2 4 3
Explanation:
Array can be arranged as {5,3,4,2} or 
{4,3,5,2} or {4,2,5,3} but it will get 
arranged as {5,2,4,3} because he always 
prefer to move more number of floors up 
and less number of floors down.

Example 2:

Input : arr[ ] = {1, 1} 
Output :  Not Possible 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function game_with_number() that takes sizeOfArray (n), an array (arr), and return the sorted array or if it is Not Possible return -1. The driver code takes care of the printing.

Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(1).

 


Constraints:

1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 103


class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> reaching_height (int n, int arr[]) {
        //Complete the function
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(arr[0]);
            return result;
        }
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int sum = 0;
        while (i <= j) {
            if (i == j) {
                result.add(arr[j]);
            }
            else {
                result.add(arr[j]);
                result.add(arr[i]);
            }
            sum += arr[j];
            sum -= arr[i];
            i++;
            j--;
        }
        if (sum == 0) {
            return new ArrayList<>(Arrays.asList(-1));
        }
        return result;
    }
    
    
}

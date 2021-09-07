Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.

Example 1:

Input:
N = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, 
second max = 5, second min = 2, and 
so on... Modified array is : 6 1 5 2 4 3.
Example 2:

Input:
N = 11
arr[]={10,20,30,40,50,60,70,80,90,100,110}
Output:110 10 100 20 90 30 80 40 70 50 60
Explanation: Max element = 110, min = 10, 
second max = 100, second min = 20, and 
so on... Modified array is : 
110 10 100 20 90 30 80 40 70 50 60.
Your Task:
The task is to complete the function rearrange() which rearranges elements as explained above. Printing of the modified array will be handled by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 107
1 <= arr[i] <= 107




// https://youtu.be/ZRoVWxBngX0

// first we need to start with the extra space approach, if insisted then only continue with this approach
class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
        
        // Your code here
        if (arr == null || n == 0)
            return;
        int maxPointer = n - 1;
        int minPointer = 0;
        int maxElement = arr[maxPointer] + 1;
        /*
        if i is even, arr[i] = arr[i] + arr[maxIndex] % maxEleemtn * maxEleemnt
        if i is off, arr[i] = arr[i] + arr[minIndex] % maxElement * maxElement
        
        here naxElement = max(arr) + 1
        */
        for (int i=0; i<n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + arr[maxPointer--] % maxElement * maxElement;
            }
            else {
                arr[i] = arr[i] + arr[minPointer++] % maxElement * maxElement;
            }
        }
        
        for (int i=0; i<n; i++) {
            arr[i] /= maxElement;
        }
        
        
        
    }
    
}



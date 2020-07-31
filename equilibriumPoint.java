Equilibrium position in an array is a position at which the sum of elements before it is equal to the sum of elements after it. Given an array arr, your task is to determine at which position equilibrium first occurs in the array. If there is no equilibrium position, the answer should be -1.

Example

For arr = [5], the output should be
equilibriumPoint(arr) = 1.

Explanation: Since this array only has one element, the equilibrium point is at position 1.

For arr = [10, 5, 3, 5, 2, 2, 6, 8], the output should be
equilibriumPoint(arr) = 4.

Explanation: The equilibrium point is at position 4, because the sum of elements before it - (10 + 5 + 3) - is equal to the sum of elements after it - (2 + 2 + 6 + 8).



1) Initialize leftsum  as 0
2) Get the total sum of the array as sum
3) Iterate through the array and for each index i, do following.
    a)  Update sum to get the right sum.  
           sum = sum - arr[i] 
       // sum is now right sum
    b) If leftsum is equal to sum, then return current index. 
       // update leftsum for next iteration.
    c) leftsum = leftsum + arr[i]
4) return -1 
// If we come out of loop without returning then
// there is no equilibrium index



Solution:

int equilibriumPoint(int[] arr) {
    int total_sum = 0;
    int left_sum = 0;
    for(int i = 0; i < arr.length; i++){
        total_sum += arr[i];
    }
    
    for(int i = 0; i < arr.length; i++){
        total_sum = total_sum - arr[i];
        if (total_sum == left_sum)
            return i + 1;
        left_sum = left_sum + arr[i];
    }
    return -1;
}

Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.


Example 1:

Input:
n = 5
k = 3
arr[] = {5,10,30,20,15}
Output: 35
Explanation: The most optimal way will be:
Painter 1 allocation : {5,10}
Painter 2 allocation : {30}
Painter 3 allocation : {20,15}
Job will be done when all painters finish
i.e. at time = max(5+10, 30, 20+15) = 35
Example 2:

Input:
n = 4
k = 2
arr[] = {10,20,30,40}
Output: 60
Explanation: The most optimal way to paint:
Painter 1 allocation : {10,20,30}
Painter 2 allocation : {40}
Job will be complete at time = 60

Your task:
Your task is to complete the function minTime() which takes the integers n and k and the array arr[] as input and returns the minimum time required to paint all partitions.


Expected Time Complexity: O(n log m) , m = sum of all boards' length
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 105

class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long sum = getSum(arr);
        long max = getMax(arr);
        return binarySearch(arr, max, sum, k);
    }
    
    static long binarySearch(int [] arr, long low, long high, int k) {
        while (low < high) {
            long middle = low + (high - low) / 2;
            int painters = findPainters(arr, middle);
            if (painters <= k) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    static int findPainters(int [] arr, long maxTime) {
        int painter = 1;
        long sum = 0;
        int length = arr.length;
        for (int i=0; i<length; i++) {
            sum += arr[i];
            if (sum > maxTime) {
                painter ++;
                sum = arr[i];
            }
        }
        return painter;
    } 
    
    static long getSum(int [] arr) {
        long total = 0;
        for (int number : arr) {
            total += number;
        }
        return total;
    }
    
    static long getMax(int [] arr) {
        long max = Integer.MIN_VALUE;
        for (int number : arr) {
            max = Math.max(max, number);
        }
        return max;
    }
}


Given an array Arr[] of N distinct integers and a range from L to R, the task is to count the number of triplets having a sum in the range [L, R].


Example 1:

Input:
N = 4
Arr = {8 , 3, 5, 2}
L = 7, R = 11
Output: 1
Explaination: There is only one triplet {2, 3, 5}
having sum 10 in range [7, 11].

Example 2:

Input:
N = 5
Arr = {5, 1, 4, 3, 2}
L = 2, R = 7
Output: 2
Explaination: There two triplets having 
sum in range [2, 7] are {1,4,2} and {1,3,2}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countTriplets() which takes the array Arr[] and its size N and L and R as input parameters and returns the count.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 103
1 ≤ Arr[i] ≤ 103
1 ≤ L ≤ R ≤ 109



/*
Idea behind solutions: 

Find triplets lesser than or equal to R 
Find triplets lesser than or equal to L-1
Subtract both to get number of triplets desired 
*/

class Solution {
    static int countTriplets(int arr[], int n, int l, int r) {
        // code here
        if (arr == null || n == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(arr);
        return countOfTripletesLessThan(arr, n, r) - countOfTripletesLessThan(arr, n, l-1);
    }
    
    static int countOfTripletesLessThan(int [] arr, int n, int value) {
        int count = 0;
        for (int i=0; i+2<n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > value) {
                    k--;
                }
                else {
                    count += k - j;
                    j++;
                }
            }
        }
        return count;
    }
}
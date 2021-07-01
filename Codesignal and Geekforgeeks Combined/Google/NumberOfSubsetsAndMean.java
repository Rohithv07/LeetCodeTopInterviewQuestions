Let Max be the maximum possible mean of a multiset of values obtained from an array Arr of length N. Let Min be the minimum possible mean of a multiset of values obtained from the same array. Note that in a multiset values may repeat. The task is to find the number of multisets with mean as Max and the number of multisets with mean as Min. The answer may be too large so output the number of multisets modulo 109+7.

 

Example 1:

Input:
N = 5
Arr = {3, 1, 2, 3, 4} 
Output:
1 1
Explanation:
The maximum possible Mean of a Subset
of the array is 4. There can be only 1
such subset - {3, 1, 2, 3, 4}.
The minimum possible Mean of a Subset
of the array is 1. There can be only 1
such subset - {3, 1, 2, 3, 4}.
Example 2:

Input:
N = 3
Arr = {1, 2, 1} 
Output:
1 3
Explanation:
The maximum possible Mean of a Subset
of the array is 2. There can be only 1
such subset - {1, 2, 1}.
The minimum possible Mean of a Subset
of the array is 1. There can be 3 such
subsets - {1, 2, 1}; {1, 2, 1}; {1, 2, 1}.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numOfSubsets() which takes an Integer N and an array Arr[] as input and returns a vector of two numbers- the number of multisets with mean as Max and the number of multisets with mean as Min.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 <= N <= 105
1 <= Arr[i] <= 105



class Solution {
    static int[] numOfSubsets(int[] arr , int n) {
        // code here
        if (n == 1)
            return new int [] {1, 1};
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int countMax = 0;
        int countMin = 0;
        int mod = (int)1e9 + 7;
        for (int number : arr) {
            if (number == max) {
                countMax = (countMax + 1) % mod;
            }
            else if (number == min) {
                countMin = (countMin + 1) % mod;
            }
        }
        return new int[] {(int) (Math.pow(2, countMax) - 1) % mod, 
        (int)(Math.pow(2, countMin) - 1) % mod}; 
    }
}

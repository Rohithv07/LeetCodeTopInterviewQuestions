Given an array of integers. Check whether it contains a triplet that sums up to zero. 

Example 1:

Input: n = 5, arr[] = {0, -1, 2, -3, 1}
Output: 1
Explanation: 0, -1 and 1 forms a triplet
with sum equal to 0.
Example 2:

Input: n = 3, arr[] = {1, 2, 3}
Output: 0
Explanation: No triplet with zero sum exists. 

Your Task:
You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and print 1 if the function returns true else print false if the function return false. 

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constrains:
1 <= n <= 104
-106 <= Ai <= 106





class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        if (n <= 2)
            return false;
        Arrays.sort(arr);
        for (int i=0; i+2<n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int target = -arr[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] == target) {
                    return true;
                }
                if (arr[j] + arr[k] > target) {
                    k -= 1;
                }
                else {
                    j += 1;
                }
            }
        }
        return false;
    }
}

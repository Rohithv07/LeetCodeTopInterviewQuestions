Given an array of distinct integers, find all the pairs having both negative and positive values of a number in the array.


Example 1:

Input:
n = 8
arr[] = {1,3,6,-2,-1,-3,2,7}
Output: -1 1 -3 3 -2 2
Explanation: 1, 3 and 2 are present 
pairwise postive and negative. 6 and 
7 have no pair.
Example 2:

Input:
n = 3
arr[] = {3,2,1}
Output: 0
Explanation: No such pair exists so the 
output is 0.

Your Task:
You do not need to read input or print anything. Complete the function findPairs() which takes the array A[] and the size of the array, n, as input parameters and returns a list of integers denoting the pairs. The pair that appears first in A[] should appear first in the returning list and within the pair the negative integer should appear before positive integer. Return an empty integer list if no such pair exists.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)


Constraints:
1 <= n <= 106
-106 <= arr[i] <= 106

class Solution
{
    //Function to return list containing all the pairs having both
    //negative and positive values of a number in the array.
    public static ArrayList<Integer>findPairs(int arr[], int n) 
    { 
    	// code here.
    	if (arr == null || n == 0) {
    	    return new ArrayList<>();
    	}
    	Set<Integer> trackPair = new HashSet<>();
    	ArrayList<Integer> result = new ArrayList<>();
    	for (int number : arr) {
    	    if (trackPair.contains(-1 * number)) {
    	        if (number > 0) {
    	            result.add(number * -1);
    	            result.add(number);
    	        }
    	        else {
    	            result.add(number);
    	            result.add(number * -1);
    	        }
    	    }
    	    else {
    	        trackPair.add(number);
    	    }
    	}
    	return result;
    }
}
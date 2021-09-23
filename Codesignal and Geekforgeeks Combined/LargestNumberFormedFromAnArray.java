Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.


Example 1:

Input: 
N = 5
Arr[] = {3, 30, 34, 5, 9}
Output: 9534330
Explanation: Given numbers are {3, 30, 34,
5, 9}, the arrangement 9534330 gives the
largest value.
Example 2:

Input: 
N = 4
Arr[] = {54, 546, 548, 60}
Output: 6054854654
Explanation: Given numbers are {54, 546,
548, 60}, the arrangement 6054854654 
gives the largest value.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function printLargest() which takes the array of strings arr[] as parameter and returns a string denoting the answer.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
0 ≤ Arr[i] ≤ 1018
Sum of all the elements of the array is greater than 0.


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return "";
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String combinedS1S2 = s1 + s2;
                String combinedS2S1 = s2 + s1;
                return combinedS1S2.compareTo(combinedS2S1) > 0 ? -1 : 1;
            }
            });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
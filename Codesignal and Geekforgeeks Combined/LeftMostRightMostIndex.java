Given a sorted array with possibly duplicate elements. The task is to find indexes of first and last occurrences of an element X in the given array.

Note: If the element is not present in the array return {-1,-1} as pair.

 

Example 1:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}
X = 5
Output:
2 5
Explanation:
Index of first occurrence of 5 is 2
and index of last occurrence of 5 is 5.
Example 2:

Input:
N = 9
v[] = {1, 3, 5, 5, 5, 5, 7, 123, 125}
X = 7
Output:
6 6
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function indexes() which takes the array v[] and an integer X as inputs and returns  the first and last occurrence of the element X. If the element is not present in the array return {-1,-1} as pair.

Can you solve the problem in expected time complexity?


Expected Time Complexity: O(Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ v[i], X ≤ 1018

//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        if (v == null || v.length == 0)
            return new pair(-1, -1);
        int length = v.length;
        int low = 0;
        int high = length - 1;
        int index = -1;
        while (low <= high) {
            int middle = low + (high - low);
            if (v[middle] == x) {
                index = middle;
                break;
            }
            else if (v[middle] > x) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        if (index == -1) {
            return new pair(-1, -1);
        }
        pair p = new pair(-1, -1);
        for (int i=index; i>=0; i--) {
            if (v[i] == x) {
                p.first = i;
            }
            else {
                break;
            }
        }
        for (int i=index; i<length; i++) {
            if (v[i] == x) {
                p.second = i;
            }
            else {
                break;
            }
        }
        return p;
    }
}
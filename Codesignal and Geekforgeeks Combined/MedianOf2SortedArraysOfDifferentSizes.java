Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:

Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5
Example 2:

Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5
Your Task:
The task is to complete the function MedianOfArrays() that takes array1 and array2 as input and returns their median. 

Can you solve the problem in expected time complexity?

Expected Time Complexity: O(min(log n, log m)).
Expected Auxiliary Space: O((n+m)/2).

Constraints: 
0 ≤ m,n ≤ 104
1 ≤ array1[i], array2[i] ≤ 105


class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int [] sorted = new int [n + m];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            int value1 = a[i];
            int value2 = b[j];
            if (value1 < value2) {
                sorted[index++] = value1;
                i++;
            }
            else if (value2 < value1) {
                sorted[index++] = value2;
                j++;
            }
            else {
                sorted[index++] = value1;
                i++;
            }
        }
        while (i < n) {
            sorted[index++] = a[i];
            i++;
        }
        while (j < m) {
            sorted[index++] = b[j];
            j++;
        }
        int sortedLength = m + n;
        if (sortedLength % 2 == 1) {
            int middle = sortedLength / 2;
            return (double)sorted[middle];
        }
        int middle1 = (sortedLength / 2);
        int middle2 = (sortedLength / 2 - 1);
        double v1 = (double)(sorted[middle1]);
        double v2 = (double)(sorted[middle2]);
        return (v1 + v2) / 2;
        
    }
}



// explained in youtuve strivers video

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        if (m < n) {
            return medianOfArrays(m, n, b, a);
        }
        int left = 0;
        int right = n;
        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = ((m + n + 1) / 2) - cut1;
            int leftPart1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int leftPart2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int rightPart1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int rightPart2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];
            if (leftPart1 <= rightPart2 && leftPart2 <= rightPart1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftPart1, leftPart2) + Math.min(rightPart1, rightPart2)) / 2.0;
                }
                return Math.max(leftPart1, leftPart2);
            }
            if (leftPart1 > rightPart2) {
                right = cut1 - 1;
            }
            else {
                left = cut1 + 1;
            }
        }
        return 0.0;
    }
}
Given an array arr of size n, the task is to find the maximum triplet product in the array.


Example 1:

Input:
n = 4
arr[] = {1, 2, 3, 5}
Output:
30
Explanation:
5*3*2 gives 30. This is the maximum possible
triplet product in the array.
Example 2:

Input:
n = 7
arr[] = {-3, -5, 1, 0, 8, 3, -2} 
Output:
120
Explanation: 
-3*-5*8 gives 120. This is the maximum possible triplet product in the array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxTripletProduct() which takes an integer n and an array arr and returns the maximum triplet product in the array.


Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)


Constraints:
3 ≤ N ≤ 5*105
-106 ≤ A[i] ≤ 106


class Solution {
    Long maxTripletProduct(Long arr[], int n)

    {

        Long min1 , min2;

        min1 = min2= Long.MAX_VALUE;

        Long max1 , max2 ,max3;

        max1 = max2 = max3= Long.MIN_VALUE;

        for(int i=0;i<n;i++)

        {

            if(max1<arr[i])

            {

                max3 = max2;

                max2=max1;

                max1=arr[i];

            }

            else if(max2<arr[i])

            {

                max3 = max2;

                max2=arr[i];

            }

            else if(max3 < arr[i])

            {

                max3 =arr[i];

            }

            

            if(min1>arr[i])

            {

                min2 = min1;

                min1 = arr[i];

            }

            else if(min2 > arr[i])

            {

                min2 = arr[i];

            }

        }

        

        return Math.max(max1*max2*max3, max1*min1*min2);

    }
}
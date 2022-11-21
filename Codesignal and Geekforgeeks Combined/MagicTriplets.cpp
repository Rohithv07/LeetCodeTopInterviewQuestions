Given an array of size n, a triplet (a[i], a[j], a[k]) is called a Magic Triplet if a[i] < a[j] < a[k] and i < j < k.  Count the number of magic triplets in a given array.
 

Example 1:

Input: arr = [3, 2, 1]
Output: 0
Explanation: There is no magic triplet.

Example 2:

Input: arr = [1, 2, 3, 4]
Output: 4
Explanation: Fours magic triplets are 
(1, 2, 3), (1, 2, 4), (1, 3, 4) and 
(2, 3, 4).
 

Your Task:
You don't need to read or print anything. Your task is to complete the function countTriplets() which takes the array nums[] as input parameter and returns the number of magic triplets in the array.

 

Expected Time Complexity: O(N2) 
Expected Space Complexity: O(1)
 

Constraints:
1 <= length of array <= 1000
1 <= arr[i] <= 100000



int countTriplets(vector<int>arr){

     // Code here.

     int s=0, e=0, i=0, j=0, p=0, q=0;

     int ans=0;

     int n =arr.size();

     for(i=1;i<n-1;i++){

         s=0,e=i+1;

         p=0,q=0;

         for(j=0;j<i;j++){

             if(arr[i]>arr[j]){

                 p++;

             }

         }

          for(j=i+1;j<n;j++){

             if(arr[i]<arr[j]){

                 q++;

             }

         }

         ans+=p*q;

     }

     return ans;
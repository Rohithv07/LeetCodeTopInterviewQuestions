Given two integer arrays Arr1 and Arr2 of size N. Use the greatest elements from the given arrays to create a new array of size N such that it consists of only unique elements and the sum of all its elements is maximum.
The created elements should contain the elements of Arr2 followed by elements of Arr1 in order of their appearance.


Example 1:

Input:
N = 5
Arr1 = {7, 4, 8, 0, 1}
Arr2 = {9, 7, 2, 3, 6}
Output: 9 7 6 4 8
Explanation: 9, 7, 6 are from 2nd array
and 4, 8 from 1st array.

Example 2:

Input: N = 4
Arr1 = {6, 7, 5, 3}
Arr2 = {5, 6, 2, 9} 
Output: 5 6 9 7 
Explanation: 5, 6, 9 are from 2nd array
and 7 from 1st array.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximizeArray() which takes the array arr1[], arr2[] and n as input parameters and returns the desired array of integers.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 <= N <= 105
0 <=| Arr1[i] |<= 109
0 <= |Arr2[i] |<= 109



class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
      HashSet<Integer> set2=new HashSet<Integer>();
      for(int i=0;i<n;i++)
      {
           set2.add(arr2[i]);
      }
      for(int i=0;i<n;i++)
      {
         set2.add(arr1[i]);
      }
      
    ArrayList<Integer> al = new ArrayList<Integer>();
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
  for(int i:set2){
        pq.add(i);
  }
  HashSet<Integer> set=new HashSet<Integer>();
      for(int i=0;i<n;i++)
  while(!pq.isEmpty()&&set.size()<n){
      set.add(pq.poll());
  }
  
  ArrayList<Integer> al1 = new ArrayList<Integer>();
 
   for(int i:arr2){
       if(set.contains(i)&&!al.contains(i))
          al.add(i);
   }
   for(int i:arr1){
       if(set.contains(i)&&!al.contains(i))
          al.add(i);
   }
       
       return al;
   }
}
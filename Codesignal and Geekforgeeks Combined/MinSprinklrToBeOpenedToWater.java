Input:
n = 6
gallery[ ] = {-1, 2, 2, -1, 0, 0}
Output:
2
Explanation: Sprinklers at index 2 and 5
can water thefull gallery, span of
sprinkler at index 2 = [0,4] and span
â€‹of sprinkler at index 5 = [5,5].
Example 2:

Input:
n = 9
gallery[ ] = {2, 3, 4, -1, 2, 0, 0, -1, 0}
Output:
-1
Explanation: No sprinkler can throw water
at index 7. Hence all plants cannot be
watered.
Example 3:

Input:
n = 9
gallery[ ] = {2, 3, 4, -1, 0, 0, 0, 0, 0}
Output:
3
Explanation: Sprinkler at indexes 2, 7 and
8 together can water all plants.
Your task:
Your task is to complete the function min_sprinklers() which takes the array gallery[ ] and the integer n as input parameters and returns the value to be printed.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
       List<List<Integer>> list = new ArrayList<>();
       for (int i=0; i<n; i++) {
           List<Integer> row = new ArrayList<>();
           if (gallery[i] != -1) {
               row.add(Math.max(0, i - gallery[i]));
               row.add(Math.min(i + gallery[i], n-1));
               list.add(row);
           }
       }
       list.sort((l1, l2) -> l1.get(0) - l2.get(0));
       int current = 0;
       int count = 0;
       int i = 0;
       int maxRange = 0;
       while (current < n) {
           if (list.size() <= i || current < list.get(i).get(0)) {
               return -1;
           }
           maxRange = list.get(i).get(1);
           while (i < list.size() - 1 && list.get(i + 1).get(0) <= current) {
               i += 1;
               maxRange = Math.max(list.get(i).get(1), maxRange);
           }
           if (maxRange < current) {
               return -1;
           }
           count += 1;
           i += 1;
           current = maxRange + 1;
       }
       return count;
    }
}


Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.

Your Task:
The task is to complete the function majorityElement() which returns the majority element in the array. If no majority exists, return -1.
 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
1 <= N <= 107
0 <= Ai <= 106


class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        if (size == 1)
        return a[0];
        Arrays.sort(a);
        int limit = size / 2;
        int count = 1;
        for (int i=1; i<size; i++) {
            int current = a[i];
            if (a[i - 1] == a[i]) {
                count += 1;
            }
            else {
                count = 1;
            }
            if (count > limit) {
                    return current;
                }
        }
        return -1;
    }
}

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        // O(n) space and O(1) time
        if (a == null || size == 0)
            return -1;
        Map<Integer, Integer> freq = new HashMap<>();
        int limit = size / 2;
        for (int number : a) {
            freq.put(number, freq.getOrDefault(number, 0) + 1);
        }
        for (int key : freq.keySet()) {
            int value = freq.get(key);
            if (value > limit)
                return key;
        }
        return -1;
        
        // O(1) space using moores voting algorithm
        int max = a[0];
        int count = 1;
        for (int i=1; i<size; i++) {
            if (max == a[i]) {
                count += 1;
            }
            else {
                count -= 1;
            }
            if (count == 0) {
                max = a[i];
                count += 1;
            }
        }
        count = 0;
        for (int number : a) {
            if (number == max) {
                count ++;
            }
        }
        return count > size / 2 ? max : -1;
    }
}





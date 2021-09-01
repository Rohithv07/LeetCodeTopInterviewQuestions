Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N

// using xor

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int [] result = new int [2];
        int xor = 0;
        int setBit1Group = 0;
        int setBit0Group = 0;
        // first find the xor from the arr
        for (int i=0; i<n; i++) {
            xor ^= arr[i];
        }
        // now use this xor and continue xor with 1 to n
        for (int i=1; i<=n; i++) {
            xor ^= i;
        }
        // find the rightmost setbit
        int setBit = xor & ~(xor - 1);
        // now make two groups from the arr where the rightmost bit is 0 or 1
        // comparing rightmost set bit of xor1 with the bit at the same position in each element.
        for (int i=0; i<n; i++) {
            if ((arr[i] & setBit) != 0) {
                setBit1Group ^= arr[i];
            }
            else {
                setBit0Group ^= arr[i];
            }
        }
        // same way do this from i = 1 to n inclusive
        for (int i=1; i<=n; i++) {
            if ((i & setBit) != 0) {
                setBit1Group ^= i;
            }
            else {
                setBit0Group ^= i;
            }
        }
        // we have either the value in setBit1 or setBit0 as repeating and missing
        // we can make sure by traversing oncemore
        for (int i=0; i<n; i++) {
            if (arr[i] == setBit1Group) {
                result[0] = setBit1Group;
                result[1] = setBit0Group;
                break;
            }
            else if (arr[i] == setBit0Group) {
                result[0] = setBit0Group;
                result[1] = setBit1Group;
                break;
            }
        }
        return result;
    }
}


class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        for (int i=0; i<n; i++) {
            int currentValue = Math.abs(arr[i]);
            if (arr[currentValue - 1] > 0) {
                arr[currentValue - 1] = -arr[currentValue - 1];
            }
            else {
                result[0] = currentValue;
            }
        }
        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
}

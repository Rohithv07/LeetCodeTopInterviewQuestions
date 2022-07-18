Given an array Arr of size N containing positive integers. Count number of smaller elements on right side of each array.

Example 1:

Input:
N = 7
Arr[] = {12, 1, 2, 3, 0, 11, 4}
Output: 6 1 1 1 0 1 0
Explanation: There are 6 elements right
after 12. There are 1 element right after
1. And so on.
Example 2:

Input:
N = 5
Arr[] = {1, 2, 3, 4, 5}
Output: 0 0 0 0 0
Explanation: There are 0 elements right
after 1. There are 0 elements right after
2. And so on.
Your Task:
You don't need to read input or print anything. Your task is to complete the function constructLowerArray() which takes the array of integers arr and n as parameters and returns an array of integers denoting the answer.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106
0 ≤ Arri  ≤ 108


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        Pair [] pair = new Pair [n];
        int [] result = new int [n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(arr[i], i);
        }
        mergesort(pair, result, 0, n - 1);
        return result;
    }
    
    void mergesort(Pair[] pair, int [] result, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        mergesort(pair, result, low, middle);
        mergesort(pair, result, middle + 1, high);
        merge(pair, result, low, middle, high);
    }
    
    void merge(Pair[] pair, int [] result, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        int k = 0;
        int inversionCount = 0;
        Pair [] current = new Pair[high - low + 1];
        while (i <= middle && j <= high) {
            if (pair[i].number <= pair[j].number) {
                result[pair[i].index] += inversionCount;
                current[k++] = pair[i++];
            }
            else {
                inversionCount++;
                current[k++] = pair[j++];
            }
        }
        while (i <= middle) {
            result[pair[i].index] += inversionCount;
            current[k++] = pair[i++];
        }
        while (j <= high) {
            current[k++] = pair[j++];
        }
        for (i = low; i <= high; i++) {
            pair[i] = current[i - low];
        }
    }
}

class Pair {
    int number;
    int index;
    
    Pair(int number, int index) {
        this.number = number;
        this.index = index;
    }
}
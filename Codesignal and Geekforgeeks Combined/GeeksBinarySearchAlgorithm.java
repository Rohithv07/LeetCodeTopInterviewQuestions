

// https://practice.geeksforgeeks.org/contest/interview-series-46/problems

// https://youtu.be/vLpolU5kDhs

class Solution{
	int modified_binary_search(int [] arr, int n)
    {
        //Write your code here
        // the only change in the algorithm is we are taking some random number
        // as the pivot.
        // so if there is a target, and inorder to find that target, all the elements
        // to the left must be smaller than the target
        // and every element to the right of target must larger than target
        // if we are able to find this, then we can have our count incremented.
        // so will be maintaining extra space to store the prefixMaxSoFar and suffixMinSoFar
        // and if we are able to satisfy the condition, then we increment the count
        if (n == 1) {
            return 1;
        }
        int [] prefix = new int [n];
        int [] suffix = new int [n];
        prefix[0] = arr[0];
        suffix[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            // handle for the last number and first number separately
            if (i == 0) {
                if (suffix[i + 1] > arr[i]) {
                    count++;
                }
            }
            else if (i == n - 1) {
                if (prefix[i - 1] < arr[i]) {
                    count++;
                }
            }
            else {
                int current = arr[i];
                if (prefix[i - 1] < current && suffix[i + 1] > current) {
                    count++;
                }
            }
        }
        return count;
    }
}
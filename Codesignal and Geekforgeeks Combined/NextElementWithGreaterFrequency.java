Given an array arr[ ] of n integers, for every element, find the closest element on it's right that has a greater frequency than its own frequency.

Frequency is the number of times the element appears in the array.

 

Example 1:

Input:
n = 6
arr[] = {2 1 1 3 2 1}
Output:
1 -1 -1 2 1 -1 
Explanation:
1 appears 3 times.
2 appears 2 times.
3 appears 1 time. 

For arr[0] ie, 2
arr[1] ie 1 is the closest element on its 
right which has greater frequency than the 
frequency of 2. For the arr[1] and arr[2] no element 
on the right has greater frequency than 1, 
so -1 will be printed. and so on. 
Example 2:

Input:
n = 11
arr[] = {10 5 1 2 3 2 5 5 4 5 2}
Output:
-1 2 5 2 5 -1 -1 5 -1 -1
 

Your task:
Your task is to complete the function print_next_greater_freq() which take two parameters arr and n.This function returns answer(as a list of integers) as explained above.


Expected time complexity: O(n)
Expected space complexity: O(n)


Constraints:
1 <= n <= 104
1 <= arr[i] <= 104


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        int max = findMax(arr);
        int [] frequencyTable = new int [max + 1];
        fillFrequencyTable(frequencyTable, arr);
        Stack<Integer> stack = new Stack<>();
        int [] result = new int [n];
        //stack.push(0);
        // O(n)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && frequencyTable[arr[stack.peek()]] < 
            frequencyTable[arr[i]]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        // O(n) // 1 1 1 1 1 1 1 1 1 1 1 1. 1 1 1 1
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
    
    // O(n)
    static void fillFrequencyTable(int [] frequencyTable, int [] arr) {
        for (int num : arr) {
            frequencyTable[num] += 1;
        }
    }
    
    // O(n)
    static int findMax(int [] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}


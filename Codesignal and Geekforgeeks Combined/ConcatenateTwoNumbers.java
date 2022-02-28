Given an array numbers[] of N positive integers and a positive integer X, The task is to find the number of ways that X can be obtained by writing pair of integers in the array numbers[] next to each other. In other words, find the number of ordered pairs (i,j) such that i != j and X is the concatenation of numbers[i] and numbers[j]

Example 1:

Input:
N = 4 
numbers[] = {1, 212, 12, 12}
X = 1212
Output:
3
Explanation:
We can obtain X=1212 by concatenating:
numbers[0] = 1 with numbers[1] = 212
numbers[2] = 12 with numbers[3] = 12
numbers[3] = 12 with numbers[2] = 12
Example 2:

Input: 
N = 3
numbers[] = {11, 11, 110}
X = 11011
Output:
2
Explanation:
We can obtain X=11011 by concatenating:
numbers[2] = 110 with numbers[0] = 11
numbers[2] = 110 with numbers[1] = 11
Your Task:
You dont need to read input or print anything. Your task is to complete the function countPairs() which takes the integer N , the integer X, and the array numbers[] as the input parameters, and returns the number of pairs which satisfies the above condition.

Expected Time Complexity: O(N*Log10(A[i]) + (Log10X)2)
Expected Auxiliary Space: O(N*Log10(A[i]))

Constraints:
1 ≤ N ≤ 5*104 
1 ≤ numbers[] ≤ 109
1 ≤ X ≤ 109



// https://practice.geeksforgeeks.org/contest/interview-series-phonepe/instructions/#

//User function Template for Java
class Solution 
{ 
    long countPairs(int n, int x, int numbers[]) 
    { 
        // code here
        String converted = Integer.toString(x);
        Map<String, Integer> map = new HashMap<>();
        for (int number : numbers) {
            String s = Integer.toString(number);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        long count = 0;
        for (int i=0; i<converted.length(); i++) {
            String s1 = converted.substring(0, i + 1);
            String s2 = converted.substring(i + 1);
            long count1 = map.getOrDefault(s1, 0);
            long count2 = map.getOrDefault(s2, 0);
            if (s1.equals(s2)) {
                count += (count1 * (count2 - 1));
            }
            else {
                count += (count1 * count2);
            }
        }
        return count;
    }
} 


class Solution 
{ 
    long countPairs(int n, int x, int numbers[]) 
    { 
        // code here
        long count = 0;
        String [] stringNumbers = new String [n];
        String target = String.valueOf(x);
        int index = 0;
        for (int number : numbers) {
            stringNumbers[index++] = String.valueOf(number);
        }
        Map<String, Integer> trackCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String currentNumber = stringNumbers[i];
            if (target.startsWith(currentNumber)) {
                String suffix = target.substring(currentNumber.length());
                count += trackCount.getOrDefault(suffix, 0);
            }
            if (target.endsWith(currentNumber)) {
                String prefix = target.substring(0, target.length() - currentNumber.length());
                count += trackCount.getOrDefault(prefix, 0);
            }
            trackCount.put(currentNumber, trackCount.getOrDefault(currentNumber, 0) + 1);
        }
        return count;
    }
} 
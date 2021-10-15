Given an array arr[] of length n. Find all possible unique permutations of the array.


Example 1:

Input: 
n = 3
arr[] = {1, 2, 1}
Output: 
1 1 2
1 2 1
2 1 1
Explanation:
These are the only possible unique permutations
for the given array.
Example 2:

Input: 
n = 2
arr[] = {4, 5}
Output: 
4 5
5 4

Your Task:
You don't need to read input or print anything. You only need to complete the function uniquePerms() that takes an integer n, and an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.


Expected Time Complexity:  O(n*n!)
Expected Auxilliary Space: O(n*n!)
 

Constraints:
1 ≤ n ≤ 10
1 ≤ arri ≤ 10


class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        if (arr == null || arr.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        Collections.sort(arr);
        boolean [] used = new boolean [arr.size()];
        backtrackHelper(arr, result, current, 0, used);
        return result;
    }
    
    static void backtrackHelper(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int position, boolean [] used) {
        if (current.size() == arr.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (position >= arr.size()) {
            return;
        }
        for (int i=position; i<arr.size(); i++) {
            if (used[i] || i > position && arr.get(i) == arr.get(i - 1) && !used[i - 1])
                continue;
            used[i] = true;
            current.add(arr.get(i));
            backtrackHelper(arr, result, current, 0, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
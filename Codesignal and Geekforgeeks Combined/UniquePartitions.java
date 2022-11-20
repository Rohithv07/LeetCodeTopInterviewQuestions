Given a positive integer n, generate all possible unique ways to represent n as sum of positive integers.

Note: The generated output is printed without partitions. Each partition must be in decreasing order. Printing of all the partitions is done in reverse sorted order. 

Example 1:

Input: n = 3
Output: 3 2 1 1 1 1
Explanation: For n = 3, 
{3}, {2, 1} and {1, 1, 1}.
 

Example 2:

Input: n = 4 
Output: 4 3 1 2 2 1 1 1 1 
Explanation: For n = 4, 
{4}, {3, 1}, {2, 2}, {1, 1, 1, 1}.

Your Task:
You don't need to read or print anything. Your task is to complete the function UniquePartitions() which takes n as input parameter and returns a list of all possible combinations in lexicographically decreasing order. 
 

Expected Time Complexity: O(2^n)
Expected Space Complexity: O(n)

 

Constraints:
1 <= n <= 25

//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(result, current, n, n);
        return result;
    }
    
    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int i, int n) {
        if (n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (i < 1) {
            return;
        }
        if (i <= n) {
            current.add(i);
            backtrack(result, current, i, n - i);
            current.remove(current.size() - 1);
            backtrack(result, current, i - 1, n);
        }
        else {
            backtrack(result, current, i - 1, n);
        }
    }
}
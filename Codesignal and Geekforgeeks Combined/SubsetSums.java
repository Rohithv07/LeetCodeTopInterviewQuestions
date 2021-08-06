Given a list arr of N integers, print sums of all subsets in it. Output should be printed in increasing order of sums.

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
Example 2:

Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
Your Task:  
You don't need to read input or print anything. Your task is to complete the function subsetSums() which takes a list/vector and an integer N as an input parameter and return the list/vector of all the subset sums in increasing order.

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(2N)

Constraints:
1 <= N <= 15
0 <= arr[i] <= 10000



class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n){
        // code here
        if (arr == null || n == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        backtrack(subset, current, 0, arr);
        for (ArrayList<Integer> set : subset) {
            if (set == null || set.size() == 0)
                result.add(0);
            else {
                int sum = 0;
                for (int number : set) {
                    sum += number;
                }
                result.add(sum);
            }
        }
        Collections.sort(result);
        return result;
    }
    
    void backtrack(ArrayList<ArrayList<Integer>> subset, ArrayList<Integer> current, int pos, ArrayList<Integer>arr) {
        subset.add(new ArrayList<>(current));
        for (int i=pos; i<arr.size(); i++) {
            current.add(arr.get(i));
            backtrack(subset, current, i+1, arr);
            current.remove(current.size() - 1);
        }
    }
}
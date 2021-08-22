Given an array of integers and a sum B, find all unique combinations in the array where the sum is equal to B. The same number may be chosen from the array any number of times to make B.

Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, …, ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.


Example 1:

Input:
N = 4
arr[] = {7,2,6,5}
B = 16
Output:
(2 2 2 2 2 2 2 2)
(2 2 2 2 2 6)
(2 2 2 5 5)
(2 2 5 7)
(2 2 6 6)
(2 7 7)
(5 5 6)
Example 2:

Input:
N = 11
arr[] = {6,5,7,1,8,2,9,9,7,7,9}
B = 6
Output:
(1 1 1 1 1 1)
(1 1 1 1 2)
(1 1 2 2)
(1 5)
(2 2 2)
(6)

Your Task:
Your task is to complete the function combinationSum() which takes the array A and a sum B as inputs and returns a list of list denoting the required combinations in the order specified in the problem description. The printing is done by the driver's code. If no set can be formed with the given set, then  "Empty" (without quotes) is printed.


Expected Time Complexity: O(X2 * 2N), where X is average of summation B/arri for every number in the array.
Expected Auxiliary Space: O(X * 2N)


Constraints:
1 <= N <= 30
1 <= A[i] <= 20
1 <= B <= 100



class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int target)
    {
        // add your code here
        if (a == null || a.size() == 0)
            return new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int number : a) {
            set.add(number);
            // this is to remove the duplicate from our answer as we need  only
            // unique answer;
        }
        a.clear();
        for (int number : set) {
            a.add(number);
        }
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backtrack(result, current, a, target, 0, 0);
        //Collections.sort(result, (p1, p2) -> p2.size() - p1.size());
        return result;
    }
    
    static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, ArrayList<Integer> a, int target, int currentSum, int pos) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            Collections.sort(current);
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=pos; i<a.size(); i++) {
            current.add(a.get(i));
            backtrack(result, current, a, target, currentSum + a.get(i), i);
            current.remove(current.size() - 1);
        }
    }
}
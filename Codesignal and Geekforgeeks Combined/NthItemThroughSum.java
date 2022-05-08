Given two sorted arrays A and B of length L1 and L2, we can get a set of sums(add one element from the first and one from second). Find the Nth element in the set considered in sorted order.
Note: Set of sums should have unique elements.

Example 1:

Input: L1 = 2, L2 = 2
A = {1, 2}
B = {3, 4}
N = 3
Output: 6
Explaination: The set of sums are in 
the order 4, 5, 6.
Example 2:

Input: L1 = 5, L2 = 4
A = {1, 3, 4, 8, 10}
B = {20, 22, 30, 40}
N = 4
Output: 25
Explaination: The numbers before it 
are 21, 23 and 24.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nthItem() which takes L1, L2, A, B, and the value N as input parameters and returns the Nth value of the set. If N is greater than the size of the set then it returns -1.

Expected Time Complexity: O((L1*L2)*log(L1*L2))
Expected Auxiliary Space: O(L1*L2)

Constraints:
1 ≤ L1, L2 ≤ 500
1 ≤ A[i], B[i] ≤ 10000
1 ≤ N ≤ L1*L2



//User function Template for Java

class Solution{
    static int nthItem(int l1, int l2, int a[], int b[], int n)
    {
        // code here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                set.add(a[i] + b[j]);
            }
        }
        if (n > set.size()) {
            return -1;
        }
        List<Integer> store = new ArrayList<>();
        for (int val : set) {
            store.add(val);
        }
        Collections.sort(store);
        return store.get(n - 1);
    }
}
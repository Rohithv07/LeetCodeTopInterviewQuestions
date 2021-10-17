Given two Arrays A[] and B[] of length N and M respectively. Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
Note: Array B[] is sorted and all its elements are distinct.

 

Example 1:

Input:
N = 5, M = 3
A[] = {1, 2, 5, 3, 1}
B[] = {1, 3, 5}
Output:
4
Explanation:
We need to delete 2 and replace it with 3.
This costs 2 steps. Further, we will have to
delete the last two elements from A to
obtain an identical array to B. Overall, it
results in 4 steps.
Example 2:
Input:
N = 2, M = 2
A[] = {1, 4}
B[] = {1, 4}
Output :
0
Explanation:
Both the Arrays are already identical.

Your Task:  
You dont need to read input or print anything. Your task is to complete the function minInsAndDel() which takes two integers N and M, and two arrays A of size N and B of size M respectively as input and returns the minimum insertions and deletions required.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i], B[i] ≤ 105


class Solution {
  public:
    int minInsAndDel(int a[], int b[], int n, int m) {
        // code here
        vector<int> new_a, lis, mp(1e5 + 1, 0);
    for (int i = 0; i < m; i++)mp[b[i]]++;
    for (int i = 0; i < n; i++)if (mp[a[i]])new_a.push_back(a[i]);
    for (auto x : new_a) { // finding LIS in O(NlogN) of new_a.
        auto it = lower_bound(lis.begin(), lis.end(), x);
        if (it != lis.end())*it = x;
        else lis.push_back(x);
    }
    return n + m - 2 * lis.size(); 
    }
};
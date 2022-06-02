N children are made to stand in a queue. Each of them is given a number A[i]. The teacher writes a number S on a page and passes it to the first child. Each child must add all the numbers they see on the page along with their own number, write the sum on the paper and pass it to the next person. 
In the end, the teacher must determine if X can be formed by adding some of the numbers from the series of numbers written on the paper.

Example 1:

Input: 
S = 1, N = 4, X = 7
A = {1, 2, 4, 2}
Output: yes
Explaination: The final sequence of 
numbers on the paper is 1, 2, 5, 12, 22. 
Using 2 and 5 we can form 7. 

Example 2:

Input: 
S = 100, N = 2, X = 500
A = {51, 88}
Output: no
Explaination: The final sequence of 
numbers on the paper is 100, 151, 339. 
Using these numbers we cannot form 500.

Your Task:
You do not need to read input or print anything. Your task is to complete the function isPossible() which takes S, N, X and array A as input parameters and returns 1 if there is a subset which adds to this sum. Otherwise returns 0.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 

Constraints
1 ≤ N ≤ 105
1 ≤ S, Ai , X ≤ 1018  



class Solution{
    static int isPossible(long s, int n, long x, long a[])
    {
        // code here
        List<Long> store = new ArrayList<>();
        store.add(s);
        long sum = 0;
        long runningSum = 0;
        store.add(s + a[0]);
        runningSum = store.get(0) + store.get(1);
        for (int i = 1; i < n; i++) {
            sum = a[i] + runningSum;
            if (sum > x) {
                break;
            }
            store.add(sum);
            runningSum += sum;
        }
        for (int i = store.size() - 1; i >= 0; i--) {
            if (store.get(i) > x) {
                continue;
            }
            x -= store.get(i);
            if (x == 0) {
                return 1;
            }
        }
        return 0;
    }
}
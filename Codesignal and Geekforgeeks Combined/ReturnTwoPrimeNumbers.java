Given an even number N (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only the pair whose minimum value is the smallest among all the minimum values of pairs and print the minimum element first.

NOTE: A solution will always exist, read Goldbachs conjecture. 

Example 1:

Input: N = 74
Output: 3 71
Explaination: There are several possibilities 
like 37 37. But the minimum value of this pair 
is 3 which is smallest among all possible 
minimum values of all the pairs.
Example 2:

Input: 4
Output: 2 2
Explaination: This is the only possible 
prtitioning of 4.
Your Task:
You do not need to read input or print anything. Your task is to complete the function primeDivision() which takes N as input parameter and returns the partition satisfying the condition.

Expected Time Complexity: O(N*log(logN))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104  


//User function Template for Java

class Solution{
    static List<Integer> primeDivision(int n){
        // code here
        for (int i = 2; i <= n / 2; i++) {
            if (primeCheck(i) && primeCheck(n - i)) {
                return Arrays.asList(new Integer[]{i, n - i});
            }
        }
        return new ArrayList<>();
    }
    
    static boolean primeCheck(int num) {
        for (int i = 2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
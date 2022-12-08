You are given a list of q queries and for every query, you are given an integer N.  The task is to find how many numbers(less than or equal to N) have number of divisors exactly equal to 3.

Example 1:

Input:
q = 1
query[0] = 6
Output:
1
Explanation:
There is only one number 4 which has
exactly three divisors 1, 2 and 4 and
less than equal to 6.
Example 2:

Input:
q = 2
query[0] = 6
query[1] = 10
Output:
1
2
Explanation:
For query 1 it is covered in the
example 1.
query 2: There are two numbers 4 and 9
having exactly 3 divisors and less than
equal to 10.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function threeDivisors() which takes an integer q and a list of integer of size q as input parameter and returns the list containing the count of the numbers having exactly 3 divisors for each query.

Expected Time Complexity: O(q*N*log(log(N)))
Expected Auxiliary Space: O(N), where N is min(10^6,N)

Constraints : 
1 <= q <= 10^3
1 <= query[i] <= 10^12



//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        ArrayList<Integer> result = new ArrayList<>();
        int limit = (int)(1e6);
        boolean [] primeTracker = new boolean [limit + 1];
        sievePrimeNumber(limit + 1, primeTracker);
        for (Long que : query) {
            int count = 0;
            int val = (int)Math.sqrt(que);
            for (int i = 2; i <= val; i++) {
                if (!primeTracker[i]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
    
    static void sievePrimeNumber(long n, boolean [] primeTracker) {
        for (long i = 2; i * i < n; i++) {
            if (!primeTracker[(int)i]) {
                for (long j = i; j * i < n; j++) {
                    primeTracker[(int)(i * j)] = true;
                }
            }
        }
    }
}